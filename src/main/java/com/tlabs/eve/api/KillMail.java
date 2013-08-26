package com.tlabs.eve.api;

/*
 * #%L This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova %% Copyright (C) 2010 - 2012 Evanova
 * (Traquenard Labs) %% Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. #L%
 */

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class KillMail extends Object implements Serializable {

    private static final long serialVersionUID = -1891358193881112867L;

    private static class Involved implements Serializable {
        
        private static final long serialVersionUID = -4352852587580693948L;
        
        private long characterID;
        private String characterName;
        
        private long corporationID;
        private String corporationName;
        
        private long allianceID;
        private String allianceName;
        
        private long factionID;
        private String factionName;

        private long shipTypeID;
        private String shipTypeName; //not in XML
        
        protected Involved() {}

        public final long getCharacterID() {
            return characterID;
        }

        public final void setCharacterID(long characterID) {
            this.characterID = characterID;
        }

        public final String getCharacterName() {
            return characterName;
        }

        public final void setCharacterName(String characterName) {
            this.characterName = characterName;
        }

        public final long getCorporationID() {
            return corporationID;
        }

        public final void setCorporationID(long corporationID) {
            this.corporationID = corporationID;
        }

        public final String getCorporationName() {
            return corporationName;
        }

        public final void setCorporationName(String corporationName) {
            this.corporationName = corporationName;
        }

        public final long getAllianceID() {
            return allianceID;
        }

        public final void setAllianceID(long allianceID) {
            this.allianceID = allianceID;
        }

        public final String getAllianceName() {
            return allianceName;
        }

        public final void setAllianceName(String allianceName) {
            this.allianceName = allianceName;
        }

        public final long getFactionID() {
            return factionID;
        }

        public final void setFactionID(long factionID) {
            this.factionID = factionID;
        }

        public final String getFactionName() {
            return factionName;
        }

        public final void setFactionName(String factionName) {
            this.factionName = factionName;
        }

        public final long getShipTypeID() {
            return shipTypeID;
        }

        public final void setShipTypeID(long shipTypeID) {
            this.shipTypeID = shipTypeID;
        }

        public final String getShipTypeName() {
            return shipTypeName;
        }

        public final void setShipTypeName(String shipTypeName) {
            this.shipTypeName = shipTypeName;
        };
                
    }
    
    public static final class Victim extends Involved {
        
        private static final long serialVersionUID = -4276984991545067644L;
        
        private long damateTaken;
        
        public Victim() {
            super();
        }
        
        public long getDamateTaken() {
            return damateTaken;
        }

        public void setDamateTaken(long damateTaken) {
            this.damateTaken = damateTaken;
        }

    }
    
    public static final class Attacker extends Involved {
        
        private static final long serialVersionUID = 8185151910449167245L;
        
        private float securityStatus;
        
        private long weaponTypeID;
        private String weaponTypeName;//not in XML
        
        private int damageDone;
        private boolean finalBlow;
        
        public Attacker() {
            super();
        }

        public float getSecurityStatus() {
            return securityStatus;
        }

        public void setSecurityStatus(float securityStatus) {
            this.securityStatus = securityStatus;
        }

        public long getWeaponTypeID() {
            return weaponTypeID;
        }

        public void setWeaponTypeID(long weaponTypeID) {
            this.weaponTypeID = weaponTypeID;
        }

        public String getWeaponTypeName() {
            return weaponTypeName;
        }

        public void setWeaponTypeName(String weaponTypeName) {
            this.weaponTypeName = weaponTypeName;
        }

        public int getDamageDone() {
            return damageDone;
        }

        public void setDamageDone(int damageDone) {
            this.damageDone = damageDone;
        }

        public boolean getFinalBlow() {
            return finalBlow;
        }

        public void setFinalBlow(boolean finalBlow) {
            this.finalBlow = finalBlow;
        }                        
    }

    public static final class Item implements Serializable {
        
        private static final long serialVersionUID = -16761854905584607L;

        private List<Item> items = new LinkedList<Item>();
        
        private long typeID;
        private String typeName; //not in XML
        
        private int flag;
        private boolean singleton;
        
        private int quantityDropped;
        private int quantityDestroyed;
        
        public int getFlag() {
            return flag;
        }
        public void setFlag(int flag) {
            this.flag = flag;
        }
        public List<Item> getItems() {
            return items;
        }
        public void setItems(List<Item> items) {
            this.items = items;
        }
        public long getTypeID() {
            return typeID;
        }
        public void setTypeID(long typeID) {
            this.typeID = typeID;
        }
        public String getTypeName() {
            return typeName;
        }
        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
        public boolean isSingleton() {
            return singleton;
        }
        public void setSingleton(boolean singleton) {
            this.singleton = singleton;
        }
        public int getQuantityDropped() {
            return quantityDropped;
        }
        public void setQuantityDropped(int quantityDropped) {
            this.quantityDropped = quantityDropped;
        }
        public int getQuantityDestroyed() {
            return quantityDestroyed;
        }
        public void setQuantityDestroyed(int quantityDestroyed) {
            this.quantityDestroyed = quantityDestroyed;
        }                
    }
    
    private long killID;
    private long solarSystemID;
    private String solarSystemName;//not in XML
    
    private long moonID;
    private long killTime;

    private Victim victim = new Victim();
    private List<Attacker> attackers = new LinkedList<Attacker>();
    private List<Item> items = new LinkedList<Item>();
    
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

    public Victim getVictim() {
        return victim;
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public List<Attacker> getAttackers() {
        return attackers;
    }

    public void setAttackers(List<Attacker> attackers) {
        this.attackers = attackers;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public final boolean getFinalBlow(final long attackerId) {
        for (Attacker a: this.attackers) {
            if (a.getFinalBlow() && (a.getCharacterID() == attackerId)) {
                return true;
            }
        }
        return false;
    }
}
