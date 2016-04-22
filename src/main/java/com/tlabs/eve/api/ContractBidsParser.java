package com.tlabs.eve.api;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public class ContractBidsParser extends EveAPIParser<ContractBidsResponse> {
    public ContractBidsParser() {
        super(ContractBidsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", ContractBid.class);
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addBid"));
    }
}
