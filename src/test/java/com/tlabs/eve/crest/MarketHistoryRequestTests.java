package com.tlabs.eve.crest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

import com.tlabs.eve.EveNetwork;
import com.tlabs.eve.net.DefaultEveNetwork;

public class MarketHistoryRequestTests {

	@Test
	public void testGetHistoryForTritanium() {
		EveNetwork eve = new DefaultEveNetwork();
		
		MarketHistoryRequest request = new MarketHistoryRequest(10000002,34);
		
		MarketHistoryResponse response = eve.execute(request);
		
		System.out.println(ToStringBuilder.reflectionToString(response));
		
		for ( MarketTransaction transaction : response.getHistory() ) {
			System.out.println(ToStringBuilder.reflectionToString(transaction));
		}
	}

}