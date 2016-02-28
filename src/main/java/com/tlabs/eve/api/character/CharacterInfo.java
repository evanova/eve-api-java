package com.tlabs.eve.api.character;


import java.util.ArrayList;
import java.util.List;

public class CharacterInfo {

    public static class History {
        private long recordID;

        private long corporationID;
        private String corporationName;
        private long startDate;


        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public long getCorporationID() {
            return corporationID;
        }

        public void setCorporationID(long corporationID) {
            this.corporationID = corporationID;
        }

        public long getRecordID() {
            return recordID;
        }

        public void setRecordID(long recordID) {
            this.recordID = recordID;
        }

        public String getCorporationName() {
            return corporationName;
        }

        public void setCorporationName(String corporationName) {
            this.corporationName = corporationName;
        }
    }

    private long characterID;
    private String lastKnownLocation;
    private float securityStatus;

    private long skillPoints = 0;

    private String shipName;
    private long shipTypeID;
    private String shipTypeName;

    private long corporationDate;
    private long allianceID = 0;
    private String alliance;
    private long allianceDate;

    private List<History> history = new ArrayList<>();

    public CharacterInfo() {
        super();
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public String getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(String lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    public float getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(float securityStatus) {
        this.securityStatus = securityStatus;
    }

    public long getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(long skillPoints) {
        this.skillPoints = skillPoints;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
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

    public long getCorporationDate() {
        return corporationDate;
    }

    public void setCorporationDate(long corporationDate) {
        this.corporationDate = corporationDate;
    }

    public long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public long getAllianceDate() {
        return allianceDate;
    }

    public void setAllianceDate(long allianceDate) {
        this.allianceDate = allianceDate;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public void addHistory(final History h) {
        this.history.add(h);
    }
}
