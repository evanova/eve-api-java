package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

import java.util.HashMap;
import java.util.Map;

public final class WalletJournalParser extends EveAPIParser<WalletJournalResponse> {

    private static final Map<String, String> attributes;
    static {
        attributes = new HashMap<>();
        attributes.put("refID", "id");
        attributes.put("date", "when");
        attributes.put("refTypeID", "refTypeID");
        attributes.put("ownerID1", "ownerID1");
        attributes.put("ownerName1", "ownerName1");
        attributes.put("ownerID2", "ownerID2");
        attributes.put("ownerName2", "ownerName2");
        attributes.put("reason", "reason");
        attributes.put("amount", "amount");
        attributes.put("balance", "balance");
        attributes.put("argID1", "argID");
        attributes.put("argName1", "argName");
        attributes.put("taxReceiverID", "taxReceiverID");
        attributes.put("taxAmount", "taxAmount");
    }

    public WalletJournalParser() {
        super(WalletJournalResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", WalletJournalEntry.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(attributes));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addTransaction"));
    }
}
