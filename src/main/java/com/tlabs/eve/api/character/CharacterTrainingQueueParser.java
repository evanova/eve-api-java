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


import java.util.HashMap;

import org.apache.commons.digester.Digester;

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public class CharacterTrainingQueueParser extends EveAPIParser<CharacterTrainingQueueResponse> {

	private static final HashMap<String, String> properties;
	static {
		properties = new HashMap<String, String>();
		properties.put("queuePosition", "queuePosition");
		properties.put("typeID", "skillID");
		properties.put("level", "skillLevel");
		properties.put("startSP", "startSkillPoints");
		properties.put("endSP", "endSkillPoints");
		properties.put("startTime", "startTime");
		properties.put("endTime", "endTime");				
	}
	
	public CharacterTrainingQueueParser() {
		super(CharacterTrainingQueueResponse.class);		
	}

	@Override
	protected void onInit(Digester digester) {
		digester.addObjectCreate("eveapi/result/rowset/row", SkillInTraining.class);
		digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(properties));
		digester.addRule("eveapi/result/rowset/row", new SetNextRule("addTraining"));
	}

}
