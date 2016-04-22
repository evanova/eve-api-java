package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import java.util.HashMap;
import org.apache.commons.digester3.Digester;

public class CharacterTrainingQueueParser extends EveAPIParser<CharacterTrainingQueueResponse> {

    private static final HashMap<String, String> properties;
    static {
        properties = new HashMap<>();
        properties.put("queuePosition", "queuePosition");
        properties.put("typeID", "skillID");
        properties.put("level", "skillLevel");
        properties.put("startSP", "startSkillPoints");
        properties.put("endSP", "endSkillPoints");
        properties.put("startTime", "startTime");
        properties.put("endTime", "endTime");
    }

    public CharacterTrainingQueueParser() {
        super(CharacterTrainingQueueResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", SkillInTraining.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(properties));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addTraining"));
    }

}
