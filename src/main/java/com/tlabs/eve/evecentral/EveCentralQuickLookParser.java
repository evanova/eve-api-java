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
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.parser.BaseRule;
import com.tlabs.eve.api.parser.SetElementPropertyRule;

public final class EveCentralQuickLookParser extends EveCentralParser<EveCentralQuickLookResponse> {

	private static class AddRule extends BaseRule {
		
		private final int type;
		
		public AddRule(final int type) {
			this.type = type;
		}
		
		@Override
		public void doBegin(String name, Attributes attributes) {			
			EveCentralOrder o = new EveCentralOrder();			
			o.setType(this.type);
			getDigester().push(o);
		}
		
		@Override
		public void doEnd(String name) {
		    EveCentralOrder p = (EveCentralOrder)digester.pop();
			EveCentralQuickLookResponse r = (EveCentralQuickLookResponse)digester.peek(0);
			r.add(p);
		}	
	}
	
	public EveCentralQuickLookParser() {
		super(EveCentralQuickLookResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {
	    digester.addRule("evec_api/quicklook/item", new SetElementPropertyRule("typeID"));
	    digester.addRule("evec_api/quicklook/itemname", new SetElementPropertyRule("typeName"));
	    digester.addRule("evec_api/quicklook/hours", new SetElementPropertyRule("postedLastInHours"));
	    digester.addRule("evec_api/quicklook/minqty", new SetElementPropertyRule("typeMinimumQuantity"));
	    
        digester.addRule("evec_api/quicklook/buy_orders/order", new AddRule(EveCentralOrder.BUY));
        digester.addRule("evec_api/quicklook/sell_orders/order", new AddRule(EveCentralOrder.SELL));
        
        //FIXME why is evec_api/quicklook/*/order/ not working?
		digester.addRule("evec_api/quicklook/buy_orders/order/region", new SetElementPropertyRule("regionID"));
		digester.addRule("evec_api/quicklook/buy_orders/order/station", new SetElementPropertyRule("stationID"));
		digester.addRule("evec_api/quicklook/buy_orders/order/station_name", new SetElementPropertyRule("stationName"));
		digester.addRule("evec_api/quicklook/buy_orders/order/security", new SetElementPropertyRule("security"));
		digester.addRule("evec_api/quicklook/buy_orders/order/price", new SetElementPropertyRule("price"));
		digester.addRule("evec_api/quicklook/buy_orders/order/vol_remain", new SetElementPropertyRule("volumeRemaining"));
		digester.addRule("evec_api/quicklook/buy_orders/order/min_volume", new SetElementPropertyRule("volumeMinimum"));
		digester.addRule("evec_api/quicklook/buy_orders/order/expires", new SetElementPropertyRule("timeExpired"));
		digester.addRule("evec_api/quicklook/buy_orders/order/reported_time", new SetElementPropertyRule("timeReported"));
		
		  //FIXME why is evec_api/quicklook/*/order/ not working?
        digester.addRule("evec_api/quicklook/sell_orders/order/region", new SetElementPropertyRule("regionID"));
        digester.addRule("evec_api/quicklook/sell_orders/order/station", new SetElementPropertyRule("stationID"));
        digester.addRule("evec_api/quicklook/sell_orders/order/station_name", new SetElementPropertyRule("stationName"));
        digester.addRule("evec_api/quicklook/sell_orders/order/security", new SetElementPropertyRule("security"));
        digester.addRule("evec_api/quicklook/sell_orders/order/price", new SetElementPropertyRule("price"));
        digester.addRule("evec_api/quicklook/sell_orders/order/vol_remain", new SetElementPropertyRule("remainingVolume"));
        digester.addRule("evec_api/quicklook/sell_orders/order/min_volume", new SetElementPropertyRule("minimumVolume"));
        digester.addRule("evec_api/quicklook/sell_orders/order/expires", new SetElementPropertyRule("timeExpired"));
        digester.addRule("evec_api/quicklook/sell_orders/order/reported_time", new SetElementPropertyRule("timeReported"));
		
	}		
}
