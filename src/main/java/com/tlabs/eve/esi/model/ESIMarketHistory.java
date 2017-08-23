package com.tlabs.eve.esi.model;

public class ESIMarketHistory {
    private long typeID;
    private long regionID;

    private double average;

    private long date;

    private double highest;
    private double lowest;

    private long orderCount;
    private long volume;

    public long getTypeID() {
        return typeID;
    }

    public ESIMarketHistory setTypeID(long typeID) {
        this.typeID = typeID;
        return this;
    }

    public long getRegionID() {
        return regionID;
    }

    public ESIMarketHistory setRegionID(long regionID) {
        this.regionID = regionID;
        return this;
    }

    public double getAverage() {
        return average;
    }

    public ESIMarketHistory setAverage(double average) {
        this.average = average;
        return this;
    }

    public long getDate() {
        return date;
    }

    public ESIMarketHistory setDate(long date) {
        this.date = date;
        return this;
    }

    public double getHighest() {
        return highest;
    }

    public ESIMarketHistory setHighest(double highest) {
        this.highest = highest;
        return this;
    }

    public double getLowest() {
        return lowest;
    }

    public ESIMarketHistory setLowest(double lowest) {
        this.lowest = lowest;
        return this;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public ESIMarketHistory setOrderCount(long orderCount) {
        this.orderCount = orderCount;
        return this;
    }

    public long getVolume() {
        return volume;
    }

    public ESIMarketHistory setVolume(long volume) {
        this.volume = volume;
        return this;
    }
}
