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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public class MarketOrderParser extends EveAPIParser<MarketOrderResponse> {

    private static final Map<String, String> attributes;
    static {
        attributes = new HashMap<String, String>();
        attributes.put("orderID", "orderID");
        attributes.put("charID", "characterID");
        attributes.put("stationID", "stationID");
        attributes.put("volEntered", "initialVolume");
        attributes.put("volRemaining", "remainingVolume");
        attributes.put("minVolume", "minVolume");
        attributes.put("orderState", "state");
        attributes.put("typeID", "itemID");
        attributes.put("range", "range");
        attributes.put("accountKey", "accountKey");
        attributes.put("escrow", "marketEscrow");
        attributes.put("price", "price");
        attributes.put("bid", "buyOrder");
        attributes.put("issued", "issueDate");
        attributes.put("duration", "durationInDays");
    }

    public MarketOrderParser() {
        super(MarketOrderResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", MarketOrder.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(attributes));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addOrder"));
    }
}
