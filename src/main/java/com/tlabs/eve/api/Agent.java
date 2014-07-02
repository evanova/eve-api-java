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

import java.io.Serializable;

//Not found in any XML; comes from Eve DB.agtAgents
public class Agent implements Serializable {

    private static final long serialVersionUID = 3850178814479198316L;

    private long agentID;
    private String agentName;

    private long divisionID;
    private String divisionName;//?

    private long locationID;
    private String locationName;//locations

    private long corporationID;
    private String corporationName;

    private int level;
    private int quality;

    private long typeID;
    private String typeName;

    private boolean locatorAgent = false;

    public long getID() {
        return agentID;
    }

    public void setID(long agentID) {
        this.agentID = agentID;
    }

    public String getName() {
        return agentName;
    }

    public void setName(String agentName) {
        this.agentName = agentName;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public String getLocation() {
        return locationName;
    }

    public void setLocation(String locationName) {
        this.locationName = locationName;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporation() {
        return corporationName;
    }

    public void setCorporation(String corporationName) {
        this.corporationName = corporationName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return typeName;
    }

    public void setType(String typeName) {
        this.typeName = typeName;
    }

    public boolean getLocator() {
        return locatorAgent;
    }

    public void setLocator(boolean locatorAgent) {
        this.locatorAgent = locatorAgent;
    }

    public long getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(long divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

}
