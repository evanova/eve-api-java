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
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//@see http://wiki.eve-id.net/APIv2_Char_KillLog_XML
public class KillLogParser extends EveAPIParser<KillLogResponse> {

    private static final Map<String, String> rowRuleMap;
    static {
        rowRuleMap = new HashMap<String, String>();
        rowRuleMap.put("typeID", "typeID");
        rowRuleMap.put("flag", "flag");
        rowRuleMap.put("singleton", "singleton");
        rowRuleMap.put("qtyDropped", "quantityDropped");
        rowRuleMap.put("qtyDestroyed", "quantityDestroyed");
    }

    //This deals with a row that is either an attacker or item;
    //It requires a list created by "RowsetRule" to be the top object in the stack.
    private static final class RowRule extends SetAttributePropertyRule {

        public RowRule() {
            super(rowRuleMap);
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            if (StringUtils.isNotBlank(attributes.getValue("characterID"))) {
                getDigester().push(new KillMail.Attacker());
            }
            else
                if (StringUtils.isNotBlank(attributes.getValue("typeID"))) {
                    getDigester().push(new KillMail.Item());
                }
                else {
                    getDigester().push("Invalid row");
                }
            super.doBegin(name, attributes);
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override
        public void doEnd(String name) {
            super.doEnd(name);
            final Object popped = digester.pop();
            final List list = (List) digester.peek();
            list.add(popped);
        }
    }

    //This deals with rows between "items" and "attackers"
    private static final class RowsetRule extends BaseRule {

        private List<KillMail.Attacker> attackers = null;
        private List<KillMail.Item> items = null;

        @Override
        public void doBegin(String name, Attributes attributes) {
            this.attackers = null;
            this.items = null;

            final String rowName = attributes.getValue("name");
            if ("items".equals(rowName)) {
                this.items = new LinkedList<KillMail.Item>();
                getDigester().push(this.items);
            }
            else
                if ("attackers".equals(rowName)) {
                    this.attackers = new LinkedList<KillMail.Attacker>();
                    getDigester().push(this.attackers);
                }
                else {
                    getDigester().push(new LinkedList<Object>());
                }
        }

        @Override
        public void doEnd(String name) {
            digester.pop();
            final KillMail km = (KillMail) digester.peek();
            if (this.attackers != null) {
                km.setAttackers(this.attackers);
            }
            if (this.items != null) {
                km.setItems(this.items);
            }
        }
    }

    public KillLogParser() {
        super(KillLogResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", KillMail.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addKill"));

        digester.addObjectCreate("eveapi/result/rowset/row/victim", KillMail.Victim.class);
        digester.addRule("eveapi/result/rowset/row/victim", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row/victim", new SetNextRule("setVictim"));

        //Now this is getting slightly more complicated
        digester.addRule("eveapi/result/rowset/row/rowset", new RowsetRule());
        digester.addRule("eveapi/result/rowset/row/rowset/row", new RowRule());
        //FIXME deal with nested rows               
    }
}
