package com.tlabs.eve.api.mail;

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

import com.tlabs.eve.api.character.EveCharacter;

public class KillMail extends Object implements Serializable {

	private static final long serialVersionUID = -1891358193881112867L;
/* <row killID="63" solarSystemID="30000848" killTime="2007-11-15 15:36:00" moonID="0">
        <victim characterID="150340823" characterName="Dieinafire" corporationID="1000169"
                corporationName="Center for Advanced Studies" allianceID="0"
                allianceName="" factionID="0" factionName=""
                damageTaken="6378" shipTypeID="12003" />
        <rowset name="attackers" columns="characterID,characterName,corporationID,corporationName,allianceID,allianceName,
                factionID,factionName,securityStatus,damageDone,finalBlow,weaponTypeID,shipTypeID">
          <row characterID="0" characterName="" corporationID="1000127" corporationName="Guristas"
               allianceID="0" allianceName="" factionID="0" factionName="" securityStatus="0" 
               damageDone="6313" finalBlow="1" weaponTypeID="0" shipTypeID="203" />
          <row characterID="0" characterName="" corporationID="150279367" corporationName="Starbase Anchoring Corp"
               allianceID="0" allianceName="" securityStatus="0" damageDone="65" finalBlow="0"
               weaponTypeID="0" shipTypeID="16632" />
        </rowset>
        <rowset name="items" columns="typeID,flag,qtyDropped,qtyDestroyed,singleton" />*/
	
	private long killID;
	private long solarSystemID;
	private long moonID;
	
	private long killTime;
	
	private EveCharacter victim;
	
	private long damageTaken;
	private long shipTypeID;
	
	public long getKillID() {
		return killID;
	}

	public void setKillID(long killID) {
		this.killID = killID;
	}

	public long getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(long solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public long getMoonID() {
		return moonID;
	}

	public void setMoonID(long moonID) {
		this.moonID = moonID;
	}

	public long getKillTime() {
		return killTime;
	}

	public void setKillTime(long killTime) {
		this.killTime = killTime;
	}

	public long getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(long damageTaken) {
		this.damageTaken = damageTaken;
	}

	public long getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(long shipTypeID) {
		this.shipTypeID = shipTypeID;
	}
	
}
