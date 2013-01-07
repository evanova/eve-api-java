package com.tlabs.eve.api;

//Conquerable station only
public class EveStation {

    private long stationID;
    private String stationName;

    private long corporationID;
    private String corporationName;

    private long stationTypeID;
    private long solarSystemID;

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

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public long getStationTypeID() {
        return stationTypeID;
    }

    public void setStationTypeID(long stationTypeID) {
        this.stationTypeID = stationTypeID;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

}
