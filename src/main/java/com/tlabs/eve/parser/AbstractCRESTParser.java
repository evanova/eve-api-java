package com.tlabs.eve.parser;

import java.io.IOException;
import java.io.InputStream;

import com.tlabs.eve.EveResponse;

public abstract class AbstractCRESTParser<T extends EveResponse> extends AbstractEveParser<T> {
    
    public AbstractCRESTParser(final Class<T> responseClass) {
        super(responseClass);
    }

    @Override
    protected T doParse(InputStream in, T response) throws IOException {
        return response;
    }
}
