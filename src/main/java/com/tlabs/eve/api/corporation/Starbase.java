package com.tlabs.eve.api.corporation;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
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
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Starbase extends Object implements Serializable {
/*
State   Name    Notes
0    Unanchored Also unanchoring? Has valid stateTimestamp. Note that moonID is zero for unanchored Towers, but locationID will still yield the solar system ID.
1    Anchored / Offline No time information stored.
2    Onlining   Will be online at time = onlineTimestamp.
3    Reinforced Until time = stateTimestamp.
4    Online Continuously since time = onlineTimestamp.*/
    public static enum State {
        UNANCHORED(0),
        ANCHORED(1),
        ONLINING(2),
        REINFORCED(3),
        ONLINE(4);
        
        private final int value;        
        private State(final int value) {
            this.value = value;
        }
        
        public static final State stateOf(final int value) {
            for (State s: EnumSet.allOf(State.class)) {
                if (s.value == value) {
                    return s;
                }
            }
            return UNANCHORED;
        }
    }
    
    private static final long serialVersionUID = -7331194775370807147L;

    private long itemID;//starbase id, not an item type_id
    
    private long typeID;//the item type_id
    private String typeName;//not in XML
    
    private long locationID;//solar system id
    private String locationName;//not in XML
    
    private long moonID;
    
    private State state;
    
    private long stateTimestamp;
    private long onlineTimestamp;

    private long standingOwnerID;
    private String standingOwnerName;//not in XML
    
    private Map<Long, Long> fuelMap = new HashMap<Long, Long>();//typeid/volume; only in details
    private Map<Long, String> fuelTypes = new HashMap<Long, String>();//not in XML
    
    private boolean allowAllianceMembers = false;//only in details
    private boolean allowCorporationMembers = false;//only in details
    
    public Starbase() {
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public long getMoonID() {
        return moonID;
    }

    public void setMoonID(long moonID) {
        this.moonID = moonID;
    }

    public State getState() {
        return state;
    }

    public void setState(int state) {
        this.state = State.stateOf(state);
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public long getStateTimestamp() {
        return stateTimestamp;
    }

    public void setStateTimestamp(long stateTimestamp) {
        this.stateTimestamp = stateTimestamp;
    }

    public long getOnlineTimestamp() {
        return onlineTimestamp;
    }

    public void setOnlineTimestamp(long onlineTimestamp) {
        this.onlineTimestamp = onlineTimestamp;
    }

    public long getStandingOwnerID() {
        return standingOwnerID;
    }

    public void setStandingOwnerID(long standingOwnerID) {
        this.standingOwnerID = standingOwnerID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStandingOwnerName() {
        return standingOwnerName;
    }

    public void setStandingOwnerName(String standingOwnerName) {
        this.standingOwnerName = standingOwnerName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public boolean getAllowAllianceMembers() {
        return allowAllianceMembers;
    }

    public void setAllowAllianceMembers(boolean allowAllianceMembers) {
        this.allowAllianceMembers = allowAllianceMembers;
    }

    public boolean getAllowCorporationMembers() {
        return allowCorporationMembers;
    }

    public void setAllowCorporationMembers(boolean allowCorporationMembers) {
        this.allowCorporationMembers = allowCorporationMembers;
    }
    
    public final Map<Long, Long> getFuelMap() {
        return Collections.unmodifiableMap(this.fuelMap);
    }
    
    public void setFuelMap(final Map<Long, Long> fuelMap) {
        this.fuelMap.clear();
        this.fuelMap.putAll(fuelMap); 
    }
    

    public final Map<Long, String> getFuelTypes() {
        return Collections.unmodifiableMap(this.fuelTypes);
    }
    
    public void setFuelNames(final Map<Long, String> fuelTypes) {
        this.fuelTypes.clear();
        this.fuelTypes.putAll(fuelTypes);
    }
}
