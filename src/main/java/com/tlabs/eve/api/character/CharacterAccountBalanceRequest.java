package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AccountBalanceResponse;

public final class CharacterAccountBalanceRequest extends CharacterRequest<AccountBalanceResponse> {
    public static final int MASK = 1;

    public CharacterAccountBalanceRequest(String characterID) {
        super(AccountBalanceResponse.class, "/char/AccountBalance.xml.aspx", MASK, characterID);
    }

}
