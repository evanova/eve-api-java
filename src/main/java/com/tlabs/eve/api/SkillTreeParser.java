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
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

import com.tlabs.eve.api.parser.BaseRule;
import com.tlabs.eve.api.parser.EveXMLParser;

public class SkillTreeParser extends EveXMLParser<SkillTreeResponse>{

	private static class SkillRowSetRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			EveSkill skill = (EveSkill)getDigester().peek();
			
			String typeID = attributes.getValue("typeID");
			if (StringUtils.isNotBlank(typeID)) {
				//that's a required skill ID and its level
				skill.addRequiredSkill(
						Integer.parseInt(typeID), 
						Integer.parseInt(attributes.getValue("skillLevel")));
				return;
			}
			
			/*String bonusType = attributes.getValue("bonusType");
			if (StringUtils.isNotBlank(bonusType)) {
				skill.addSkillBonus(
						bonusType,
						attributes.getValue("bonusValue"));
				return;
			}	*/		
		}	
	}
	
	public SkillTreeParser() {
		super(SkillTreeResponse.class);
	}

	@Override
	protected void onInit(Digester digester) {
		digester.addObjectCreate(
				"eveapi/result", 
				EveSkillTree.class);
		
		digester.addRule(
				"eveapi/result", 
				new com.tlabs.eve.api.parser.SetNextRule("setSkillTree"));
		
		digester.addObjectCreate(
				"eveapi/result/rowset/row", 
				EveSkillTree.SkillGroup.class);
		
		digester.addRule(
				"eveapi/result/rowset/row", 
				new com.tlabs.eve.api.parser.SetAttributePropertyRule(
						"groupName", "groupID"));
		
		digester.addRule(
				"eveapi/result/rowset/row", 
				new com.tlabs.eve.api.parser.SetNextRule("addGroup"));
		
		digester.addObjectCreate(
				"eveapi/result/rowset/row/rowset/row", EveSkill.class);

		digester.addRule(
				"eveapi/result/rowset/row/rowset/row", 
				new com.tlabs.eve.api.parser.SetNextRule("addSkill"));
		
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("typeName", "skillName");
		attributes.put("typeID", "skillID");
		attributes.put("published", "published");
		
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row", 
				new com.tlabs.eve.api.parser.SetAttributePropertyRule(attributes));
		
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row/description", 
				new com.tlabs.eve.api.parser.SetElementPropertyRule());
		
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row/rank", 
				new com.tlabs.eve.api.parser.SetElementPropertyRule());
		
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row/requiredAttributes/primaryAttribute", 
				new com.tlabs.eve.api.parser.SetElementPropertyRule());
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row/requiredAttributes/secondaryAttribute", 
				new com.tlabs.eve.api.parser.SetElementPropertyRule());
				
		digester.addRule(
				"eveapi/result/rowset/row/rowset/row/rowset/row", 
				new SkillRowSetRule());		
	}	
}
