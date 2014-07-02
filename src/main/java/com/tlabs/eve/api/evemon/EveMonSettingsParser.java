package com.tlabs.eve.api.evemon;

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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import com.tlabs.eve.api.AccessInfo;
import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class EveMonSettingsParser extends AbstractXMLParser<EveMonSettingsResponse> {

    private static final Map<String, String> propertyMap;
    static {
        propertyMap = new HashMap<String, String>();
        propertyMap.put("id", "keyID");
        propertyMap.put("vCode", "key");
        propertyMap.put("accessMask", "accessMask");
        propertyMap.put("type", "type");
        //propertyMap.put("expires", "expires");//Dont use it; it's illformed and wrong.
        //propertyMap.put("lastUpdate", "");
        //propertyMap.put("monitored", "");		
    }

    public EveMonSettingsParser() {
        super(EveMonSettingsResponse.class);
    }

    protected void init(final Digester digester) {
        digester.addObjectCreate("Settings/apiKeys/apikey", AccessInfo.class);
        digester.addRule("Settings/apiKeys/apikey", new SetAttributePropertyRule(propertyMap));
        digester.addRule("Settings/apiKeys/apikey", new SetNextRule("addApiKey"));
    }
}
