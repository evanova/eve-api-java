package com.tlabs.eve.api;



import java.io.Serializable;

//ItemLocation.aspx.xml
//@see https://forums.eveonline.com/default.aspx?g=posts&t=58316&find=unread
public class ItemLocation implements Serializable {

    private static final long serialVersionUID = -2001543279500079655L;

    private long itemID;

    private long locationID;
    private String locationName;

    private float x = 0;
    private float y = 0;

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}