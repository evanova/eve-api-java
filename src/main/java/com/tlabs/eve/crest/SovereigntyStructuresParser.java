package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public final class SovereigntyStructuresParser extends CRESTParser<SovereigntyStructuresResponse> {

    private static final long CACHE = 1000l * 60l * 5l; //5mn

    public SovereigntyStructuresParser() {
        super(SovereigntyStructuresResponse.class);
    }

    @Override
    public SovereigntyStructuresResponse parse(InputStream in) throws IOException {
        SovereigntyStructuresResponse response = super.parse(in);
        response.setCachedUntil(System.currentTimeMillis() + CACHE);
        return response;
    }

}
