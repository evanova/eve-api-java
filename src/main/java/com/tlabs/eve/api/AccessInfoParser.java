package com.tlabs.eve.api;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.character.CharacterSheet;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfoParser extends EveAPIParser<AccessInfoResponse> {

    public AccessInfoParser() {
        super(AccessInfoResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/key", new SetAttributePropertyRule());
        digester.addObjectCreate("eveapi/result/key/rowset/row", CharacterSheet.class);
        digester.addRule("eveapi/result/key/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/key/rowset/row", new SetNextRule("addCharacter"));
    }
}
