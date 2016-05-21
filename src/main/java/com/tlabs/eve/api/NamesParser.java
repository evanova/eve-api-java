package com.tlabs.eve.api;



import com.tlabs.eve.parser.BaseRule;

import org.apache.commons.digester3.Digester;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.Attributes;

public class NamesParser extends EveAPIParser<NamesResponse> {

    private static final class SetKeyRule extends BaseRule {
        @Override
        public void doBegin(String name, Attributes attributes) {
            NamesResponse r = getDigester().peek();
            r.setKey(attributes.getValue("key"));
        }
    }

    private static final class SetNameRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            NamesResponse r = getDigester().peek();
            String key = r.getKey();
            if (StringUtils.isBlank(key)) {
                return;
            }

            Long id = null;
            try {
                String cid = attributes.getValue(key);
                if (StringUtils.isNotBlank(cid)) {
                    id = Long.parseLong(cid);
                }
            }
            catch (NumberFormatException e) {
                //Moooh
            }
            if (null == id) {
                return;//he?!
            }
            String charName = attributes.getValue("name");
            if (StringUtils.isNotBlank(charName)) {
                r.add(id, charName.trim());
            }
        }
    }

    public NamesParser() {
        super(NamesResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset", new SetKeyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNameRule());
    }
}
