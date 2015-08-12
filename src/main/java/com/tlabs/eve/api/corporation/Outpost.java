package com.tlabs.eve.api.corporation;

import java.io.Serializable;

public class Outpost implements Serializable {

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

    private double x;
    private double y;
    private double z;

    public long getStationID() {
        return stationID;
    }

    public void setStationID(long stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getStandingOwnerID() {
        return standingOwnerID;
    }

    public void setStandingOwnerID(long standingOwnerID) {
        this.standingOwnerID = standingOwnerID;
    }

    public String getStandingOwnerName() {
        return standingOwnerName;
    }

    public void setStandingOwnerName(String standingOwnerName) {
        this.standingOwnerName = standingOwnerName;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
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

    public String getStationTypeName() {
        return stationTypeName;
    }

    public void setStationTypeName(String stationTypeName) {
        this.stationTypeName = stationTypeName;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
