package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.List;

public class ESILocation extends ESIName {

    public static final ESILocation UNKNOWN = new ESILocation();

    public static class Region extends ESILocation {

        private final List<Constellation> constellations;

        public Region() {
            this.constellations = new ArrayList<>();
            setGroup("region");
        }

        public Region addConstellation(final Constellation constellation) {
            constellation.setRegion(this);
            this.constellations.add(constellation);
            return this;
        }

        public Region addConstellation(final long constellationId) {
            final Constellation c = new Constellation()
                    .setRegion(this)
                    .setId(constellationId);
            this.constellations.add(c);
            return this;
        }

        public List<Constellation> getConstellations() {
            return constellations;
        }
    }

    public static class SolarSystem extends ESILocation {

        private float securityStatus;
        private String securityClass;

        private int shipJumps;
        private int shipKills;
        private int podKills;
        private int npcKills;

        private Constellation constellation;

        public SolarSystem() {
            setGroup("solar_system");
        }

        public Constellation getConstellation() {
            return constellation;
        }

        public Region getRegion() {
            return (null == this.constellation) ? null : this.constellation.getRegion();
        }

        public SolarSystem setConstellation(Constellation constellation) {
            this.constellation = constellation;
            return this;
        }

        public float getSecurityStatus() {
            return securityStatus;
        }

        public SolarSystem setSecurityStatus(float securityStatus) {
            this.securityStatus = securityStatus;
            return this;
        }

        public String getSecurityClass() {
            return securityClass;
        }

        public SolarSystem setSecurityClass(String securityClass) {
            this.securityClass = securityClass;
            return this;
        }

        public int getShipJumps() {
            return shipJumps;
        }

        public SolarSystem setShipJumps(int shipJumps) {
            this.shipJumps = shipJumps;
            return this;
        }

        public int getShipKills() {
            return shipKills;
        }

        public SolarSystem setShipKills(int shipKills) {
            this.shipKills = shipKills;
            return this;
        }

        public int getPodKills() {
            return podKills;
        }

        public SolarSystem setPodKills(int podKills) {
            this.podKills = podKills;
            return this;
        }

        public int getNpcKills() {
            return npcKills;
        }

        public SolarSystem setNpcKills(int npcKills) {
            this.npcKills = npcKills;
            return this;
        }
    }

    public static class Station extends ESILocation {
        private long solarSystemId;

        public Station() {
            setGroup("station");
        }

        public long getSolarSystemId() {
            return solarSystemId;
        }

        public ESILocation.Station setSolarSystemId(long solarSystemId) {
            this.solarSystemId = solarSystemId;
            return this;
        }
    }

    public static class Structure extends ESILocation {
        private long solarSystemId;
        private long typeID;

        public Structure() {
            setGroup("structure");
        }

        public long getSolarSystemId() {
            return solarSystemId;
        }

        public ESILocation.Structure setSolarSystemId(long solarSystemId) {
            this.solarSystemId = solarSystemId;
            return this;
        }

        public long getTypeID() {
            return typeID;
        }

        public ESILocation.Structure setTypeID(long typeID) {
            this.typeID = typeID;
            return this;
        }
    }

    public static class Constellation extends ESILocation {

        private Region region;
        private List<SolarSystem> systems;

        public Constellation() {
            this.systems = new ArrayList<>();
            setGroup("constellation");
        }

        public Region getRegion() {
            return region;
        }

        public Constellation setRegion(Region region) {
            this.region = region;
            return this;
        }

        public Constellation addSolarSystem(final SolarSystem system) {
            system.setConstellation(this);
            this.systems.add(system);
            return this;
        }

        public Constellation addSolarSystem(final long solarSystemId) {
            final SolarSystem s = new SolarSystem()
                    .setConstellation(this)
                    .setId(solarSystemId);
            this.systems.add(s);
            return this;
        }

        public List<SolarSystem> getSolarSystems() {
            return systems;
        }
    }

    private String description;

    private float x;
    private float y;
    private float z;

    public final String getDescription() {
        return description;
    }

    public final <T extends ESILocation> T setDescription(String description) {
        this.description = description;
        return (T)this;
    }

    public final float getX() {
        return x;
    }

    public final <T extends ESILocation> T setX(float x) {
        this.x = x;
        return (T)this;
    }

    public final float getY() {
        return y;
    }

    public final <T extends ESILocation> T setY(float y) {
        this.y = y;
        return (T)this;
    }

    public final float getZ() {
        return z;
    }

    public final <T extends ESILocation> T setZ(float z) {
        this.z = z;
        return (T)this;
    }
}
