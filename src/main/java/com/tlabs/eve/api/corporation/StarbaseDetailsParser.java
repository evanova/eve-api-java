package com.tlabs.eve.api.corporation;

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

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class StarbaseDetailsParser extends EveAPIParser<StarbaseDetailsResponse> {
	
    private static final class FuelMapRule extends BaseRule {
        private boolean isFuelMap = false;
        @Override
        public void doBegin(String name, Attributes attributes) {
            this.isFuelMap = "fuel".equalsIgnoreCase(attributes.getValue("name"));
            if (this.isFuelMap) {
                getDigester().push(new HashMap<Long, Long>());
            }            
        }

        @Override
        public void doEnd(String name) {
            if (this.isFuelMap) {
                final Map<Long, Long> fuelMap = (Map<Long, Long>)getDigester().pop();
                final Starbase starbase = (Starbase)digester.peek();
                starbase.setFuelMap(fuelMap);
                this.isFuelMap = false;
            }
        }
    }
    
    private static final class FuelRowRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            if (getDigester().peek() instanceof Map) {
                Map<Long, Long> fuelMap = (Map<Long, Long>)getDigester().peek();
                try {
                    fuelMap.put(Long.parseLong(attributes.getValue("typeID")), Long.parseLong(attributes.getValue("quantity")));
                }
                catch(NumberFormatException e) {
                    LOG.warn("StarbaseDetailsParser: invalid fuel row: " + e.getLocalizedMessage());
                }
            }
        }

        @Override
        public void doBody(String name, String text) {
            super.doBody(name, text);
        }

        @Override
        public void doEnd(String name) {
            super.doEnd(name);
        }
        
    }
    
	public StarbaseDetailsParser() {
		super(StarbaseDetailsResponse.class);
	}
	
	@Override
	protected void onInit(Digester digester) {
	    digester.addObjectCreate("eveapi/result/", Starbase.class);
	    digester.addRule("eveapi/result/", new SetNextRule("setStarbase"));
	    
	    digester.addRule("eveapi/result/state/", new SetElementPropertyRule());
	    digester.addRule("eveapi/result/onlineTimestamp/", new SetElementPropertyRule());
	    digester.addRule("eveapi/result/stateTimestamp/", new SetElementPropertyRule());

	    digester.addRule("eveapi/result/generalSettings/allowAllianceMembers/", new SetElementPropertyRule());
	    digester.addRule("eveapi/result/generalSettings/allowCorporationMembers/", new SetElementPropertyRule());
	    

        digester.addRule("eveapi/result/rowset/", new FuelMapRule());
        digester.addRule("eveapi/result/rowset/row", new FuelRowRule());
        
	    
	}	
}
