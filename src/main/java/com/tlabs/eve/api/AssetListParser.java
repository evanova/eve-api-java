package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

import java.util.HashMap;

public final class AssetListParser extends EveAPIParser<AssetListResponse> {

    private static final HashMap<String, String> properties;
    static {
        properties = new HashMap<>();
        properties.put("locationID", "locationID");
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
