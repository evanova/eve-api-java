package com.tlabs.eve.api.evemon;

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


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.character.CharacterTrainingQueueResponse;
import com.tlabs.eve.api.character.SkillInTraining;
import com.tlabs.eve.api.character.TrainingQueue;
import com.tlabs.eve.api.parser.AbstractXMLParser;
import com.tlabs.eve.api.parser.BaseRule;
import com.tlabs.eve.api.parser.SetNextRule;

public final class EveMonSkillPlanParser extends AbstractXMLParser<CharacterTrainingQueueResponse> {
	
	private static final class PropertyRules extends BaseRule {
		@Override
		public void doBegin(String name, Attributes attributes) {
			SkillInTraining t = (SkillInTraining)getDigester().peek();
			t.setSkillID(Long.parseLong(attributes.getValue("skillID")));
			t.setSkillLevel(Integer.parseInt(attributes.getValue("level")));
			t.setSkillName(attributes.getValue("skill"));
			String type = attributes.getValue("type");
			if ("prerequisite".equalsIgnoreCase(type)) {
				t.setType(SkillInTraining.Type.REQUIRED);
			}
			else {
				t.setType(SkillInTraining.Type.PLAN);
			}
		}		
	}
	
	public EveMonSkillPlanParser() {
		super(CharacterTrainingQueueResponse.class);		
	}
	

	public static int export(
			final String title,
			final TrainingQueue queue, 
			final OutputStream out) throws IOException {	
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(out));
		w.write("<?xml version=\"1.0\"?>\n");
		w.write("<plan xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" name=\"" + title + "\" revision=\"3860\">");
		
		int i = 0;
		for (SkillInTraining t: queue) {
			//<entry skillID="24572" skill="Capital Energy Emission Systems" level="2" priority="3" type="Prerequisite">
			String type = "";
			switch (t.getType()) {
			case COMPLETED:
			case QUEUE:
				i++;
				continue;				
			case PLAN:
				type = "Planned";
				break;			
			case REQUIRED:
				type = "Prerequisite";
				break;
			}
			w.write(
				"\n\t<entry skillID=\"" + 
				t.getSkillID() + "\" skill=\"" + t.getSkillName() + 
				"\" level=\"" + t.getSkillLevel() + "\" priority=\"" + i + "\" type=\"" + type + "\"/>");			
			w.flush();
			i++;
		}
		w.write("\n</plan>");
		w.flush();
		return i;
	}
		
	protected void init(final Digester digester) {
		digester.addObjectCreate("plan/entry", SkillInTraining.class);
		digester.addRule("plan/entry", new PropertyRules());
		digester.addRule("plan/entry", new SetNextRule("addTraining"));
	}
}
