package com.tlabs.eve.api.character;

import java.io.Serializable;

import com.tlabs.eve.api.EveAPI;

public class PlanetaryColony implements Serializable {

    private static final long serialVersionUID = 2574634590224975461L;

    private long planetID;
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
}
