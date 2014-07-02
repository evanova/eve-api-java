package com.tlabs.eve.api.character;

import java.io.Serializable;

import com.tlabs.eve.api.EveAPI;

public class PlanetaryPin implements Serializable {

    private static final long serialVersionUID = -45893431241726263L;

    private long pinID;

    private long ownerID;
    private String ownerName;

    private long planetID;
    private String planetName;

    private long typeID;
    private String typeName;

    private long schematicID;

    private long lastLaunchTime;
    private long cycleTime;
    private long installTime;
    private long expiryTime;

    private float quantityPerCycle;

    //private float headRadius;

    public long getPinID() {
        return pinID;
    }

    public void setPinID(long pinID) {
        this.pinID = pinID;
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

    public long getPlanetID() {
        return planetID;
    }

    public void setPlanetID(long planetID) {
        this.planetID = planetID;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
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

    public long getSchematicID() {
        return schematicID;
    }

    public void setSchematicID(long schematicID) {
        this.schematicID = schematicID;
    }

    public long getLastLaunchTime() {
        return lastLaunchTime;
    }

    public void setLastLaunchTime(long lastLaunchTime) {
        this.lastLaunchTime = lastLaunchTime;
    }

    public void setLastLaunchTime(String lastLaunchTime) {
        this.lastLaunchTime = EveAPI.parseDateTime(lastLaunchTime);
    }

    public long getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(long cycleTime) {
        this.cycleTime = cycleTime;
    }

    public long getInstallTime() {
        return installTime;
    }

    public void setInstallTime(long installTime) {
        this.installTime = installTime;
    }

    public void setInstallTime(String installTime) {
        this.installTime = EveAPI.parseDateTime(installTime);
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = EveAPI.parseDateTime(expiryTime);
    }

    public float getQuantityPerCycle() {
        return quantityPerCycle;
    }

    public void setQuantityPerCycle(float quantityPerCycle) {
        this.quantityPerCycle = quantityPerCycle;
    }

}
