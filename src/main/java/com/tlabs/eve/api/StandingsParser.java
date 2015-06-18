package com.tlabs.eve.api;



import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

public class StandingsParser extends EveAPIParser<StandingsResponse> {

    private static final class StandingNameRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            getDigester().push("standingName", attributes.getValue("name"));
        }

        @Override
        public void doEnd(String name) {
            getDigester().pop("standingName");
        }
    }

    private static final class AddStandingRule extends SetAttributePropertyRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            getDigester().push(new Standing());
            super.doBegin(name, attributes);
        }

        @Override
        public void doEnd(String name) {
            final Standing standing = (Standing) getDigester().pop();

            final String standingName = (String) getDigester().peek("standingName");
            final StandingsResponse response = (StandingsResponse) getDigester().peek();
            if ("agents".equalsIgnoreCase(standingName)) {
                response.addAgentStanding(standing);
            }
            else
                if ("NPCCorporations".equalsIgnoreCase(standingName)) {
                    response.addCorporationStanding(standing);
                }
                else
                    if ("factions".equalsIgnoreCase(standingName)) {
                        response.addFactionStanding(standing);
                    }
        }
    }

    public StandingsParser() {
        super(StandingsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        onInit(digester, "characterNPCStandings");
        onInit(digester, "corporationNPCStandings");
    }

    private void onInit(Digester digester, String elementName) {
        digester.addRule("eveapi/result/" + elementName + "/rowset", new StandingNameRule());
        digester.addRule("eveapi/result/" + elementName + "/rowset/row", new AddStandingRule());
    }
}
