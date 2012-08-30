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


import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.parser.BaseRule;
import com.tlabs.eve.api.parser.EveXMLParser;

public class NamesParser extends EveXMLParser<NamesResponse> {
	
	private static final class SetKeyRule extends BaseRule {
		@Override
		public void doBegin(String name, Attributes attributes) {
			NamesResponse r = (NamesResponse)getDigester().peek();	
			r.setKey(attributes.getValue("key"));
		}
	}
	
	private static final class SetNameRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			NamesResponse r = (NamesResponse)getDigester().peek();	
			String key = r.getKey();
			if (StringUtils.isBlank(key)) {				
				return;
			}
			
			Long id = null;
			try {
				String cid = attributes.getValue(key);
				if (StringUtils.isNotBlank(cid)) {
					id = Long.parseLong(cid);
				}
			}
			catch (NumberFormatException e) {
				//Moooh
			}
			if (null == id) {
				return;//he?!
			}
			String charName = attributes.getValue("name");
			if (StringUtils.isNotBlank(charName)) {
				r.add(id, charName.trim());
			}
		}		
	}
	
	public NamesParser() {
		super(NamesResponse.class);
	}
	
	@Override
	protected void onInit(Digester digester) {		
		digester.addRule("eveapi/result/rowset", new SetKeyRule());
		digester.addRule("eveapi/result/rowset/row", new SetNameRule());		
	}
}
