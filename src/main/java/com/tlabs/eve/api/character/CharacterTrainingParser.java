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

import com.tlabs.eve.api.parser.EveXMLParser;
import com.tlabs.eve.api.parser.SetElementPropertyRule;
import com.tlabs.eve.api.parser.SetNextRule;

public final class CharacterTrainingParser extends EveXMLParser<CharacterTrainingResponse> {
	
	public CharacterTrainingParser() {
		super(CharacterTrainingResponse.class);
	}
	
	protected void onInit(Digester digester) {
		digester.addObjectCreate("eveapi/result", SkillInTraining.class);
		digester.addRule("eveapi/result", new SetNextRule("setTraining"));
		digester.addRule("eveapi/result/currentTQTime", new SetElementPropertyRule("queueTime"));
		digester.addRule("eveapi/result/trainingEndTime", new SetElementPropertyRule("endTime"));
		digester.addRule("eveapi/result/trainingStartTime", new SetElementPropertyRule("startTime"));
		digester.addRule("eveapi/result/trainingTypeID", new SetElementPropertyRule("skillID"));
		digester.addRule("eveapi/result/trainingStartSP", new SetElementPropertyRule("startSkillPoints"));
		digester.addRule("eveapi/result/trainingDestinationSP", new SetElementPropertyRule("endSkillPoints"));
		digester.addRule("eveapi/result/trainingToLevel", new SetElementPropertyRule("skillLevel"));
	}	
}
