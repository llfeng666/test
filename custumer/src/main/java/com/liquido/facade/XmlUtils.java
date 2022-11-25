package com.liquido.facade;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class XmlUtils {

    private final XmlMapper xmlMapper;

    @Autowired
    public XmlUtils(final XmlMapper xmlMapper) {
        this.xmlMapper = xmlMapper;
    }

    public String encode(final Object obj) {
        try {
            return xmlMapper.writeValueAsString(obj);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException(String.format("error encoding xml, obj=%s", obj), e);
        }
    }

    public <T> T decode(final String xm, final Class<T> valueType)
            throws JsonProcessingException {
        return xmlMapper.readValue(xm, valueType);
    }

    public <T> T decode(final String xm, final TypeReference<T> typeReference)
            throws JsonProcessingException {
        return xmlMapper.readValue(xm, typeReference);
    }

    public <T> T decode(final byte[] xm, final Class<T> valueType) throws IOException {
        return xmlMapper.readValue(xm, valueType);
    }

    public <T> T decode(final byte[] xm, final TypeReference<T> typeReference)
            throws IOException {
        return xmlMapper.readValue(xm, typeReference);
    }
}
