package com.tlabs.eve.crest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tlabs.eve.EveNetwork;
import com.tlabs.eve.crest.MarketPrice;
import com.tlabs.eve.crest.MarketPricesRequest;
import com.tlabs.eve.crest.MarketPricesResponse;
import com.tlabs.eve.net.DefaultEveNetwork;

public class MarketPricesRequestTests {

	@Test
	public void testRetrieveListingsForNullSInTheForge() {
		EveNetwork eve = new DefaultEveNetwork();
		
		final MarketPricesRequest request = new MarketPricesRequest(10000002,"sell",12614);
		
		final MarketPricesResponse response = eve.execute(request);
		
		List<MarketPrice> listings = response.getMarketPrices();
		
		assertNotNull(listings);
		assertTrue("Listings not empty", listings.size() > 0);
	}

}
;