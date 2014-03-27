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


import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

//@see http://wiki.eve-id.net/APIv2_Corp_CorporationSheet_XML
public class CorporationSheetParser extends EveAPIParser<CorporationSheetResponse>{
	
	private static final class CreateRowRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			super.doBegin(name, attributes);
			getDigester().push(attributes.getValue("name"));
		}
		@Override
		public void doEnd(String name) {
			getDigester().pop();
			super.doEnd(name);
		}
		
	}
	
	private static final class AddRowRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attr) {
			super.doBegin(name, attr);
			String type = (String)getDigester().peek();
			if ("walletDivisions".equalsIgnoreCase(type)) {
				CorporationSheet s = (CorporationSheet)getDigester().peek(1);
				s.addWalletDivision(
					Integer.parseInt(attr.getValue("accountKey")), 
					attr.getValue("description"));
				
			}
			else if ("divisions".equalsIgnoreCase(type)) {
				CorporationSheet s = (CorporationSheet)getDigester().peek(1);
				s.addHangarDivision(
					Integer.parseInt(attr.getValue("accountKey")), 
					attr.getValue("description"));
			}
			
		}		
	}
	
	public CorporationSheetParser() {
		super(CorporationSheetResponse.class);
	}
	
	@Override
	protected void onInit(Digester digester) {
		digester.addObjectCreate("eveapi/result", CorporationSheet.class);
		digester.addRule("eveapi/result", new SetNextRule("setCorporationInfo"));
		
		//FIXME: addRule("eveapi/result/*") doesnt match children of eveapi/result as I expected...
		//hence the long rule set
		digester.addRule("eveapi/result/corporationID", new SetElementPropertyRule());
		digester.addRule("eveapi/result/corporationName", new SetElementPropertyRule());
		digester.addRule("eveapi/result/ticker", new SetElementPropertyRule());
		digester.addRule("eveapi/result/ceoID", new SetElementPropertyRule());
		digester.addRule("eveapi/result/ceoName", new SetElementPropertyRule());
		digester.addRule("eveapi/result/stationID", new SetElementPropertyRule());
		digester.addRule("eveapi/result/stationName", new SetElementPropertyRule());
		digester.addRule("eveapi/result/description", new SetElementPropertyRule());
		digester.addRule("eveapi/result/url", new SetElementPropertyRule());
		digester.addRule("eveapi/result/allianceID", new SetElementPropertyRule());
		digester.addRule("eveapi/result/allianceName", new SetElementPropertyRule());
		digester.addRule("eveapi/result/factionID", new SetElementPropertyRule());
        digester.addRule("eveapi/result/factionName", new SetElementPropertyRule());
		digester.addRule("eveapi/result/taxRate", new SetElementPropertyRule());
		digester.addRule("eveapi/result/memberCount", new SetElementPropertyRule());
		digester.addRule("eveapi/result/memberLimit", new SetElementPropertyRule());
		digester.addRule("eveapi/result/shares", new SetElementPropertyRule());
		
		digester.addRule("eveapi/result/rowset", new CreateRowRule());
		digester.addRule("eveapi/result/rowset/row", new AddRowRule());
	}
}
