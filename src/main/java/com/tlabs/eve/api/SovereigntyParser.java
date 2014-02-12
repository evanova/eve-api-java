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

import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class SovereigntyParser extends EveAPIParser<SovereigntyResponse> {
	
	public SovereigntyParser() {
		super(SovereigntyResponse.class);
	} 
	
	@Override
	protected void onInit(Digester digester) {		
	    digester.addObjectCreate("eveapi/result/rowset/row", Sovereignty.class);
        
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());                 
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addSovereignty"));
	}	
}
