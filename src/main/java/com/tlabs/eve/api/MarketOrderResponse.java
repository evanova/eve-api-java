package com.tlabs.eve.api;

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


import java.util.LinkedList;
import java.util.List;


public class MarketOrderResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8260545530317659668L;

    private List<MarketOrder> buyOrders;
	private List<MarketOrder> sellOrders;
	
	public MarketOrderResponse() {
		super();		
		this.buyOrders = new LinkedList<MarketOrder>();
		this.sellOrders = new LinkedList<MarketOrder>();
	}

	public List<MarketOrder> getBuyOrders() {
		return this.buyOrders;
	}
	
	public List<MarketOrder> getSellOrders() {
		return this.sellOrders;
	}
	
	public void addOrder(MarketOrder order) {
		if (order.getIsBuyOrder()) {
			this.buyOrders.add(order);
		}
		else {
			this.sellOrders.add(order);
		}
	}
}
