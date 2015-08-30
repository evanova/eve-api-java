package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

import java.util.HashMap;

public final class AssetListParser extends EveAPIParser<AssetListResponse> {

    private static final HashMap<String, String> properties;
    static {
        properties = new HashMap<>();
        properties.put("locationID", "locationID");
        properties.put("itemID", "assetID");
        properties.put("typeID", "itemID");//the itemID in the XML is a temporary ID
        properties.put("quantity", "quantity");
        properties.put("flag", "inventoryFlag");
        properties.put("singleton", "packaged");
    }

    public AssetListParser() {
        super(AssetListResponse.class);
    }

    //@see http://wiki.eve-id.net/APIv2_Char_AssetList_XML
    @Override
    protected void onInit(Digester digester) {

        digester.addObjectCreate("eveapi/result/rowset/row", Asset.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule(properties));
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addAsset"));

        digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Asset.class);
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetAttributePropertyRule(properties));
        digester.addRule("eveapi/result/rowset/row/rowset/row", new SetNextRule("addAsset"));

    }
}
