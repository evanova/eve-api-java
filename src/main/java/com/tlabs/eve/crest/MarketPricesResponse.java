package com.tlabs.eve.crest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class MarketPricesResponse extends CRESTResponse {
	private static final long serialVersionUID = -8712542790502978719L;

	private List<MarketPrice> marketPrices = new ArrayList<>();
	
	@JsonProperty("items")
	public void setMarketPrices ( List<MarketPrice> marketPrices ) {
		this.marketPrices.addAll(marketPrices);
	}
	
	public void setMarketPrices ( MarketPrice marketPrices ) {
		this.marketPrices.add(marketPrices);
	}
	
	public List<MarketPrice> getMarketPrices ( ) {
		return this.marketPrices;
	}
}
