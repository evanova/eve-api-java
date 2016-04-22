package com.tlabs.eve.api.character;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class CharacterTrainingParser extends EveAPIParser<CharacterTrainingResponse> {

    public CharacterTrainingParser() {
        super(CharacterTrainingResponse.class);
    }

    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result", SkillInTraining.class);
        digester.addRule("eveapi/result", new SetNextRule("setTraining"));
        digester.addRule("eveapi/result/currentTQTime", new SetElementPropertyRule("queueTime"));
        digester.addRule("eveapi/result/trainingEndTime", new SetElementPropertyRule("endTime"));
        digester.addRule("eveapi/result/trainingStartTime", new SetElementPropertyRule("startTime"));
        digester.addRule("eveapi/result/trainingTypeID", new SetElementPropertyRule("skillID"));
        digester.addRule("eveapi/result/trainingStartSP", new SetElementPropertyRule("startSkillPoints"));
        digester.addRule("eveapi/result/trainingDestinationSP", new SetElementPropertyRule("endSkillPoints"));
        digester.addRule("eveapi/result/trainingToLevel", new SetElementPropertyRule("skillLevel"));
    }
}
