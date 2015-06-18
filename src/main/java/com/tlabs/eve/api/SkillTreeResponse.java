package com.tlabs.eve.api;



public class SkillTreeResponse extends EveAPIResponse {

    private static final long serialVersionUID = 9154818588760810821L;

    private SkillTree skillTree;

    public SkillTreeResponse() {
        super();
    }

    public void setSkillTree(SkillTree skillTree) {
        this.skillTree = skillTree;
    }

    public SkillTree getSkillTree() {
        return this.skillTree;
    }
}
