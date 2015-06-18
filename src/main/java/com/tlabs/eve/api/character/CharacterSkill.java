package com.tlabs.eve.api.character;



import java.io.Serializable;

public class CharacterSkill implements Serializable {

    private static final long serialVersionUID = 6174117605966135583L;

    private long skillID;

    private int skillLevel;
    private long skillPoints;

    public final long getSkillID() {
        return skillID;
    }

    public void setSkillID(long skillID) {
        this.skillID = skillID;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public long getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(long skillPoints) {
        this.skillPoints = skillPoints;
    }

}
