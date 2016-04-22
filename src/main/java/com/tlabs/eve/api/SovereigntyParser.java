package com.tlabs.eve.api;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


public final class SovereigntyParser extends EveAPIParser<SovereigntyResponse> {

    public SovereigntyParser() {
        super(SovereigntyResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", Sovereignty.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addSovereignty"));
    }
}
