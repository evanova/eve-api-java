package com.tlabs.eve.esi.model;

import java.util.Date;

public class ESIMarketOrder {

    private long duration;
    private boolean buyOrder;

    private Date issued;

    private long locationID;
    private long orderID;
    private long typeID;

    private double price;
    private long minVolume;
    private long remainingVolume;
    private long totalVolume;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(boolean buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(long minVolume) {
        this.minVolume = minVolume;
    }

    public long getRemainingVolume() {
        return remainingVolume;
    }

    public void setRemainingVolume(long remainingVolume) {
        this.remainingVolume = remainingVolume;
    }

    public long getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(long totalVolume) {
        this.totalVolume = totalVolume;
    }
}
