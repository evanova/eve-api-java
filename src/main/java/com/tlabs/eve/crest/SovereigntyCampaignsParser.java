package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public final class SovereigntyCampaignsParser extends CRESTParser<SovereigntyCampaignsResponse> {

    private static final long CACHE = 1000l * 60l * 5l; //5mn

    public SovereigntyCampaignsParser() {
        super(SovereigntyCampaignsResponse.class);
    }

    @Override
    public SovereigntyCampaignsResponse parse(InputStream in) throws IOException {
        SovereigntyCampaignsResponse response = super.parse(in);
        response.setCachedUntil(System.currentTimeMillis() + CACHE);
        return response;
    }

}
