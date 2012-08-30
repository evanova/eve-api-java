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

import com.tlabs.eve.api.parser.EveXMLParser;
import com.tlabs.eve.api.parser.SetAttributePropertyRule;
import com.tlabs.eve.api.parser.SetNextRule;

public final class WalletJournalParser extends EveXMLParser<WalletJournalResponse> {

	private static final Map<String, String> attributes;
	static {
		attributes = new HashMap<String, String>();
		attributes.put("refID", "id");
		attributes.put("date", "when");
		attributes.put("refTypeID", "refTypeID");
		attributes.put("ownerID1", "ownerID1");
		attributes.put("ownerName1", "ownerName1");
		attributes.put("ownerID2", "ownerID2");
		attributes.put("ownerName2", "ownerName2");
		attributes.put("reason", "reason");
		attributes.put("amount", "amount");
		attributes.put("balance", "balance");
		attributes.put("argID1", "argID");
		attributes.put("argName1", "argName");
		attributes.put("taxReceiverID", "taxReceiverID");
		attributes.put("taxAmount", "taxAmount");
	}
	
	public WalletJournalParser() {
		super(WalletJournalResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {		
		digester.addObjectCreate("eveapi/result/rowset/row", WalletJournalEntry.class);
		
		digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(attributes));					
		digester.addRule("eveapi/result/rowset/row", new SetNextRule("addTransaction"));
	}
}
