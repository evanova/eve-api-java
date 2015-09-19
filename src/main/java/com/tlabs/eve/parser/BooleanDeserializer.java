package com.tlabs.eve.parser;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(
            JsonParser jp,
            DeserializationContext context) throws IOException {

        final String jpText = jp.getText().trim().toLowerCase();
        if ("0".equals(jpText)) {
            return false;
        }
        if ("1".equals(jpText)) {
            return true;
        }
        if ("-1".equals(jpText)) {
            return false;
        }
        if ("true".equals(jpText)) {
            return true;
        }
        if ("false".equals(jpText)) {
            return false;
        }
        throw new IOException("Cannot evaluate boolean with value '" + jp.getText() + "'");
    }
}
