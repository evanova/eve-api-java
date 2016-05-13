package com.tlabs.eve.api;



import com.tlabs.eve.api.SkillTree.SkillGroup;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester3.Digester;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.Map;

public class SkillTreeParser extends EveAPIParser<SkillTreeResponse> {

    private static final Map<String, String> attributeMap;
    static {
        attributeMap = new HashMap<>();

        attributeMap.put("typeName", "skillName");
        attributeMap.put("typeID", "skillID");
        attributeMap.put("published", "published");
    }

    private static class SkillRowSetRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            Skill skill = getDigester().peek();

            String typeID = attributes.getValue("typeID");
            if (StringUtils.isNotBlank(typeID)) {
                //that's a required skill ID and its level
                skill.addRequiredSkill(Integer.parseInt(typeID), Integer.parseInt(attributes.getValue("skillLevel")));
                return;
            }

            /*String bonusType = attributes.getValue("bonusType");
            if (StringUtils.isNotBlank(bonusType)) {
            	skill.addSkillBonus(
            			bonusType,
            			attributes.getValue("bonusValue"));
            	return;
            }	*/
        }
    }

    public SkillTreeParser() {
        super(SkillTreeResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result", SkillTree.class);
        digester.addRule("eveapi/result", new com.tlabs.eve.parser.SetNextRule("setSkillTree"));

        digester.addObjectCreate("eveapi/result/rowset/row", SkillGroup.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addGroup"));

        digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Skill.class);
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetAttributePropertyRule(attributeMap));
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetNextRule("addSkill"));

        digester.addRule("eveapi/result/rowset/row/rowset/row/description", new SetElementPropertyRule());

        digester.addRule("eveapi/result/rowset/row/rowset/row/rank", new SetElementPropertyRule());

        digester.addRule("eveapi/result/rowset/row/rowset/row/requiredAttributes/primaryAttribute", new SetElementPropertyRule());
        digester.addRule("eveapi/result/rowset/row/rowset/row/requiredAttributes/secondaryAttribute", new SetElementPropertyRule());

        digester.addRule("eveapi/result/rowset/row/rowset/row/rowset/row", new SkillRowSetRule());
    }
}
