package com.tlabs.eve.esi.model;

public class ESIMarketItem {
    private long typeID;

    private double adjustedPrice;
    private double averagePrice;

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public double getAdjustedPrice() {
        return adjustedPrice;
    }

    public void setAdjustedPrice(double adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
