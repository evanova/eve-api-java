package com.tlabs.eve.api.character;

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

import com.tlabs.eve.api.EveAPI;

public class ResearchJob implements Serializable {

    private static final long serialVersionUID = 6328512238643259742L;
    /*Name	Type	Description
    agentID	 int	 The agent ID number.
    skillTypeID	 int	 The skill used for the research, not the typeID of the core received.
    researchStartDate	 date string	 The date the character began the current research with the agent at the current pointsPerDay. Each change in the pointsPerDay will update researchStartDate as well.
    pointsPerDay	 decimal	 The number of points generated per day.
    remainderPoints	 float	 The number of points remaining since the last datacore purchase and/or pointPerDay update. Mission RP is also added to this value.
    */

    private static final double DAY = 1000 * 60 * 60 * 24;

    private long agentID = 0;
    private String agentName;//Not in XML
    private int agentLevel = 0;//Not in XML

    private long skillTypeID = 0;
    private String skillTypeName;//Not in XML

    private long locationID = 0;//Not in XML
    private String locationName;//Not in XML

    private long startDate = 0;

    private float pointsDaily = 0;
    private float pointsRemaining = 0;

    public long getAgentID() {
        return agentID;
    }

    public void setAgentID(long agentID) {
        this.agentID = agentID;
    }

    public long getSkillTypeID() {
        return skillTypeID;
    }

    public void setSkillTypeID(long skillTypeID) {
        this.skillTypeID = skillTypeID;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long researchStartDate) {
        this.startDate = researchStartDate;
    }

    public void setStartDate(String researchStartDate) {
        this.startDate = EveAPI.parseDateTime(researchStartDate);
    }

    public float getPointsDaily() {
        return pointsDaily;
    }

    public void setPointsDaily(float pointsDaily) {
        this.pointsDaily = pointsDaily;
    }

    public float getPointsRemaining() {
        return pointsRemaining;
    }

    public void setPointsRemaining(float pointsRemaining) {
        this.pointsRemaining = pointsRemaining;
    }

    //Notice that remainderPoints will be a negative number if you've bought datacores from agent.
    //Formula for finding current RP you have is: 
    //currentPoints = remainderPoints + pointsPerDay * <Difference between now and startdate>
    //@see http://wiki.eve-id.net/APIv2_Char_Research_XML	
    public final double getCurrentPoints() {
        double d = ((double) (System.currentTimeMillis() - startDate)) * pointsDaily / DAY;
        return pointsRemaining + d;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getSkillTypeName() {
        return skillTypeName;
    }

    public void setSkillTypeName(String skillTypeName) {
        this.skillTypeName = skillTypeName;
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

    public int getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(int agentLevel) {
        this.agentLevel = agentLevel;
    }

}
