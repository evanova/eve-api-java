package com.tlabs.eve.api;

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
import java.util.Calendar;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class IndustryJob implements Serializable {
    private static final Calendar EPOCH;
    //completedDate="0001-01-01 00:00:00"
    static {
        EPOCH = GregorianCalendar.getInstance();
        EPOCH.set(Calendar.YEAR, 0001);
        EPOCH.set(Calendar.MONTH, 01);
        EPOCH.set(Calendar.DAY_OF_MONTH, 01);
        EPOCH.set(Calendar.HOUR, 00);
        EPOCH.set(Calendar.MINUTE, 00);
        EPOCH.set(Calendar.SECOND, 00);
        EPOCH.set(Calendar.MILLISECOND, 00);
    }

    public static enum Status {
        FAILED(0, "Failed"),
        DELIVERED(1, "Delivered"),
        ABORTED(2, "Aborted"),
        ABORTED_GM(3, "Aborted by GM"),
        INFLIGHT(4, "Inflight unanchored"),
        DESTROYED(5, "Destroyed"),

        //NOT in XML
        QUEUED(96, "Queued"),
        RUNNING(97, "Running"),
        WAITING(98, "Waiting for delivery"),
        NONE(99, "Unknown");

        private final String text;
        private final int value;

        private Status(final int value, final String text) {
            this.value = value;
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public int getValue() {
            return this.value;
        }

        public static Status statusOf(int value) {
            for (Status s : EnumSet.allOf(Status.class)) {
                if (s.value == value) {
                    return s;
                }
            }
            return NONE;
        }
    }
    //select * from ramactivities
    public static enum Type {
        NONE(0, "None"),
        MANUFACTURING(1, "Manufacturing"),
        RESEARCH_TECH(2, "Researching Technology"),
        RESEARCH_TIME(3, "Researching Time Productivity"),
        RESEARCH_MATERIAL(4, "Researching Material Productivity"),
        COPY(5, "Copying"),
        DUPLICATE(6, "Duplicating"),
        REVERSE(7, "Reverse Engineering"),
        INVENTION(8, "Invention");

        private final String text;
        private final int value;

        private Type(final int value, final String text) {
            this.value = value;
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public int getValue() {
            return this.value;
        }

        public static Type typeOf(int value) {
            for (Type t : EnumSet.allOf(Type.class)) {
                if (t.value == value) {
                    return t;
                }
            }
            return NONE;
        }
    }

    private static final long serialVersionUID = 8712948500771471576L;

    private long installerID;
    private String installerName;

    private long facilityID;
    private long solarSystemID;
    private String solarSystemName;

    private long stationID;

    private int activityID;
    private long blueprintID;
    private long blueprintTypeID;
    private String blueprintTypeName;
    private long blueprintLocationID;

    private long outputLocationID;
    private String outputLocationName; //NOT in XML

    private int runs;
    private int licensedRuns;
    private float probability;
    private double cost;

    private long teamID;

    private long productTypeID;
    private String productTypeName;

    private int status;

    private long timeInSeconds;
    private long startDate;
    private long endDate;
    private long pauseDate;
    private long completedDate;
    private long completedCharacterID;

    private long jobID;

    public final long getJobID() {
        return jobID;
    }

    public final void setJobID(long jobID) {
        this.jobID = jobID;
    }

    public long getInstallerID() {
        return installerID;
    }

    public void setInstallerID(long installerID) {
        this.installerID = installerID;
    }

    public String getInstallerName() {
        return installerName;
    }

    public void setInstallerName(String installerName) {
        this.installerName = installerName;
    }

    public long getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(long facilityID) {
        this.facilityID = facilityID;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(long stationID) {
        this.stationID = stationID;
    }

    public Type getType() {
        return Type.typeOf(activityID);
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public long getBlueprintID() {
        return blueprintID;
    }

    public void setBlueprintID(long blueprintID) {
        this.blueprintID = blueprintID;
    }

    public long getBlueprintTypeID() {
        return blueprintTypeID;
    }

    public void setBlueprintTypeID(long blueprintTypeID) {
        this.blueprintTypeID = blueprintTypeID;
    }

    public String getBlueprintTypeName() {
        return blueprintTypeName;
    }

    public void setBlueprintTypeName(String blueprintTypeName) {
        this.blueprintTypeName = blueprintTypeName;
    }

    public long getBlueprintLocationID() {
        return blueprintLocationID;
    }

    public void setBlueprintLocationID(long blueprintLocationID) {
        this.blueprintLocationID = blueprintLocationID;
    }

    public long getOutputLocationID() {
        return outputLocationID;
    }

    public void setOutputLocationID(long outputLocationID) {
        this.outputLocationID = outputLocationID;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getLicensedRuns() {
        return licensedRuns;
    }

    public void setLicensedRuns(int licensedRuns) {
        this.licensedRuns = licensedRuns;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getTeamID() {
        return teamID;
    }

    public void setTeamID(long teamID) {
        this.teamID = teamID;
    }

    public long getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(long productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Status getStatus() {
        if (getCompleted()) {
            return Status.statusOf(this.status);
        }

        final long off = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        long beginTime = getStartDate() + off;
        long endTime = getEndDate() + off;
        if (beginTime > System.currentTimeMillis()) {
            return Status.QUEUED;
        }
        if (endTime <= System.currentTimeMillis()) {
            return Status.WAITING;
        }
        return Status.RUNNING;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(long timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public long getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(long pauseDate) {
        this.pauseDate = pauseDate;
    }

    public boolean getCompleted() {
        return this.completedDate > EPOCH.getTimeInMillis();
    }

    public long getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(long completedDate) {
        this.completedDate = completedDate;
    }

    public long getCompletedCharacterID() {
        return completedCharacterID;
    }

    public void setCompletedCharacterID(long completedCharacterID) {
        this.completedCharacterID = completedCharacterID;
    }

    public String getOutputLocationName() {
        return outputLocationName;
    }

    public void setOutputLocationName(String outputLocationName) {
        this.outputLocationName = outputLocationName;
    }
}
