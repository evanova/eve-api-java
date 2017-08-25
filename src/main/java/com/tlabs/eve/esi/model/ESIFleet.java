package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.List;

public class ESIFleet {

    public static class Member {
        public static final int FLEET_COMMANDER = 0;
        public static final int WING_COMMANDER = 1;
        public static final int SQUAD_COMMANDER = 2;
        public static final int SQUAD_MEMBER = 3;

        private int role;
        private long joinTime;
        private long wingId;
        private long squadId;

        private long characterId;
        private long shipTypeId;
        private long solarSystemId;
        private long stationId;

        private boolean takesFleetWarp = false;

        public int getRole() {
            return role;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public long getJoinTime() {
            return joinTime;
        }

        public void setJoinTime(long joinTime) {
            this.joinTime = joinTime;
        }

        public long getWingId() {
            return wingId;
        }

        public void setWingId(long wingId) {
            this.wingId = wingId;
        }

        public long getCharacterId() {
            return characterId;
        }

        public void setCharacterId(long characterId) {
            this.characterId = characterId;
        }

        public long getShipTypeId() {
            return shipTypeId;
        }

        public void setShipTypeId(long shipTypeId) {
            this.shipTypeId = shipTypeId;
        }

        public long getSolarSystemId() {
            return solarSystemId;
        }

        public void setSolarSystemId(long solarSystemId) {
            this.solarSystemId = solarSystemId;
        }

        public long getStationId() {
            return stationId;
        }

        public void setStationId(long stationId) {
            this.stationId = stationId;
        }

        public boolean isTakesFleetWarp() {
            return takesFleetWarp;
        }

        public void setTakesFleetWarp(boolean takesFleetWarp) {
            this.takesFleetWarp = takesFleetWarp;
        }

        public long getSquadId() {
            return squadId;
        }

        public void setSquadId(long squadId) {
            this.squadId = squadId;
        }
    }

    public static class Squad {

        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Wing {
        private long id;
        private String name;

        private List<Squad> squads = new ArrayList<>();

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Squad> getSquads() {
            return squads;
        }

        public void setSquads(List<Squad> squads) {
            this.squads = squads;
        }
    }

    private long fleetId;

    private boolean isFreeMove = false;
    private boolean isRegistered = false;
    private boolean isVoiceEnabled = false;

    private String motd = null;

    public long getFleetId() {
        return fleetId;
    }

    public void setFleetId(long fleetId) {
        this.fleetId = fleetId;
    }

    public boolean isFreeMove() {
        return isFreeMove;
    }

    public void setFreeMove(boolean freeMove) {
        isFreeMove = freeMove;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isVoiceEnabled() {
        return isVoiceEnabled;
    }

    public void setVoiceEnabled(boolean voiceEnabled) {
        isVoiceEnabled = voiceEnabled;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }
}
