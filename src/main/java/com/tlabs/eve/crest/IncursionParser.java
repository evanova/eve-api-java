package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public final class IncursionParser extends CRESTParser<IncursionResponse> {
    private static final long CACHE = 1000l * 60l * 60l; //1H

    public IncursionParser() {
        super(IncursionResponse.class);
    }

    @Override
    public IncursionResponse parse(InputStream in) throws IOException {
        final IncursionResponse response = super.parse(in);
        response.setCachedUntil(System.currentTimeMillis() + CACHE);
        return response;
    }
}
