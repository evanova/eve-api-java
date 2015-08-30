package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

public class ChatChannelParser extends EveAPIParser<ChatChannelResponse> {

    private static class AccessorGroupRule extends BaseRule {
        @Override
        public void doBegin(String name, Attributes attributes) {
            getDigester().push(attributes.getValue("name"));
        }

    }

    public ChatChannelParser() {
        super(ChatChannelResponse.class);
    }

    protected void onInit(Digester digester) {
       // digester.addRule("eveapi/result/rowset/row/rowset", new AccessorGroupRule());
        digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ChatChannel.Accessor.class);
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetNextRule("addAccessor"));

        digester.addObjectCreate("eveapi/result/rowset/row", ChatChannel.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addChannel"));
    }
}
