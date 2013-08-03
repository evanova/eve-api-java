package com.tlabs.eve.api.corporation;

import java.io.Serializable;

public class Outpost extends Object implements Serializable {
    
    private static final long serialVersionUID = 4480776659853459976L;

    private long stationID;
    private long ownerID;
    private String stationName;
    private long solarSystemID;
    private double dockingCostPerShipVolume;
    private double officeRentalCost;
    private long stationTypeID;
    private float reprocessingEfficiency;
    private float reprocessingStationTake;
    
    private long standingOwnerID;
    
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

}
