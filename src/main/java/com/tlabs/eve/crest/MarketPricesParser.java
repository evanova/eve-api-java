package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public class MarketPricesParser extends CRESTParser<MarketPricesResponse> {
	public MarketPricesParser() {
		super(MarketPricesResponse.class);
	}
	
	@Override
	public MarketPricesResponse parse(InputStream in) throws IOException {
		MarketPricesResponse response = super.parse(in);
		response.setCachedUntil(System.currentTimeMillis() + 1000l);
		return response;
	}
}
