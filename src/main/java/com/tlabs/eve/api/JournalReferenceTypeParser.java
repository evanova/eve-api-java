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

public class JournalReferenceTypeParser extends EveAPIParser<JournalReferenceTypeResponse>{
	
	private static final class AddRefRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			JournalReferenceTypeResponse r = (JournalReferenceTypeResponse)this.digester.peek();
			r.addReference(Long.parseLong(attributes.getValue("refTypeID")), attributes.getValue("refTypeName"));
		}		
	}
	
	public JournalReferenceTypeParser() {
		super(JournalReferenceTypeResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {
		digester.addRule("eveapi/result/rowset/row", new AddRefRule());
	}	
}
