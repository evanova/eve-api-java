package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AccountBalanceResponse;

public final class CharacterAccountBalanceRequest extends CharacterRequest<AccountBalanceResponse> {
    public static final long MASK = 1;

    public CharacterAccountBalanceRequest(long characterID) {
        super(AccountBalanceResponse.class, "/char/AccountBalance.xml.aspx", MASK, characterID);
    }

}
