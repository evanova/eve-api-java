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
import java.util.LinkedList;
import java.util.List;

public class SkillTree implements Serializable {

    private static final long serialVersionUID = -5581942989288072193L;

    public static final class SkillGroup implements Serializable {

        private static final long serialVersionUID = -372508696105801667L;

        private List<Skill> skills = new LinkedList<Skill>();

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

    private List<SkillGroup> groups = new LinkedList<SkillGroup>();

    public void addGroup(SkillGroup skillGroup) {
        this.groups.add(skillGroup);
    }

    public List<SkillGroup> getGroups() {
        return this.groups;
    }
}
