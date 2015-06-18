package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

public class MailMessagesParser extends EveAPIParser<MailMessagesResponse> {

    public MailMessagesParser() {
        super(MailMessagesResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", com.tlabs.eve.api.mail.MailMessage.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addMessage"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
    }
}
