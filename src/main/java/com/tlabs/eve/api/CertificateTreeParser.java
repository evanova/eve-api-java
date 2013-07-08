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


import java.util.LinkedList;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class CertificateTreeParser extends EveAPIParser<CertificateTreeResponse> {
	
	private static class Requirement {
		
		private List<EveSkill> skills = new LinkedList<EveSkill>();
		private List<Certificate> certificates = new LinkedList<Certificate>();
		
		private boolean skillRequirement;
		
		public Requirement(final boolean skillRequirement) {
			this.skillRequirement = skillRequirement;
		}

		public final List<EveSkill> getSkills() {
			return skills;
		}

		public final List<Certificate> getCertificates() {
			return certificates;
		}

        public boolean getSkillRequirement() {
            return skillRequirement;
        }
		
	}
	
	private static final class AddRequirementRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			super.doBegin(name, attributes);
			String n = attributes.getValue("name");
			if ("requiredSkills".equalsIgnoreCase(n)) {
				digester.push(new Requirement(true));
			}
			else if ("requiredCertificates".equalsIgnoreCase(n)) {
				digester.push(new Requirement(false));
			}
			else {
				
			}
		}

		@Override
		public void doEnd(String name) {
			if (getDigester().peek() instanceof Requirement) {
				Requirement r = (Requirement)getDigester().pop();
				Certificate c = (Certificate)getDigester().peek();
				for (EveSkill s: r.getSkills()) {
					c.addRequirement(s);
				}
				for (Certificate cert: r.getCertificates()) {
					c.addRequirement(cert);
				}				
			}
			super.doEnd(name);
		}
		
	}
	
	private static final class SetRequirementRule extends BaseRule {

		@Override
		public void doBegin(String name, Attributes attributes) {
			if (!(getDigester().peek() instanceof Requirement)) {
				return;
			}
			
			Requirement r = (Requirement)getDigester().peek();
			if (r.getSkillRequirement()) {
				EveSkill s = new EveSkill();
				s.setSkillID(Long.parseLong(attributes.getValue("typeID")));
				s.setRank(Integer.parseInt(attributes.getValue("level")));
				r.getSkills().add(s);
			}
			else {
				Certificate c = new Certificate();
				c.setCertificateID(Long.parseLong(attributes.getValue("certificateID")));
				c.setGrade(Integer.parseInt(attributes.getValue("grade")));
				r.getCertificates().add(c);
			}
		}

	}

	private static final class CompleteTreeRule extends BaseRule {

		@Override
		public void doEnd(String name) {			
			CertificateTree t = (CertificateTree)getDigester().peek();
			t.index();
		}
		
	}
	public CertificateTreeParser() {
		super(CertificateTreeResponse.class);
	}
	
	@Override
	protected void onInit(Digester digester) {				
		//<eveapi version="2">
		//<result>
		//<rowset name="categories" key="categoryID" columns="categoryID,categoryName">
		digester.addObjectCreate("eveapi/result/rowset", CertificateTree.class);
		digester.addRule("eveapi/result/rowset", new SetNextRule("setTree"));
		digester.addRule("eveapi/result/rowset", new CompleteTreeRule());
		
		//<row categoryID="3" categoryName="Core">
		digester.addObjectCreate("eveapi/result/rowset/row", CertificateTree.Category.class);
		digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
		digester.addRule("eveapi/result/rowset/row", new SetNextRule("addCategory"));
		
		//<rowset name="classes" key="classID" columns="classID,className">		
		//<row classID="2" className="Core Fitting">
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", CertificateTree.CategoryClass.class);
		digester.addRule("eveapi/result/rowset/row/rowset/row", new SetAttributePropertyRule());
		digester.addRule("eveapi/result/rowset/row/rowset/row", new SetNextRule("addClass"));
		
		//<rowset name="certificates" key="certificateID" columns="certificateID,grade,corporationID,description">

		//<row certificateID="5" grade="1" corporationID="1000125" description="This certificate represents a basic level of competence in fitting ships. It certifies that the holder is able to use baseline modules which improve power and CPU capabilities such as Co-Processors, Power Diagnostic Systems and Reactor Control Units. This is the first step towards broadening your fitting options.">
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row/rowset/row", Certificate.class);
		digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row", new SetAttributePropertyRule());
		digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row", new SetNextRule("addCertificate"));
		
		//<rowset name="requiredSkills" key="typeID" columns="typeID,skillLevel">
		digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset", new AddRequirementRule());
		digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new SetRequirementRule());
		//<row typeID="3413" level="3"/>
		
		//digester.addObjectCreate("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", EveSkill.class);
		//digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new SetAttributePropertyRule());
		//digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new SetNextRule("addRequirement"));
		//<rowset name="requiredCertificates" key="certificateID" columns="certificateID,grade">
        //<row certificateID="291" grade="1"/>
		//digester.addObjectCreate("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", Certificate.class);
		//digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new SetAttributePropertyRule());
		//digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row/rowset/row", new SetNextRule("addRequirement"));
	}
}
