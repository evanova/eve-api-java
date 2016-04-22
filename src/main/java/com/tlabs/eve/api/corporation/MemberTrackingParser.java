package com.tlabs.eve.api.corporation;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;


public final class MemberTrackingParser extends EveAPIParser<MemberTrackingResponse> {

    public MemberTrackingParser() {
        super(MemberTrackingResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", CorporationMember.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addCorpMember"));
    }
}
