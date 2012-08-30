package com.tlabs.eve.evecentral;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MarketStatsResponse extends EveCentralResponse {

	private Map<Long, List<MarketPrice>> marketPrices = new HashMap<Long, List<MarketPrice>>();
	private Map<Long, List<MarketPrice>> buyOrders = new HashMap<Long, List<MarketPrice>>();
	private Map<Long, List<MarketPrice>> sellOrders = new HashMap<Long, List<MarketPrice>>();
		
	public final Map<Long, List<MarketPrice>> getMarketPrices() {
		return marketPrices;
	}

	public final Map<Long, List<MarketPrice>> getBuyOrders() {
		return buyOrders;
	}

	public final Map<Long, List<MarketPrice>> getSellOrders() {
		return sellOrders;
	}

	public void add(MarketPrice p) {
		switch (p.getType()) {
		case MarketPrice.MARKET:
			add(this.marketPrices, p);			
			break;
		case MarketPrice.BUY:
			add(this.buyOrders, p);
			break;
		case MarketPrice.SELL:
			add(this.sellOrders, p);
			break;
		default:
			throw new IllegalArgumentException("Invalid MarketPrice.type " + p.getType());
		}
	}
	
	private static void add(Map<Long, List<MarketPrice>> prices, MarketPrice p) {
		List<MarketPrice> l = prices.get(Long.valueOf(p.getID()));
		if (null == l) {
			l = new LinkedList<MarketPrice>();
			prices.put(Long.valueOf(p.getID()), l);
		}
		l.add(p);
	}
}
