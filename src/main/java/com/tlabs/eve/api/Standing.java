package com.tlabs.eve.api;



import java.io.Serializable;

public class Standing implements Serializable {

    private static final long serialVersionUID = -9069702849389351438L;

    private String fromName;
    private long fromID;

    private float standing;

    private long locationID;//Not in XML
    private String locationName;//Not in XML

    public final String getFromName() {
        return fromName;
    }

    public final void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public final long getFromID() {
        return fromID;
    }

    public final void setFromID(long fromID) {
        this.fromID = fromID;
    }

    public final float getStanding() {
        return standing;
    }

    public final void setStanding(float standing) {
        this.standing = standing;
    }

    public final long getLocationID() {
        return locationID;
    }

    public final void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public final String getLocationName() {
        return locationName;
    }

    public final void setLocationName(String locationName) {
        this.locationName = locationName;
    }

}
