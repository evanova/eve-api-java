package com.tlabs.eve.map;
import java.io.Serializable;


public class SolarSystem extends Object implements Serializable {

    private static final long serialVersionUID = 5766090205082445945L;

    private long solarSystemID;
    private String solarSystemName;

    private long constellationID;
    private transient String constellationName;
    
    private long regionID;
    private transient String regionName;
    
    private long factionID;
    private transient String factionName;
    
    private float securityStatus;
    
    private transient int shipJumps;
    private transient int shipKills;
    
    public SolarSystem() {
    }

    public final float getSecurityStatus() {
        return securityStatus;
    }

    public final void setSecurityStatus(float securityStatus) {
        this.securityStatus = securityStatus;
    }

    public final long getSolarSystemID() {
        return solarSystemID;
    }

    public final void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public final String getSolarSystemName() {
        return solarSystemName;
    }

    public final void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public int getShipJumps() {
		return shipJumps;
	}

	public void setShipJumps(int shipJumps) {
		this.shipJumps = shipJumps;
	}

	public int getShipKills() {
		return shipKills;
	}

	public void setShipKills(int shipKills) {
		this.shipKills = shipKills;
	}

	public long getConstellationID() {
		return constellationID;
	}

	public void setConstellationID(long constellationID) {
		this.constellationID = constellationID;
	}

	public String getConstellationName() {
		return constellationName;
	}

	public void setConstellationName(String constellationName) {
		this.constellationName = constellationName;
	}

	public long getRegionID() {
		return regionID;
	}

	public void setRegionID(long regionID) {
		this.regionID = regionID;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

	@Override
    public int hashCode() {
       return (int)this.solarSystemID;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SolarSystem)) {
            return false;
        }
        return this.solarSystemID == ((SolarSystem)obj).getSolarSystemID();
    }    
}
