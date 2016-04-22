package com.tlabs.eve.api;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class AccountStatusParser extends EveAPIParser<AccountStatusResponse> {

    public AccountStatusParser() {
        super(AccountStatusResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result", AccountStatus.class);
        digester.addRule("eveapi/result", new SetNextRule("setAccountStatus"));

        digester.addRule("eveapi/result/userID", new SetElementPropertyRule());
        digester.addRule("eveapi/result/paidUntil", new SetElementPropertyRule());
        digester.addRule("eveapi/result/createDate", new SetElementPropertyRule("creationDate"));
        digester.addRule("eveapi/result/logonCount", new SetElementPropertyRule());
        digester.addRule("eveapi/result/logonMinutes", new SetElementPropertyRule());
    }
}
