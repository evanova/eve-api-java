package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public final class MarketHistoryParser extends CRESTParser<MarketHistoryResponse> {

    //Cache time is 1H on Eve servers, but make it 12 since it's history data and they start at the previous day.
    private static final long CACHE = 1000l * 60l * 60l * 12l; //12H

    public MarketHistoryParser() {
        super(MarketHistoryResponse.class);
    }

    @Override
    public MarketHistoryResponse parse(InputStream in) throws IOException {
        MarketHistoryResponse response = super.parse(in);
        response.setCachedUntil(System.currentTimeMillis() + CACHE);
        return response;
    }

}
