package com.tlabs.eve.api.server;

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


import java.util.TimeZone;

import org.apache.commons.digester.Digester;

import com.tlabs.eve.api.parser.EveXMLParser;
import com.tlabs.eve.api.parser.SetElementPropertyRule;

public final class ServerStatusParser extends EveXMLParser<ServerStatusResponse> {
	private static final int CACHE_IN_MN = 5;
	
	public ServerStatusParser() {
		super(ServerStatusResponse.class);
	}
	
	@Override
	protected void doAfterParse(ServerStatusResponse t) {
		long now = System.currentTimeMillis();		
		now = now - TimeZone.getDefault().getOffset(now);
		t.setCachedUntil(now + CACHE_IN_MN * 60l * 1000l);	
	}

	@Override
	protected void onInit(Digester digester) {		
		digester.addRule("eveapi/result/serverOpen", new SetElementPropertyRule());
		digester.addRule("eveapi/result/onlinePlayers", new SetElementPropertyRule());		
	}	
}
