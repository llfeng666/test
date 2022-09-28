package com.liquido.enums.models;

import java.io.IOException;

import com.liquido.enums.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize(using = BaseError.BaseErrorSerializer.class)
@JsonDeserialize(using = BaseError.BaseErrorDeserializer.class)
public class BaseError {
    @NonNull
    ResultCode code;

    @NonNull
    String errorMessage;

    @NonNull
    public ResultCode getCode() {
        return code;
    }

    @NonNull
    public String getErrorMessage() {
        return errorMessage;
    }

    static class BaseErrorSerializer extends JsonSerializer<BaseError> {
        @Override
        public void serialize(
                final BaseError baseError,
                final JsonGenerator gen,
                final SerializerProvider serializer
        ) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("code", String.valueOf(baseError.getCode().getCode()));
            gen.writeStringField("errorMessage", baseError.getErrorMessage());
            gen.writeEndObject();
        }
    }

    static class BaseErrorDeserializer extends JsonDeserializer<BaseError> {
        @Override
        public BaseError deserialize(
                final JsonParser p,
                final DeserializationContext ctx) throws IOException {
            try {
                final var node = (JsonNode) p.readValueAsTree();
                final var resultCode
                        = ResultCode.fromCode(Integer.parseInt(node.get("code").textValue()));
                final var errorMessage = node.get("errorMessage").textValue();

                return BaseError.builder()
                        .code(resultCode)
                        .errorMessage(errorMessage)
                        .build();

            } catch (Exception e) {
                throw new JsonParseException(p, "Invalid BaseError", e);
            }
        }
    }
}
