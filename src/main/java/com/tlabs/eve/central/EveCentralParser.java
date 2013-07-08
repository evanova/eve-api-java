package com.tlabs.eve.central;

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
import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.AbstractXMLParser;

public abstract class EveCentralParser<T extends EveCentralResponse> extends AbstractXMLParser<T> {
	
	private class InitRule extends Rule {
		@Override
		public void begin(String namespace, String name, Attributes attributes) throws Exception {
			long now = System.currentTimeMillis();
			T t = (T)getDigester().peek();
			t.setDateTime(now);			
			t.setCachedUntil(now + /*24 * */60 * 60 * 1000);//FIXME
		}		
	}
	
	public EveCentralParser(Class<T> responseClass) {
		super(responseClass);
	}
	
	protected void onInit(Digester digester) {		
	}
	
	@Override
	protected final void init(Digester digester) {		
		digester.addRule("evec_api", new InitRule());
		onInit(digester);
	}
}
