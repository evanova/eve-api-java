package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.digester3.Digester;

public class MarketOrderParser extends EveAPIParser<MarketOrderResponse> {

    private static final Map<String, String> attributes;
    static {
        attributes = new HashMap<>();
        attributes.put("orderID", "orderID");
        attributes.put("charID", "characterID");
        attributes.put("stationID", "stationID");
        attributes.put("volEntered", "initialVolume");
        attributes.put("volRemaining", "remainingVolume");
        attributes.put("minVolume", "minVolume");
        attributes.put("orderState", "state");
        attributes.put("typeID", "itemID");
        attributes.put("range", "range");
        attributes.put("accountKey", "accountKey");
        attributes.put("escrow", "marketEscrow");
        attributes.put("price", "price");
        attributes.put("bid", "buyOrder");
        attributes.put("issued", "issueDate");
        attributes.put("duration", "durationInDays");
    }

    public MarketOrderParser() {
        super(MarketOrderResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", MarketOrder.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(attributes));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addOrder"));
    }
}
