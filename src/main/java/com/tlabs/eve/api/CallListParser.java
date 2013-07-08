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
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
/**@since Eve API V3 (30 Aug 2011*/
public class CallListParser extends EveAPIParser<CallListResponse>{

	private static class GroupOrEntryRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {			
			String rowsetName = attributes.getValue("name");
			if ("callGroups".equalsIgnoreCase(rowsetName)) {
				CallGroup g = new CallGroup();
				digester.push(g);
			}
			else if ("calls".equalsIgnoreCase(rowsetName)) {
				CallEntry e = new CallEntry();
				digester.push(e);
			}
			else {				
			}
		}

		@Override
		public void doEnd(String name) {
			Object o = digester.pop();
			CallListResponse r = (CallListResponse)digester.peek();
			if (o instanceof CallGroup) {
				r.addGroup((CallGroup)o);
			}
			else if (o instanceof CallEntry) {
				r.addEntry((CallEntry)o);
			}
		}		
	}
	

	public CallListParser() {
		super(CallListResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {
		digester.addRule("eveapi/result/rowset", new GroupOrEntryRule());
		digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
	}	
}
