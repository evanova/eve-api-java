package com.tlabs.eve.api;



public final class SkillTreeRequest extends EveAPIRequest<SkillTreeResponse> {

    public SkillTreeRequest() {
        super(SkillTreeResponse.class, "/eve/SkillTree.xml.aspx", 0);
    }

}
