package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIResponse;

public final class CharacterTrainingResponse extends EveAPIResponse {

    private static final long serialVersionUID = -7464889868229116522L;

    private SkillInTraining training;

    public SkillInTraining getTraining() {
        return training;
    }

    public void setTraining(SkillInTraining training) {
        this.training = training;
    }

}
