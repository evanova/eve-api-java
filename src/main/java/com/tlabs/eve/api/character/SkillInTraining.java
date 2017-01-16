package com.tlabs.eve.api.character;


import java.io.Serializable;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.Skill;

public class SkillInTraining extends Skill implements Serializable {

    private static final long serialVersionUID = 1194595186724600630L;

    public static final int TYPE_QUEUE = 1;
    public static final int TYPE_PLAN = 2;

    //NOT in XML but much too convenient for clients to pass up
    private int trainingType = TYPE_QUEUE;

    private long trainingEndTime;
    private long trainingStartTime;

    private long startSkillPoints;
    private long endSkillPoints;

    private int trainingLevel;

    public SkillInTraining() {
        super();
    }

    public SkillInTraining(final SkillInTraining t) {
        this(t, t.trainingLevel);
        this.trainingType = t.trainingType;
        this.trainingStartTime = t.trainingStartTime;
        this.trainingEndTime = t.trainingEndTime;
        this.startSkillPoints = t.startSkillPoints;
        this.endSkillPoints = t.endSkillPoints;
    }

    public SkillInTraining(final Skill s, final int level) {
        super(s);
        this.endSkillPoints = 0;
        this.startSkillPoints = 0;
        this.trainingEndTime = 0;
        this.trainingLevel = level;
        this.trainingStartTime = 0;
    }

    public long getEndTime() {
        return trainingEndTime;
    }

    public void setEndTime(long trainingEndTime) {
        this.trainingEndTime = trainingEndTime;
    }

    public void setEndTime(String trainingEndTime) {
        this.trainingEndTime = EveAPI.parseDateTime(trainingEndTime);
    }

    public long getStartTime() {
        return trainingStartTime;
    }

    public void setStartTime(long trainingStartTime) {
        this.trainingStartTime = trainingStartTime;
    }

    public long getStartSkillPoints() {
        return startSkillPoints;
    }

    public void setStartSkillPoints(long startSkillPoints) {
        this.startSkillPoints = startSkillPoints;
    }

    public long getEndSkillPoints() {
        return endSkillPoints;
    }

    public void setEndSkillPoints(long endSkillPoints) {
        this.endSkillPoints = endSkillPoints;
    }

    public int getSkillLevel() {
        return trainingLevel;
    }

    public void setSkillLevel(int trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public int getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(int trainingType) {
        this.trainingType = trainingType;
    }

}
