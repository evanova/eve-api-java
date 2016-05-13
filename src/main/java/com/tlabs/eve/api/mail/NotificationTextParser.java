package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester3.Digester;
import org.apache.commons.lang.StringUtils;

public class NotificationTextParser extends EveAPIParser<NotificationTextResponse> {

    public NotificationTextParser() {
        super(NotificationTextResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", NotificationMessage.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addMessage"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule() {

            @Override
            public void doBody(String name, String text) {
                super.doBody(name, text);
                NotificationMessage m = getDigester().peek();
                m.setBody(StringUtils.isBlank(text) ? "" : text);
            }
        });
    }
}
