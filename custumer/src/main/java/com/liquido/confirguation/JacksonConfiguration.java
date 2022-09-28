package com.liquido.confirguation;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({
        JavaTimeModule.class,
        Jdk8Module.class,
        ParameterNamesModule.class
})
public class JacksonConfiguration {
    @Bean
    public JsonMapper objectMapper(final Collection<Module> modules) {
        final JsonMapper jsonMapper =
                JsonMapper
                        .builder()
                        // This is common for preserving forward compatibility
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                        // To allow for different annotations
                        .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                        .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                        .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                        // This is high-overhead otherwise.
                        .configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, false)
                        // To preserve readability
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                        .configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false)
                        // Don't engage in JAXB-style behavior.
                        .configure(MapperFeature.USE_GETTERS_AS_SETTERS, false)
                        // For more flexibility
                        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
                        // Shame on our vendors...
                        // They could start a field with upper case in one instance of a json
                        // object and start the same field with lowercase in another instance
                        // of the same object...
                        // This is not ideal but should help us dodge another bullet in the future.
                        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                        .build();

        jsonMapper.registerModules(modules);
        // Include non absent properties. Mainly for returning responses to clients
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);

        return jsonMapper;
    }

    @Bean
    public XmlMapper objectMapeer(final Collection<Module> modules) {
        final XmlMapper xmlMapper =
                XmlMapper
                        .builder()
                        // This is common for preserving forward compatibility
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
                        // To allow for different annotations
                        .configure(JsonParser.Feature.ALLOW_COMMENTS, true)
                        .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                        .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                        // This is high-overhead otherwise.
                        .configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, false)
                        // To preserve readability
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                        .configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false)
                        // Don't engage in JAXB-style behavior.
                        .configure(MapperFeature.USE_GETTERS_AS_SETTERS, false)
                        // For more flexibility
                        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true)
                        // Shame on our vendors...
                        // They could start a field with upper case in one instance of a json
                        // object and start the same field with lowercase in another instance
                        // of the same object...
                        // This is not ideal but should help us dodge another bullet in the future.
                        .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                        .build();

        xmlMapper.registerModules(modules);
        // Include non absent properties. Mainly for returning responses to clients
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);

        return xmlMapper;
    }
}
