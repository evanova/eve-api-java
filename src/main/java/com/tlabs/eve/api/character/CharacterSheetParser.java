package com.tlabs.eve.api.character;

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

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.api.corporation.CorporationRole;
import com.tlabs.eve.api.corporation.CorporationTitle;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class CharacterSheetParser extends EveAPIParser<CharacterSheetResponse> {
    private static final Log LOG = LogFactory.getLog("CREST");

    private static final class RowSet {

        private List<Map<String, String>> rows;
        private String rowName = null;

        public RowSet() {
            super();
            this.rows = new LinkedList<Map<String, String>>();
        }

        public void addRow(Attributes attributes) {
            int l = attributes.getLength();
            Map<String, String> attrs = new HashMap<String, String>();
            for (int i = 0; i < l; i++) {
                //BUG
                //There is a bug in Android 2.1 and Android 1.5 implementation of org.xml.sax.Attributes.getLocalName(int)
                //YES I have verified that with 2.1-update1 :0)
                //Attributes.getLocalName(int) will return an empty String while this is not the case
                //when using Android 2.3 and later.
                //getQName() behaves correctly but in our case, it is a bit unhealthy to rely on a QName.
                //(because we match only local names here).
                //Note that this is probably related to namespace handling with the Digester SAX parser.
                //There already a workaround on the EveMonSkillPlanParser code regarding namespaces.
                //@see http://www.stylusstudio.com/xmldev/200403/post60330.html
                //As a workaround, check the local name; if it's empty, use the QName assuming Eve XML won't change.
                //FIXME Another fix would be to rely on the column attribute from the EVE XML to find ours columns
                //(which may be actually more robust)

                String attrName = attributes.getLocalName(i);
                if (StringUtils.isBlank(attrName)) {
                    attrName = attributes.getQName(i);
                }
                if (StringUtils.isBlank(attrName)) {
                    if (LOG.isWarnEnabled()) {
                        LOG.warn("CharacterSheetParser: encountered an empty attribute name. Check LocalName/QName.");
                    }
                }
                else {
                    attrs.put(attrName, attributes.getValue(i));
                }
            }
            this.rows.add(attrs);
        }

        public List<Map<String, String>> getRows() {
            return rows;
        }

        public String getRowName() {
            return rowName;
        }

        public void setRowName(String rowName) {
            this.rowName = rowName;
        }
    }

    private static final class CreateRowSetRule extends BaseRule {

        public CreateRowSetRule() {
            super();
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            RowSet rs = new RowSet();
            rs.setRowName(attributes.getValue("name"));
            getDigester().push(rs);
        }

        @Override
        public void doEnd(String name) {
            final RowSet rs = (RowSet) getDigester().pop();
            final String rowName = rs.getRowName().trim();
            CharacterSheet character = (CharacterSheet) getDigester().peek();

            if ("skills".equalsIgnoreCase(rowName)) {
                addSkills(character, rs.getRows());
            }
            else if ("corporationRoles".equalsIgnoreCase(rowName)) {
                    addRoles(character, rs.getRows(), CorporationRole.AT_CORP);
            }
            else if ("corporationRolesAtHQ".equalsIgnoreCase(rowName)) {
                addRoles(character, rs.getRows(), CorporationRole.AT_HQ);
            }
            else if ("corporationRolesAtBase".equalsIgnoreCase(rowName)) {
                addRoles(character, rs.getRows(), CorporationRole.AT_BASE);
            }
            else if ("corporationRolesAtOther".equalsIgnoreCase(rowName)) {
                addRoles(character, rs.getRows(), CorporationRole.AT_OTHER);
            }
            else if ("corporationTitles".equalsIgnoreCase(rowName)) {
                addTitles(character, rs.getRows());
            }
            else if ("certificates".equalsIgnoreCase(rowName)) {
                addCertificates(character, rs.getRows());
            }
            else if ("jumpClones".equalsIgnoreCase(rowName)) {
                addJumpClones(character, rs.getRows());
            }
            else if ("implants".equalsIgnoreCase(rowName)) {
                addImplants(character, rs.getRows());
            }
            else if ("jumpCloneImplants".equalsIgnoreCase(rowName)) {
                addJumpCloneImplants(character, rs.getRows());
            }
        }

        private static void addSkills(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                CharacterSkill skill = new CharacterSkill();
                try {
                    skill.setSkillID(Long.parseLong(attr.get("typeID")));
                    skill.setSkillPoints(Long.parseLong(attr.get("skillpoints")));
                    skill.setSkillLevel(Integer.parseInt(attr.get("level")));

                    c.addSkill(skill);
                }
                catch (NumberFormatException e) {
                    //I've seen it happen with the typeID unfortunately
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("addSkills: NumberFormatException: " + e.getLocalizedMessage());
                    }
                }
            }
        }

        private static void addRoles(CharacterSheet c, List<Map<String, String>> attrs, int type) {
            for (Map<String, String> attr : attrs) {
                try {
                    CorporationRole role = new CorporationRole(type);

                    role.setRoleID(Long.parseLong(attr.get("roleID")));
                    role.setRoleName(attr.get("roleName"));
                    c.addRole(role);
                }
                catch (NumberFormatException e) {
                    //carefuller than sorry
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("addRoles: NumberFormatException: " + e.getLocalizedMessage());
                    }
                }
            }
        }

        private static void addTitles(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                try {
                    CorporationTitle title = new CorporationTitle();

                    title.setTitleID(Long.parseLong(attr.get("titleID")));
                    title.setTitle(attr.get("titleName"));
                    c.addTitle(title);
                }
                catch (NumberFormatException e) {
                    //carefuller than sorry
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("addTitles: NumberFormatException: " + e.getLocalizedMessage());
                    }
                }
            }
        }

        private static void addCertificates(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                try {
                    c.addCertificate(Long.parseLong(attr.get("certificateID")));
                }
                catch (NumberFormatException e) {
                    //I've seen it happen with the typeID unfortunately
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("addCertificates: NumberFormatException: " + e.getLocalizedMessage());
                    }
                }
            }
        }

        private static void addJumpClones(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                CharacterSheet.JumpClone jumpClone = new CharacterSheet.JumpClone();
                jumpClone.setName(attr.get("cloneName"));
                jumpClone.setCloneID(Long.parseLong(attr.get("jumpCloneID")));
                jumpClone.setTypeID(Long.parseLong(attr.get("typeID")));
                jumpClone.setLocationID(Long.parseLong(attr.get("locationID")));
                c.addJumpClone(jumpClone);
            }
        }

        private static void addImplants(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                CharacterSheet.Implant implant = new CharacterSheet.Implant();
                implant.setTypeName(attr.get("typeName"));
                implant.setTypeID(Long.parseLong(attr.get("typeID")));
                c.addImplant(implant);
            }
        }

        private static void addJumpCloneImplants(CharacterSheet c, List<Map<String, String>> attrs) {
            for (Map<String, String> attr : attrs) {
                CharacterSheet.Implant implant = new CharacterSheet.Implant();
                implant.setTypeName(attr.get("typeName"));
                implant.setTypeID(Long.parseLong(attr.get("typeID")));
                c.addJumpCloneImplant(Long.parseLong(attr.get("jumpCloneID")), implant);
            }
        }
    }

    private static final class AddRowRule extends BaseRule {

        public AddRowRule() {
            super();
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            RowSet rs = (RowSet) getDigester().peek();
            rs.addRow(attributes);
        }
    }

    public CharacterSheetParser() {
        super(CharacterSheetResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result", CharacterSheet.class);
        digester.addRule("eveapi/result", new SetNextRule("setCharacter"));

        digester.addRule("eveapi/result/rowset", new CreateRowSetRule());
        digester.addRule("eveapi/result/rowset/row", new AddRowRule());
        //Share this instance 
        //(quite unusual for the digester, but in this particular case it's ok)
        SetElementPropertyRule setElementPropertyRule = new SetElementPropertyRule();

        digester.addRule("eveapi/result/characterID", setElementPropertyRule);
        digester.addRule("eveapi/result/name", new SetElementPropertyRule("characterName"));
        digester.addRule("eveapi/result/DoB", new SetElementPropertyRule("birthdate"));
        digester.addRule("eveapi/result/race", setElementPropertyRule);
        digester.addRule("eveapi/result/bloodLine", setElementPropertyRule);
        digester.addRule("eveapi/result/ancestry", setElementPropertyRule);
        digester.addRule("eveapi/result/gender", setElementPropertyRule);
        digester.addRule("eveapi/result/corporationName", setElementPropertyRule);
        digester.addRule("eveapi/result/corporationID", setElementPropertyRule);
        digester.addRule("eveapi/result/cloneName", setElementPropertyRule);
        digester.addRule("eveapi/result/cloneSkillPoints", setElementPropertyRule);
        digester.addRule("eveapi/result/balance", setElementPropertyRule);

        digester.addRule("eveapi/result/homeStationID", setElementPropertyRule);
        digester.addRule("eveapi/result/lastRespecDate", setElementPropertyRule);
        digester.addRule("eveapi/result/lastTimedRespec", setElementPropertyRule);
        digester.addRule("eveapi/result/freeRespecs", setElementPropertyRule);
        digester.addRule("eveapi/result/freeSkillPoints", setElementPropertyRule);

        digester.addRule("eveapi/result/jumpActivation", setElementPropertyRule);
        digester.addRule("eveapi/result/jumpFatigue", setElementPropertyRule);
        digester.addRule("eveapi/result/jumpLastUpdate", setElementPropertyRule);

        digester.addRule("eveapi/result/remoteStationDate", setElementPropertyRule);

        digester.addRule("eveapi/result/attributes/intelligence", setElementPropertyRule);
        digester.addRule("eveapi/result/attributes/memory", setElementPropertyRule);
        digester.addRule("eveapi/result/attributes/charisma", setElementPropertyRule);
        digester.addRule("eveapi/result/attributes/perception", setElementPropertyRule);
        digester.addRule("eveapi/result/attributes/willpower", setElementPropertyRule);
    }
}
