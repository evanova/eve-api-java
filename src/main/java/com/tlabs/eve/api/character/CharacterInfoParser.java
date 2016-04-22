package com.tlabs.eve.api.character;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class CharacterInfoParser extends EveAPIParser<CharacterInfoResponse> {

    public CharacterInfoParser() {
        super(CharacterInfoResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result", CharacterInfo.class);
        digester.addRule("eveapi/result", new SetNextRule("setCharacterInfo"));
        //Share this instance 
        //(quite unusual for the digester, but in this particular case it's ok)
        SetElementPropertyRule setElementPropertyRule = new SetElementPropertyRule();
        digester.addRule("eveapi/result/characterID", setElementPropertyRule);
        digester.addRule("eveapi/result/skillPoints", setElementPropertyRule);
        digester.addRule("eveapi/result/shipName", setElementPropertyRule);
        digester.addRule("eveapi/result/shipTypeID", setElementPropertyRule);
        digester.addRule("eveapi/result/shipTypeName", setElementPropertyRule);
        digester.addRule("eveapi/result/corporationDate", setElementPropertyRule);
        digester.addRule("eveapi/result/allianceID", setElementPropertyRule);
        digester.addRule("eveapi/result/alliance", setElementPropertyRule);
        digester.addRule("eveapi/result/allianceDate", setElementPropertyRule);
        digester.addRule("eveapi/result/lastKnownLocation", setElementPropertyRule);
        digester.addRule("eveapi/result/securityStatus", setElementPropertyRule);

        digester.addObjectCreate("eveapi/result/rowset/row", CharacterInfo.History.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addHistory"));

    }
}
