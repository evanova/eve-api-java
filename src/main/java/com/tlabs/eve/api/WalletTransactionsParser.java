package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.digester3.Digester;

public final class WalletTransactionsParser extends EveAPIParser<WalletTransactionsResponse> {

    private static final Map<String, String> attributes;
    static {
        attributes = new HashMap<>();
        attributes.put("transactionDateTime", "when");
        attributes.put("transactionID", "ID");
        attributes.put("quantity", "quantity");
        attributes.put("typeName", "typeName");
        attributes.put("typeID", "typeID");
        attributes.put("price", "price");
        attributes.put("clientID", "clientID");
        attributes.put("clientName", "clientName");
        attributes.put("stationID", "stationID");
        attributes.put("stationName", "stationName");
        attributes.put("transactionType", "type");
        attributes.put("transactionFor", "target");
    }

    public WalletTransactionsParser() {
        super(WalletTransactionsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", WalletTransaction.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(attributes));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addTransaction"));
    }
}
