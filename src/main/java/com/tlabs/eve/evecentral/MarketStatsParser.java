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


import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.parser.BaseRule;
import com.tlabs.eve.api.parser.SetElementPropertyRule;

public final class MarketStatsParser extends EveCentralParser<MarketStatsResponse> {
	
	private static class IdRule extends BaseRule {
		@Override
		public void doBegin(String name, Attributes attributes) {
			getDigester().push(Long.parseLong(attributes.getValue("id")));
		}

		@Override
		public void doEnd(String name) {
			digester.pop();
		}				
	}
	
	private static class AddRule extends BaseRule {
		
		private final int type;
		
		public AddRule(final int type) {
			this.type = type;
		}
		
		@Override
		public void doBegin(String name, Attributes attributes) {			
			MarketPrice p = new MarketPrice();
			p.setID((Long)getDigester().peek());
			p.setType(this.type);		
			getDigester().push(p);
		}
		
		@Override
		public void doEnd(String name) {
			MarketPrice p = (MarketPrice)digester.pop();
			MarketStatsResponse r = (MarketStatsResponse)digester.peek(1);
			r.add(p);
		}	
	}
	
	public MarketStatsParser() {
		super(MarketStatsResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {		
		digester.addRule("evec_api/marketstat/type", new IdRule());
		digester.addRule("evec_api/marketstat/type/all", new AddRule(MarketPrice.MARKET));
		digester.addRule("evec_api/marketstat/type/buy", new AddRule(MarketPrice.BUY));
		digester.addRule("evec_api/marketstat/type/sell", new AddRule(MarketPrice.SELL));
		
		digester.addRule("evec_api/marketstat/type/*/volume", new SetElementPropertyRule("volume"));
		digester.addRule("evec_api/marketstat/type/*/avg", new SetElementPropertyRule("average"));
		digester.addRule("evec_api/marketstat/type/*/max", new SetElementPropertyRule("max"));
		digester.addRule("evec_api/marketstat/type/*/min", new SetElementPropertyRule("min"));
		digester.addRule("evec_api/marketstat/type/*/stddev", new SetElementPropertyRule("deviation"));
		digester.addRule("evec_api/marketstat/type/*/median", new SetElementPropertyRule("median"));
		digester.addRule("evec_api/marketstat/type/*/percentile", new SetElementPropertyRule("percentile"));
	}		
}
