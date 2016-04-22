package com.tlabs.eve.api.mail;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


/**@since Eve API V3 (30 Aug 2011*/
public class ContactNotificationsParser extends EveAPIParser<ContactNotificationsResponse> {

    public ContactNotificationsParser() {
        super(ContactNotificationsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", ContactNotification.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addNotification"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
    }
}
