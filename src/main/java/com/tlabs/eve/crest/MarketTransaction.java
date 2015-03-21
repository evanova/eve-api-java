package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class MarketTransaction implements Serializable {

    private static final long serialVersionUID = 5163488029895665697L;

    @JsonProperty("volume")
    private long volume;

    @JsonProperty("orderCount")
    private long orderCount;

    @JsonProperty("lowPrice")
    private float lowPrice;

    @JsonProperty("highPrice")
    private float highPrice;

    @JsonProperty("avgPrice")
    private float averagePrice;

    @JsonProperty("date")
    private Date date;

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
