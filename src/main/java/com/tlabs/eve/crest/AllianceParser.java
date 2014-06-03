package com.tlabs.eve.crest;

import java.io.IOException;
import java.io.InputStream;

public final class AllianceParser extends CRESTParser<AllianceResponse> {
	private static final long CACHE = 1000l * 60l * 60l * 24l; //24H
	
    public AllianceParser() {
        super(AllianceResponse.class);        
    }
    

	@Override
	public AllianceResponse parse(InputStream in) throws IOException {
		final AllianceResponse response = super.parse(in);
		response.setCachedUntil(System.currentTimeMillis() + CACHE);
		return response;
	}
}
