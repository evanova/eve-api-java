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



public class EveCharacterInfo extends Object {
	
	private long characterID;
	private String lastKnownLocation;
	private float securityStatus;
	
	private long skillPoints = 0;
	
	private String shipName;
	private long shipTypeID;
	private String shipTypeName;
	
	private long corporationDate;
	private long allianceID = 0;
	private String alliance;
	private long allianceDate;
	
	public EveCharacterInfo() {
		super();
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getLastKnownLocation() {
		return lastKnownLocation;
	}

	public void setLastKnownLocation(String lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}

	public float getSecurityStatus() {
		return securityStatus;
	}

	public void setSecurityStatus(float securityStatus) {
		this.securityStatus = securityStatus;
	}

	public long getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(long skillPoints) {
		this.skillPoints = skillPoints;
	}
	
	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public long getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(long shipTypeID) {
		this.shipTypeID = shipTypeID;
	}
	
	public String getShipTypeName() {
		return shipTypeName;
	}

	public void setShipTypeName(String shipTypeName) {
		this.shipTypeName = shipTypeName;
	}

	public long getCorporationDate() {
		return corporationDate;
	}

	public void setCorporationDate(long corporationDate) {
		this.corporationDate = corporationDate;
	}

	public long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAlliance() {
		return alliance;
	}

	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}

	public long getAllianceDate() {
		return allianceDate;
	}

	public void setAllianceDate(long allianceDate) {
		this.allianceDate = allianceDate;
	}

}
