package com.tlabs.eve.api.character;

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

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class CharacterInfoParser extends EveAPIParser<CharacterInfoResponse> {

	public CharacterInfoParser() {
		super(CharacterInfoResponse.class);		
	}
	
	@Override
	protected void onInit(Digester digester) {
		digester.addObjectCreate("eveapi/result", EveCharacterInfo.class);
		digester.addRule("eveapi/result", new SetNextRule("setCharacterInfo"));
		//Share this instance 
		//(quite unusual for the digester, but in this particular case it's ok)
		SetElementPropertyRule setElementPropertyRule = new SetElementPropertyRule();
		digester.addRule("eveapi/result/characterID", setElementPropertyRule);
		digester.addRule("eveapi/result/skillPoints", setElementPropertyRule);
		digester.addRule("eveapi/result/shipName", setElementPropertyRule);
		digester.addRule("eveapi/result/shipTypeID", setElementPropertyRule);
		digester.addRule("eveapi/result/shipTypeName", setElementPropertyRule);
		digester.addRule("eveapi/result/corporationDate", setElementPropertyRule);
		digester.addRule("eveapi/result/allianceID", setElementPropertyRule);
		digester.addRule("eveapi/result/alliance", setElementPropertyRule);
		digester.addRule("eveapi/result/alliancenDate", setElementPropertyRule);
		digester.addRule("eveapi/result/lastKnownLocation", setElementPropertyRule);
		digester.addRule("eveapi/result/securityStatus", setElementPropertyRule);
	}	
}
