package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2014 Traquenard Labs
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

//This is not part of the API but part of the data dump.
public final class ItemEffect implements Serializable {

    public static final int USES_LOW_SLOT = 11;
    public static final int USES_MEDIUM_SLOT = 13;
    public static final int USES_HIGH_SLOT = 12;
    public static final int USES_RIG_SLOT = 2663;

    //public static final int USES_SUBSYSTEM = 2663;

    private static final long serialVersionUID = -6457985690836261476L;

    private int id;
    private String name;
    private String displayName;
    private String description;

    private int categoryID;

    private boolean isOffensive = false;
    private boolean isAssistance = false;
    private boolean disallowAutoRepeat = false;
    private boolean isWarpSafe = false;

    private int rangeChance;
    private int electronicChance;
    private int propulsionChance;

    private int preExpressionID;
    private int postExpressionID;

    private long durationAttributeID;
    private long trackingSpeedAttributeID;
    private long dischargeAttributeID;
    private long rangeAttributeID;
    private long falloffAttributeID;

    private int distribution;

    //Guid
    //icon ID
    //sfxName
    //npcUsageChanceAttributeID
    //npcActivationChanceAttributeID
    //fittingUsageChanceAttributeID

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public boolean isOffensive() {
        return isOffensive;
    }

    public void setOffensive(boolean isOffensive) {
        this.isOffensive = isOffensive;
    }

    public boolean isAssistance() {
        return isAssistance;
    }

    public void setAssistance(boolean isAssistance) {
        this.isAssistance = isAssistance;
    }

    public boolean isDisallowAutoRepeat() {
        return disallowAutoRepeat;
    }

    public void setDisallowAutoRepeat(boolean disallowAutoRepeat) {
        this.disallowAutoRepeat = disallowAutoRepeat;
    }

    public boolean isWarpSafe() {
        return isWarpSafe;
    }

    public void setWarpSafe(boolean isWarpSafe) {
        this.isWarpSafe = isWarpSafe;
    }

    public int getRangeChance() {
        return rangeChance;
    }

    public void setRangeChance(int rangeChance) {
        this.rangeChance = rangeChance;
    }

    public int getElectronicChance() {
        return electronicChance;
    }

    public void setElectronicChance(int electronicChance) {
        this.electronicChance = electronicChance;
    }

    public int getPropulsionChance() {
        return propulsionChance;
    }

    public void setPropulsionChance(int propulsionChance) {
        this.propulsionChance = propulsionChance;
    }

    public int getPreExpressionID() {
        return preExpressionID;
    }

    public void setPreExpressionID(int preExpressionID) {
        this.preExpressionID = preExpressionID;
    }

    public int getPostExpressionID() {
        return postExpressionID;
    }

    public void setPostExpressionID(int postExpressionID) {
        this.postExpressionID = postExpressionID;
    }

    public long getDurationAttributeID() {
        return durationAttributeID;
    }

    public void setDurationAttributeID(long durationAttributeID) {
        this.durationAttributeID = durationAttributeID;
    }

    public long getTrackingSpeedAttributeID() {
        return trackingSpeedAttributeID;
    }

    public void setTrackingSpeedAttributeID(long trackingSpeedAttributeID) {
        this.trackingSpeedAttributeID = trackingSpeedAttributeID;
    }

    public long getDischargeAttributeID() {
        return dischargeAttributeID;
    }

    public void setDischargeAttributeID(long dischargeAttributeID) {
        this.dischargeAttributeID = dischargeAttributeID;
    }

    public long getRangeAttributeID() {
        return rangeAttributeID;
    }

    public void setRangeAttributeID(long rangeAttributeID) {
        this.rangeAttributeID = rangeAttributeID;
    }

    public long getFalloffAttributeID() {
        return falloffAttributeID;
    }

    public void setFalloffAttributeID(long falloffAttributeID) {
        this.falloffAttributeID = falloffAttributeID;
    }

    public int getDistribution() {
        return distribution;
    }

    public void setDistribution(int distribution) {
        this.distribution = distribution;
    }

}