package com.tlabs.eve.api.mail;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


public class NotificationsParser extends EveAPIParser<NotificationsResponse> {

    public NotificationsParser() {
        super(NotificationsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", com.tlabs.eve.api.mail.NotificationMessage.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addMessage"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
    }
}
