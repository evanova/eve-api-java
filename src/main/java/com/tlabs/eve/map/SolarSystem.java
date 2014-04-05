package com.tlabs.eve.map;
import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;


public class SolarSystem extends Object implements Serializable {

    private static final long serialVersionUID = 5766090205082445945L;

    private long solarSystemID;
    private String solarSystemName;
    
    private float securityStatus;
    
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

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"solarSystemName", "securityStatus"});
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SolarSystem)) {
            return false;
        }
        return this.solarSystemID == ((SolarSystem)obj).getSolarSystemID();
    }    
}
