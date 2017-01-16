package com.tlabs.eve.api;

import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
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

    /*@Deprecated
    private Map<Long, Integer> requiredSkills;
    private List<Skill> requirements;*/
    private Map<Skill, Integer> requirements;

    private String primaryAttribute;
    private String secondaryAttribute;

    protected Skill(final Skill s) {
        this();
        Validate.notNull(s, "Skill");
        this.primaryAttribute = s.primaryAttribute;
        this.secondaryAttribute = s.secondaryAttribute;
        this.rank = s.rank;
        this.description = s.description;
        this.groupID = s.groupID;
        this.groupName = s.groupName;
        this.skillID = s.skillID;
        this.skillName = s.skillName;
        this.published = s.published;
        this.requirements = s.requirements;
    }

    public Skill() {
        super();
        this.requirements = new LinkedHashMap<>();
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

    void addRequirement(final long skillID, final int level) {
        Skill skill = new Skill();
        skill.setSkillID(skillID);
        addRequirement(skill, level);
    }

    public void addRequirement(final Skill skill, final int level) {
        for (Map.Entry<Skill, Integer> e: this.requirements.entrySet()) {
            if (e.getKey().getSkillID() == skill.getSkillID()) {
                if (level > e.getValue()) {
                    this.requirements.put(skill, level);
                }
                return;
            }
        }

        this.requirements.put(skill, level);
    }

    public Map<Skill, Integer> getRequirements() {
        return Collections.unmodifiableMap(this.requirements);
    }

    public Map<Skill, Integer> getAllRequirements() {
        return SkillRequirements.mapAll(this);
    }

    public String toString() {
        return "Skill [id=" + this.getSkillID() + "; name=" + this.getSkillName() + "; groupID=" + this.groupID + "; rank=" + this.getRank() + "]";
    }

}
