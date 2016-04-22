package com.tlabs.eve.api.evemon;



import com.tlabs.eve.api.AccessInfo;
import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.digester3.Digester;

public final class EveMonSettingsParser extends AbstractXMLParser<EveMonSettingsResponse> {

    private static final Map<String, String> propertyMap;
    static {
        propertyMap = new HashMap<>();
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
