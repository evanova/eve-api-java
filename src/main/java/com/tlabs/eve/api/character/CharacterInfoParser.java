package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

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
        digester.addRule("eveapi/result/alliancenDate", setElementPropertyRule);
        digester.addRule("eveapi/result/lastKnownLocation", setElementPropertyRule);
        digester.addRule("eveapi/result/securityStatus", setElementPropertyRule);
    }
}
