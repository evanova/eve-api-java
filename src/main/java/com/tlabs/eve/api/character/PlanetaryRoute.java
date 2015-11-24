package com.tlabs.eve.api.character;

import java.io.Serializable;

public class PlanetaryRoute extends Object implements Serializable {

    private static final long serialVersionUID = -3629780760607505499L;

    private long routeID;
    private long sourcePinID;
    private long destinationPinID;

    private long waypoint1;
    private long waypoint2;
    private long waypoint3;
    private long waypoint4;
    private long waypoint5;

    private long contentTypeID;
    private String contentTypeName;

    private float quantity;

    public long getRouteID() {
        return routeID;
    }

    public void setRouteID(long routeID) {
        this.routeID = routeID;
    }

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

    public long getContentTypeID() {
        return contentTypeID;
    }

    public void setContentTypeID(long contentTypeID) {
        this.contentTypeID = contentTypeID;
    }

    public String getContentTypeName() {
        return contentTypeName;
    }

    public void setContentTypeName(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public long getWaypoint1() {
        return waypoint1;
    }

    public void setWaypoint1(long waypoint1) {
        this.waypoint1 = waypoint1;
    }

    public long getWaypoint2() {
        return waypoint2;
    }

    public void setWaypoint2(long waypoint2) {
        this.waypoint2 = waypoint2;
    }

    public long getWaypoint3() {
        return waypoint3;
    }

    public void setWaypoint3(long waypoint3) {
        this.waypoint3 = waypoint3;
    }

    public long getWaypoint4() {
        return waypoint4;
    }

    public void setWaypoint4(long waypoint4) {
        this.waypoint4 = waypoint4;
    }

    public long getWaypoint5() {
        return waypoint5;
    }

    public void setWaypoint5(long waypoint5) {
        this.waypoint5 = waypoint5;
    }
}
