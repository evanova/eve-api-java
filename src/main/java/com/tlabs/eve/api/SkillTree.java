package com.tlabs.eve.api;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class SkillTree implements Serializable {

    private static final long serialVersionUID = -5581942989288072193L;

    public static final class SkillGroup implements Serializable {

        private static final long serialVersionUID = -372508696105801667L;

        private List<Skill> skills = new LinkedList<>();

        private String groupName;
        private long groupID;

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public long getGroupID() {
            return groupID;
        }

        public void setGroupID(long groupID) {
            this.groupID = groupID;
        }

        public void addSkill(Skill skill) {
            skill.setGroupID(this.groupID);
            skill.setGroupName(this.groupName);
            this.skills.add(skill);
        }

        public List<Skill> getSkills() {
            return this.skills;
        }
    }

    private List<SkillGroup> groups = new LinkedList<>();

    public void addGroup(SkillGroup skillGroup) {
        this.groups.add(skillGroup);
    }

    public List<SkillGroup> getGroups() {
        return this.groups;
    }
}
