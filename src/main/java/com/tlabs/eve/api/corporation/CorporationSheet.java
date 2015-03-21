package com.tlabs.eve.api.corporation;

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
import java.util.HashMap;
import java.util.Map;

public class CorporationSheet implements Serializable {

    private static final long serialVersionUID = 7615990349864525058L;

    private long corporationID;
    private String corporationName;
    private String description;
    private String url;
    private String ticker;

    private long ceoID;
    private String ceoName;

    private long stationID;
    private String stationName;

    private long allianceID;
    private String allianceName;

    private long factionID;
    private String factionName;

    private int memberCount;
    private int memberLimit;

    private float taxRate;
    private float shares;

    private Map<Integer, String> walletDivisions = new HashMap<>();
    private Map<Integer, String> hangarDivisions = new HashMap<>();
    private double walletBalance = -1;//not in XML

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public long getCeoID() {
        return ceoID;
    }

    public void setCeoID(long ceoID) {
        this.ceoID = ceoID;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
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

    public long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(String allianceName) {
        this.allianceName = allianceName;
    }

    public final long getFactionID() {
        return factionID;
    }

    public final void setFactionID(long factionID) {
        this.factionID = factionID;
    }

    public final String getFactionName() {
        return factionName;
    }

    public final void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(int memberLimit) {
        this.memberLimit = memberLimit;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getShares() {
        return shares;
    }

    public void setShares(float shares) {
        this.shares = shares;
    }

    public final void addWalletDivision(Integer id, String name) {
        this.walletDivisions.put(id, name);
    }

    public final Map<Integer, String> getWalletDivisions() {
        return walletDivisions;
    }

    public final double getBalance() {
        return this.walletBalance;
    }

    public final void setBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public final void addHangarDivision(Integer id, String name) {
        this.hangarDivisions.put(id, name);
    }

    public final Map<Integer, String> getHangarDivisions() {
        return hangarDivisions;
    }

}
