package com.tlabs.eve.crest.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

class RefDeserializer extends StdDeserializer<String> {

    public RefDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        final JsonNode node = (JsonNode)p.getCodec().readTree(p).get("href");
        if (null == node) {
            return null;
        }
        return node.asText();
    }
}
