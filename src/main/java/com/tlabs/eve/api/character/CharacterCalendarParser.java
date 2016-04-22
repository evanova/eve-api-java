package com.tlabs.eve.api.character;

import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class CharacterCalendarParser extends EveAPIParser<CharacterCalendarResponse> {

    public CharacterCalendarParser() {
        super(CharacterCalendarResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", CharacterCalendar.Entry.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addEntry"));
    }
}
