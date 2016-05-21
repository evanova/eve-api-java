package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


import org.apache.commons.digester3.Digester;
import org.apache.commons.lang3.StringUtils;


public class MailBodiesParser extends EveAPIParser<MailBodiesResponse> {

    public MailBodiesParser() {
        super(MailBodiesResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", MailMessage.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addMessage"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule() {

            @Override
            public void doBody(String name, String text) {
                super.doBody(name, text);
                MailMessage m = getDigester().peek();
                m.setBody(clean(text));
            }
        });
    }

    private static String clean(final String body) {
        return StringUtils.isBlank(body) ? "" : body.trim();
    }
}
