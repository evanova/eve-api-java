package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.AccountBalanceResponse;

public final class CorporationAccountBalanceRequest extends CorporationRequest<AccountBalanceResponse> {
    public static final int MASK = 1;

    public CorporationAccountBalanceRequest(String corpID) {
        super(AccountBalanceResponse.class, "/corp/AccountBalance.xml.aspx", MASK, corpID);
    }

}
