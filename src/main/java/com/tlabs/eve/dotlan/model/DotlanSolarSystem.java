package com.tlabs.eve.dotlan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated //use ESI
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DotlanSolarSystem {

    private static Logger LOG = LoggerFactory.getLogger(DotlanSolarSystem.class);

    private long solarSystemID;
    private String solarSystemName;

    private long constellationID;
    private String constellationName;

    private long regionID;
    private String regionName;

    private long holderID;
    private String holderName;

    private float securityStatus;

    private int shipJumps;
    private int shipKills;

    private float distanceToNext;
    private long fuelToNext;

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

    public long getHolderID() {
        return holderID;
    }

    public void setHolderID(long holderID) {
        this.holderID = holderID;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public float getDistanceToNext() {
        return distanceToNext;
    }
/*
        "distanceToNext" : "Distance: 3.455 ly (2 jumps)",
        "fuelToNext" : "Fuel needed: 2,590 Oxygen Isotopes"*/
    @JsonSetter
    public void setDistanceToNext(final String distanceToNext) {
        if (StringUtils.isBlank(distanceToNext)) {
            this.distanceToNext = 0;
            return;
        }
        String d = StringUtils.removeStart(distanceToNext, "Distance:");
        d = StringUtils.substringBefore(d, "ly").trim();
        try {
            this.distanceToNext = Float.parseFloat(d);
        }
        catch (NumberFormatException e) {
            LOG.error(e.getLocalizedMessage(), e);
            this.distanceToNext = 0;
        }
    }

    public long getFuelToNext() {
        return fuelToNext;
    }

    @JsonSetter
    public void setFuelToNext(String fuelToNext) {
        if (StringUtils.isBlank(fuelToNext)) {
            this.fuelToNext = 0;
            return;
        }
        String d = StringUtils.removeStart(fuelToNext, "Fuel needed: ");
        d = StringUtils.substringBefore(d, " ");
        d = StringUtils.remove(d, ",");
        try {
            this.fuelToNext = Long.parseLong(d);
        }
        catch (NumberFormatException e) {
            LOG.error(e.getLocalizedMessage(), e);
            this.fuelToNext = 0;
        }    }
}
