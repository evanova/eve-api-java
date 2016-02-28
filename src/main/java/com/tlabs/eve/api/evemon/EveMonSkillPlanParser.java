package com.tlabs.eve.api.evemon;



import com.tlabs.eve.api.character.CharacterTrainingQueueResponse;
import com.tlabs.eve.api.character.SkillInTraining;
import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

public final class EveMonSkillPlanParser extends AbstractXMLParser<CharacterTrainingQueueResponse> {

    private static final class PropertyRules extends BaseRule {
        @Override
        public void doBegin(String name, Attributes attributes) {
            SkillInTraining t = (SkillInTraining) getDigester().peek();
            t.setSkillID(Long.parseLong(attributes.getValue("skillID")));
            t.setSkillLevel(Integer.parseInt(attributes.getValue("level")));
            t.setSkillName(attributes.getValue("skill"));
            String type = attributes.getValue("type");
            if ("prerequisite".equalsIgnoreCase(type)) {
                t.setTrainingType(SkillInTraining.TYPE_REQUIRED);
            }
            else {
                t.setTrainingType(SkillInTraining.TYPE_PLAN);
            }
        }
    }

    public EveMonSkillPlanParser() {
        super(CharacterTrainingQueueResponse.class);
    }

    protected void init(final Digester digester) {
        digester.addObjectCreate("plan/entry", SkillInTraining.class);
        digester.addRule("plan/entry", new PropertyRules());
        digester.addRule("plan/entry", new SetNextRule("addTraining"));
    }
}
