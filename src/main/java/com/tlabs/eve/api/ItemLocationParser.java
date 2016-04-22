package com.tlabs.eve.api;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

/**@since Eve API V2*/
//@see https://forums.eveonline.com/default.aspx?g=posts&t=58316&find=unread
public class ItemLocationParser extends EveAPIParser<ItemLocationResponse> {

    public ItemLocationParser() {
        super(ItemLocationResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", ItemLocation.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addLocation"));
    }
}
