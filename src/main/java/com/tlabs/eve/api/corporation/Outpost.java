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

public class Outpost extends Object implements Serializable {
    
    private static final long serialVersionUID = 4480776659853459976L;

    private long stationID;
    private String stationName;
    
    private long ownerID;
    private String ownerName;//Not in XML
    
    private long standingOwnerID;
    private String standingOwnerName;//Not in XML
    
    private long solarSystemID;
    private String solarSystemName;//Not in XML
    
    private double dockingCostPerShipVolume;
    private double officeRentalCost;
    
    private long stationTypeID;
    private String stationTypeName;//Not in XML
    
    private float reprocessingEfficiency;
    private float reprocessingStationTake;
    
    public Outpost() {
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(long stationID) {
        this.stationID = stationID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public double getDockingCostPerShipVolume() {
        return dockingCostPerShipVolume;
    }

    public void setDockingCostPerShipVolume(double dockingCostPerShipVolume) {
        this.dockingCostPerShipVolume = dockingCostPerShipVolume;
    }

    public double getOfficeRentalCost() {
        return officeRentalCost;
    }

    public void setOfficeRentalCost(double officeRentalCost) {
        this.officeRentalCost = officeRentalCost;
    }

    public long getStationTypeID() {
        return stationTypeID;
    }

    public void setStationTypeID(long stationTypeID) {
        this.stationTypeID = stationTypeID;
    }

    public float getReprocessingEfficiency() {
        return reprocessingEfficiency;
    }

    public void setReprocessingEfficiency(float reprocessingEfficiency) {
        this.reprocessingEfficiency = reprocessingEfficiency;
    }

    public float getReprocessingStationTake() {
        return reprocessingStationTake;
    }

    public void setReprocessingStationTake(float reprocessingStationTake) {
        this.reprocessingStationTake = reprocessingStationTake;
    }

    public long getStandingOwnerID() {
        return standingOwnerID;
    }

    public void setStandingOwnerID(long standingOwnerID) {
        this.standingOwnerID = standingOwnerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStandingOwnerName() {
        return standingOwnerName;
    }

    public void setStandingOwnerName(String standingOwnerName) {
        this.standingOwnerName = standingOwnerName;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public String getStationTypeName() {
        return stationTypeName;
    }

    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
    }

}
