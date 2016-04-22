package com.tlabs.eve.api.character;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


public final class PlanetaryLinksParser extends EveAPIParser<PlanetaryLinksResponse> {

    public PlanetaryLinksParser() {
        super(PlanetaryLinksResponse.class);
    }

    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", PlanetaryLink.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addLink"));
    }
}
