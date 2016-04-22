package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester3.Digester;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@see http://wiki.eve-id.net/APIv2_Char_KillLog_XML
public class KillLogParser extends EveAPIParser<KillLogResponse> {

    private static final Map<String, String> rowRuleMap;
    static {
        rowRuleMap = new HashMap<>();
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
                getDigester().push(new com.tlabs.eve.api.mail.KillMailAttacker());
            }
            else
                if (StringUtils.isNotBlank(attributes.getValue("typeID"))) {
                    getDigester().push(new com.tlabs.eve.api.mail.KillMailItem());
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
            final Object popped = getDigester().pop();
            final List list = getDigester().peek();
            list.add(popped);
        }
    }

    //This deals with rows between "items" and "attackers"
    private static final class RowsetRule extends BaseRule {

        private List<com.tlabs.eve.api.mail.KillMailAttacker> attackers = null;
        private List<com.tlabs.eve.api.mail.KillMailItem> items = null;

        @Override
        public void doBegin(String name, Attributes attributes) {
            this.attackers = null;
            this.items = null;

            final String rowName = attributes.getValue("name");
            if ("items".equals(rowName)) {
                this.items = new ArrayList<>();
                getDigester().push(this.items);
            }
            else
                if ("attackers".equals(rowName)) {
                    this.attackers = new ArrayList<>();
                    getDigester().push(this.attackers);
                }
                else {
                    getDigester().push(new ArrayList<>());
                }
        }

        @Override
        public void doEnd(String name) {
            getDigester().pop();
            final com.tlabs.eve.api.mail.KillMail km = getDigester().peek();
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
        digester.addObjectCreate("eveapi/result/rowset/row", com.tlabs.eve.api.mail.KillMail.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addKill"));

        digester.addObjectCreate("eveapi/result/rowset/row/victim", com.tlabs.eve.api.mail.KillMailVictim.class);
        digester.addRule("eveapi/result/rowset/row/victim", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row/victim", new SetNextRule("setVictim"));

        //Now this is getting slightly more complicated
        digester.addRule("eveapi/result/rowset/row/rowset", new RowsetRule());
        digester.addRule("eveapi/result/rowset/row/rowset/row", new RowRule());
        //FIXME deal with nested rows               
    }
}
