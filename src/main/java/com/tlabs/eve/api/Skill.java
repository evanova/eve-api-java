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

import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Skill implements Serializable {

    private static final long serialVersionUID = -7817873833847609019L;

    private boolean published;

    private long skillID;
    private String skillName;

    private long groupID;
    private String groupName;

    private String description;
    private int rank;

    private Map<Long, Integer> requiredSkills;

    private String primaryAttribute;
    private String secondaryAttribute;

    protected Skill(final Skill s) {
        this();
        Validate.notNull(s, "Skill");
        this.primaryAttribute = s.primaryAttribute;
        this.secondaryAttribute = s.secondaryAttribute;
        this.requiredSkills.putAll(s.getRequiredSkills());
        this.rank = s.rank;
        this.description = s.description;
        this.groupID = s.groupID;
        this.groupName = s.groupName;
        this.skillID = s.skillID;
        this.skillName = s.skillName;
        this.published = s.published;
    }

    public Skill() {
        super();
        this.requiredSkills = new HashMap<Long, Integer>();
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public final long getGroupID() {
        return groupID;
    }

    public final void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public final String getGroupName() {
        return groupName;
    }

    public final void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public final long getSkillID() {
        return skillID;
    }

    public void setSkillID(long skillID) {
        this.skillID = skillID;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public final String getSkillName() {
        return skillName;
    }

    public final void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public final int getRank() {
        return rank;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(String primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public String getSecondaryAttribute() {
        return secondaryAttribute;
    }

    public void setSecondaryAttribute(String secondaryAttribute) {
        this.secondaryAttribute = secondaryAttribute;
    }

    public void addRequiredSkill(long skillID, int skillLevel) {
        requiredSkills.put(skillID, skillLevel);
    }

    public Map<Long, Integer> getRequiredSkills() {
        return this.requiredSkills;
    }

    public String toString() {
        return "Skill [id=" + this.getSkillID() + "; name=" + this.getSkillName() + "; groupID=" + this.groupID + "; rank=" + this.getRank() + "]";
    }

}
