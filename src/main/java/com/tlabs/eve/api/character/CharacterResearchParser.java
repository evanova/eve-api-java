package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

import java.util.HashMap;
import java.util.Map;

public class CharacterResearchParser extends EveAPIParser<CharacterResearchResponse> {

    private static final Map<String, String> propertyMap;
    static {
        propertyMap = new HashMap<>();
        propertyMap.put("agentID", "agentID");
        propertyMap.put("skillTypeID", "skillTypeID");
        propertyMap.put("researchStartDate", "startDate");
        propertyMap.put("pointsPerDay", "pointsDaily");
        propertyMap.put("remainderPoints", "pointsRemaining");
    }

    public CharacterResearchParser() {
        super(CharacterResearchResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", ResearchJob.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(propertyMap));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addJob"));
    }
}
