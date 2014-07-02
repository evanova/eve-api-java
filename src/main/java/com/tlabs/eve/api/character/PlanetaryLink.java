package com.tlabs.eve.api.character;

import java.io.Serializable;

public class PlanetaryLink implements Serializable {

    private static final long serialVersionUID = -7659113808390806789L;

    private long sourcePinID;
    private long destinationPinID;

    private int linkLevel;

    public long getSourcePinID() {
        return sourcePinID;
    }

    public void setSourcePinID(long sourcePinID) {
        this.sourcePinID = sourcePinID;
    }

    public long getDestinationPinID() {
        return destinationPinID;
    }

    public void setDestinationPinID(long destinationPinID) {
        this.destinationPinID = destinationPinID;
    }

    public int getLinkLevel() {
        return linkLevel;
    }

    public void setLinkLevel(int linkLevel) {
        this.linkLevel = linkLevel;
    }

}
