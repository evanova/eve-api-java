package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
