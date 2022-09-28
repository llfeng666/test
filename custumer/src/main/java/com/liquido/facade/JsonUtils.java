package com.liquido.facade;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    private final JsonMapper jsonMapper;


    public JsonUtils(final JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public String encode(final Object obj) {
        try {
            return jsonMapper.writeValueAsString(obj);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException(String.format("error encoding json, obj=%s", obj), e);
        }
    }

    public JsonNode encodeToNode(final Object obj) {
        try {
            return jsonMapper.valueToTree(obj);
        } catch (final IllegalArgumentException e) {
            throw new RuntimeException(String.format("error encodeToNode, obj=%s", obj), e);
        }
    }

    public <T> T decode(final JsonNode json, final Class<T> valueType)
            throws JsonProcessingException {
        return jsonMapper.treeToValue(json, valueType);
    }

    public <T> T decode(final String json, final Class<T> valueType)
            throws JsonProcessingException {
        return jsonMapper.readValue(json, valueType);
    }

    public <T> T decode(final String json, final TypeReference<T> typeReference)
            throws JsonProcessingException {
        return jsonMapper.readValue(json, typeReference);
    }

    public <T> T decode(final byte[] json, final Class<T> valueType) throws IOException {
        return jsonMapper.readValue(json, valueType);
    }

    public <T> T decode(final byte[] json, final TypeReference<T> typeReference)
            throws IOException {
        return jsonMapper.readValue(json, typeReference);
    }
}
