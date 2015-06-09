package com.tlabs.eve.parser;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateDeserializer extends JsonDeserializer<Long> {
    @Override
    public Long deserialize(
            JsonParser jp,
            DeserializationContext context) throws IOException {

        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(jp.getText()).getTime();
        }
        catch (ParseException e) {
            throw new IOException("Cannot evaluate boolean with value '" + jp.getText() + "': " + e.getLocalizedMessage());
        }
    }
}
