package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

public class StationsParser extends EveAPIParser<StationsResponse> {

    public StationsParser() {
        super(StationsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", Station.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addStation"));
    }

    @Override
    protected void doAfterParse(StationsResponse t) {
        //1H is too short
        t.setCachedUntil(System.currentTimeMillis() + 12l * 3600l * 1000l);
    }
}
