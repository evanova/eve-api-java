package com.tlabs.eve.api.character;

import java.io.Serializable;
import com.tlabs.eve.api.EveAPI;

public class PlanetaryColony extends Object implements Serializable {

    private static final long serialVersionUID = 2574634590224975461L;

    private long planetID;
    private String planetName;

    private long solarSystemID;
    private String solarSystemName;

    private long planetTypeID;
    private String planetTypeName;

    private int numberOfPins;

    private long ownerID;
    private String ownerName;

    private long lastUpdate;
    private int upgradeLevel;

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

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = EveAPI.parseDateTime(lastUpdate);
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(int upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
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

    public long getPlanetTypeID() {
        return planetTypeID;
    }

    public void setPlanetTypeID(long planetTypeID) {
        this.planetTypeID = planetTypeID;
    }

    public String getPlanetTypeName() {
        return planetTypeName;
    }

    public void setPlanetTypeName(String planetTypeName) {
        this.planetTypeName = planetTypeName;
    }

    public int getNumberOfPins() {
        return numberOfPins;
    }

    public void setNumberOfPins(int numberOfPins) {
        this.numberOfPins = numberOfPins;
    }
}
