package com.tlabs.eve.central;



import java.io.Serializable;

public class EveCentralOrder implements Serializable {

    private static final long serialVersionUID = -2584461952883186908L;

    public static final int BUY = 0;
    public static final int SELL = 1;

    private int type;

    private long orderID;

    private long regionID;
    private long stationID;
    private String stationName;

    private float security;

    private float price;
    private long volumeRemaining;
    private long volumeMinimum;

    private long timeExpired;
    private long timeReported;

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(long stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getVolumeRemaining() {
        return volumeRemaining;
    }

    public void setVolumeRemaining(long volumeRemaining) {
        this.volumeRemaining = volumeRemaining;
    }

    public long getVolumeMinimum() {
        return volumeMinimum;
    }

    public void setVolumeMinimum(long volumeMinimum) {
        this.volumeMinimum = volumeMinimum;
    }

    public float getSecurity() {
        return security;
    }

    public void setSecurity(float security) {
        this.security = security;
    }

    public long getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(long timeExpired) {
        this.timeExpired = timeExpired;
    }

    public long getTimeReported() {
        return timeReported;
    }

    public void setTimeReported(long timeReported) {
        this.timeReported = timeReported;
    }
}
