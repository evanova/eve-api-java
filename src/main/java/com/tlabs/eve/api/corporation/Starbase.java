package com.tlabs.eve.api.corporation;

import java.io.Serializable;

public class Starbase extends Object implements Serializable {

    private static final long serialVersionUID = -7331194775370807147L;

    private long itemID;
    private long typeID;
    private long locationID;
    private long moonID;
    private int state;
    private long stateTimestamp;
    private long onlineTimestamp;
    private long standingOwnerID;
    
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
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

}
