package com.tlabs.eve.api.mail;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


public class MailingListsParser extends EveAPIParser<MailingListsResponse> {

    public MailingListsParser() {
        super(MailingListsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", MailingList.class);
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addMailingList"));
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
    }
}
