package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class CharacterTrainingQueueResponse extends EveAPIResponse {

    private static final long serialVersionUID = -2833478320644411761L;

    private List<SkillInTraining> trainingQueue;

    public CharacterTrainingQueueResponse() {
        super();
        this.trainingQueue = new LinkedList<>();
    }

    public void addTraining(SkillInTraining training) {
        this.trainingQueue.add(training);
    }

    public List<SkillInTraining> getTrainingQueue() {
        return this.trainingQueue;
    }
}
