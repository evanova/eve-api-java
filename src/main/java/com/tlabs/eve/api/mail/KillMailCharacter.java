package com.tlabs.eve.api.mail;

public class KillMailCharacter {

    private long characterID;
    private String characterName;

    private long corporationID;
    private String corporationName;

    private long allianceID;
    private String allianceName;

    private long factionID;
    private String factionName;

    private long shipTypeID;
    private String shipTypeName = "";//not in JSON

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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

    public long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public long getFactionID() {
        return factionID;
    }

    public void setFactionID(long factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public long getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(long shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getShipTypeName() {
        return shipTypeName;
    }

    public void setShipTypeName(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }
}
