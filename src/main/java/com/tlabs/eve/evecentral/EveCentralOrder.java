package com.tlabs.eve.evecentral;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.Serializable;

public class EveCentralOrder extends Object implements Serializable {

    private static final long serialVersionUID = -2584461952883186908L;
    
    public static final int BUY = 0;
    public static final int SELL = 1;
    
    public int type;
    
    private long regionID;
    private long stationID;    
    private String stationName;
    
    private float security;
    
    private float price;   
	private long volumeRemaining;
	private long volumeMinimum;
	
	private long timeExpired;
	private long timeReported;
	
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
