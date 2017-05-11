package com.tlabs.eve.esi.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import org.joda.time.DateTime;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.lang.reflect.Type;

final class ESIConverters {

    public static class GSONDateTimeDeserializer implements com.google.gson.JsonDeserializer<DateTime> {

        @Override
        public DateTime deserialize(
                com.google.gson.JsonElement element,
                Type arg1,
                com.google.gson.JsonDeserializationContext arg2) throws JsonParseException {
            String date = element.getAsString();
            return DateTime.parse(date);
        }
    }

    private static final Converter.Factory GSON;
    private static final Converter.Factory JACKSON;

    static {
        JACKSON = JacksonConverterFactory.create(
                new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL));

        GSON = GsonConverterFactory.create(
                new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new GSONDateTimeDeserializer())
                .create());
    }


    private ESIConverters() {}

    public static Converter.Factory gson() {return GSON;}

    public static Converter.Factory jackson() {return JACKSON;}
}
