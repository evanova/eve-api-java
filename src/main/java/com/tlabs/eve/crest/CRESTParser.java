package com.tlabs.eve.crest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlabs.eve.EveParser;

import java.io.IOException;
import java.io.InputStream;

public abstract class CRESTParser<T extends CRESTResponse> implements EveParser<T> {
    private static final ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final Class<T> responseClass;

    public CRESTParser(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;
    }

    @Override
    public T parse(InputStream in) throws IOException {
        try {
            return mapper.readValue(in, this.responseClass);
        }
        catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

}
