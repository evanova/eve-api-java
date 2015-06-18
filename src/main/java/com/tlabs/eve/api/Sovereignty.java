package com.tlabs.eve.api;



import java.io.Serializable;

public class Sovereignty implements Serializable {

    private static final long serialVersionUID = 4243263776307067707L;

    private long allianceID = -1;
    private long factionID = -1;
    private long corporationID = -1;

    private long solarSystemID = -1;
    private String solarSystemName;

    public long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(long allianceID) {
        this.allianceID = allianceID;
    }

    public long getFactionID() {
        return factionID;
    }

    public void setFactionID(long factionID) {
        this.factionID = factionID;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
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

}
