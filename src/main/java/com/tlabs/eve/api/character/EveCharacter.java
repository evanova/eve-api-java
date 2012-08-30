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


import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.corporation.CorporationRole;
import com.tlabs.eve.api.corporation.CorporationTitle;

public class EveCharacter extends Object implements Serializable {

	private static final long serialVersionUID = -6450367183672623211L;

	public static class AttributeEnhancer extends Object implements Serializable {
		
		private static final long serialVersionUID = 2889918310631341232L;
		
		private String augmentatorName;
		private int augmentatorValue;
		
		public String getAugmentatorName() {
			return augmentatorName;
		}
		public void setAugmentatorName(String augmentatorName) {
			this.augmentatorName = augmentatorName;
		}
		public int getAugmentatorValue() {
			return augmentatorValue;
		}
		
		public void setAugmentatorValue(int augmentatorValue) {
			this.augmentatorValue = augmentatorValue;
		}				
		
		public void setAugmentatorValue(String augmentatorValue) {
			this.augmentatorValue = Integer.parseInt(augmentatorValue);
		}
	}
	
	private long characterID;
	private String characterName;
	private long birthdate;
	
	private long corporationID;
	private String corporationName;
	
	private long allianceID;
	private String allianceName;
		
	private long factionID;
	private String factionName;
	
	private double balance;
	
	private String cloneName;
	private long cloneSkillPoints;
	
	private String gender;
	private String bloodLine;
	private String ancestry;
	private String race;
	
	private List<CharacterSkill> skills;
	private Map<Long, CharacterSkill> skillsMap;//skills per ID	
	private long skillPoints = 0; //computed
	
	private int intelligence;
	private AttributeEnhancer intelligenceEnhancer;
	
	private int charisma;
	private AttributeEnhancer charismaEnhancer;
	
	private int willpower;
	private AttributeEnhancer willpowerEnhancer;
	
	private int perception;
	private AttributeEnhancer perceptionEnhancer;
	
	private int memory;
	private AttributeEnhancer memoryEnhancer;
	
	private List<CorporationRole> corporationRoles;
	private List<CorporationTitle> corporationTitles;
	private List<Long> certificates;//ids
	
	public EveCharacter() {
		super();
		this.skills = new LinkedList<CharacterSkill>();		
		this.skillsMap = new HashMap<Long, CharacterSkill>();
		this.corporationRoles = new LinkedList<CorporationRole>();
		this.corporationTitles = new LinkedList<CorporationTitle>();
		this.certificates = new LinkedList<Long>();
	}
	
	public EveCharacter(EveCharacter other) {
		this();
		
		this.characterID = other.characterID;
		this.characterName = other.characterName;

		this.corporationID = other.corporationID;
		this.corporationName = other.corporationName;
			
		this.balance = other.balance;
		
		this.cloneName = other.cloneName;
		this.cloneSkillPoints = other.cloneSkillPoints;
		
		this.gender = other.gender;
		this.bloodLine = other.bloodLine;
		this.race = other.race;
	}
	
	public long getSkillPoints() {
		return skillPoints;
	}

	public void addSkill(CharacterSkill skill) {
		this.skills.add(skill);
		this.skillsMap.put(skill.getSkillID(), skill);
		this.skillPoints = this.skillPoints + skill.getSkillPoints();
	}
	
	public CharacterSkill getSkill(int skillID) {
		return this.skillsMap.get(skillID);
	}
	
	public int getSkillLevel(int skillID) {
		CharacterSkill skill = this.skillsMap.get(skillID);
		return (null == skill) ? 0 : skill.getSkillLevel();
	}
	
	public long getSkillPoints(int skillID) {
		CharacterSkill skill = this.skillsMap.get(skillID);
		return (null == skill) ? 0l : skill.getSkillPoints();
	}
		
	public List<CharacterSkill> getSkills() {
		return this.skills;		
	}
		
	public List<CorporationRole> getRoles() {
		return corporationRoles;
	}
	
	public void addRole(CorporationRole r) {
		this.corporationRoles.add(r);
	}

	public List<CorporationTitle> getTitles() {
		return corporationTitles;
	}
	
	public void addTitle(CorporationTitle t) {
		this.corporationTitles.add(t);
	}
	
	public List<Long> getCertificates() {
		return this.certificates;
	}
	
	public void addCertificate(long c) {
		this.certificates.add(c);
	}
	
	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAllianceName() {
		return allianceName;
	}

	public void setAllianceName(String allianceName) {
		this.allianceName = allianceName;
	}

	public long getFactionID() {
		return factionID;
	}

	public void setFactionID(long factionID) {
		this.factionID = factionID;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getCloneName() {
		return cloneName;
	}

	public void setCloneName(String cloneName) {
		this.cloneName = cloneName;
	}

	public long getCloneSkillPoints() {
		return cloneSkillPoints;
	}

	public void setCloneSkillPoints(long cloneSkillPoints) {
		this.cloneSkillPoints = cloneSkillPoints;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodLine() {
		return bloodLine;
	}

	public void setBloodLine(String bloodLine) {
		this.bloodLine = bloodLine;
	}

	public final String getAncestry() {
		return ancestry;
	}

	public final void setAncestry(String ancestry) {
		this.ancestry = ancestry;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getIntelligence() {
		return intelligence;
	}
	
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	public void setIntelligence(String intelligence) {
		this.intelligence = Integer.parseInt(intelligence);
	}
	
	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public void setCharisma(String charisma) {
		this.charisma = Integer.parseInt(charisma);
	}

	public int getWillpower() {
		return willpower;
	}

	public void setWillpower(int willpower) {
		this.willpower = willpower;
	}

	public void setWillpower(String willpower) {
		this.willpower = Integer.parseInt(willpower);
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public void setPerception(String perception) {
		this.perception = Integer.parseInt(perception);
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	public void setMemory(String memory) {
		this.memory = Integer.parseInt(memory);
	}

	public AttributeEnhancer getIntelligenceEnhancer() {
		return intelligenceEnhancer;
	}

	public void setIntelligenceEnhancer(AttributeEnhancer intelligenceEnhancer) {
		this.intelligenceEnhancer = intelligenceEnhancer;
	}

	public AttributeEnhancer getCharismaEnhancer() {
		return charismaEnhancer;
	}

	public void setCharismaEnhancer(AttributeEnhancer charismaEnhancer) {
		this.charismaEnhancer = charismaEnhancer;
	}

	public AttributeEnhancer getWillpowerEnhancer() {
		return willpowerEnhancer;
	}

	public void setWillpowerEnhancer(AttributeEnhancer willpowerEnhancer) {
		this.willpowerEnhancer = willpowerEnhancer;
	}

	public AttributeEnhancer getPerceptionEnhancer() {
		return perceptionEnhancer;
	}

	public void setPerceptionEnhancer(AttributeEnhancer perceptionEnhancer) {
		this.perceptionEnhancer = perceptionEnhancer;
	}

	public AttributeEnhancer getMemoryEnhancer() {
		return memoryEnhancer;
	}

	public void setMemoryEnhancer(AttributeEnhancer memoryEnhancer) {
		this.memoryEnhancer = memoryEnhancer;
	}
		
	public Integer getIntelligenceEnhancerValue() {
		return (null == intelligenceEnhancer) ? null : intelligenceEnhancer.getAugmentatorValue();
	}
	
	public String getIntelligenceEnhancerName() {
		return (null == intelligenceEnhancer) ? null : intelligenceEnhancer.getAugmentatorName();
	}
	
	public Integer getMemoryEnhancerValue() {
		return (null == memoryEnhancer) ? null : memoryEnhancer.getAugmentatorValue();
	}
	
	public String getMemoryEnhancerName() {
		return (null == memoryEnhancer) ? null : memoryEnhancer.getAugmentatorName();
	}
	
	public Integer getCharismaEnhancerValue() {
		return (null == charismaEnhancer) ? null : charismaEnhancer.getAugmentatorValue();
	}
	
	public String getCharismaEnhancerName() {
		return (null == charismaEnhancer) ? null : charismaEnhancer.getAugmentatorName();
	}
	
	public Integer getWillpowerEnhancerValue() {
		return (null == willpowerEnhancer) ? null : willpowerEnhancer.getAugmentatorValue();
	}
	
	public String getWillpowerEnhancerName() {
		return (null == willpowerEnhancer) ? null : willpowerEnhancer.getAugmentatorName();
	}

	public Integer getPerceptionEnhancerValue() {
		return (null == perceptionEnhancer) ? null : perceptionEnhancer.getAugmentatorValue();
	}
	
	public String getPerceptionEnhancerName() {
		return (null == perceptionEnhancer) ? null : perceptionEnhancer.getAugmentatorName();
	}

	public final long getBirthdate() {
		return birthdate;
	}

	public final void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}

	public final void setBirthdate(String birthdate) {
		this.birthdate = EveAPI.parseDateTime(birthdate);
	}
}
