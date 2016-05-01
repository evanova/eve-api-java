package com.tlabs.eve.api;

import com.tlabs.eve.api.EveAPIRequest.Authenticated;


public final class AccountStatusRequest extends EveAPIRequest<AccountStatusResponse> implements Authenticated {
    public static final long MASK = 33554432;

    private String keyID;
    private String key;

    public AccountStatusRequest(String keyID, String key) {
        super(AccountStatusResponse.class, "/account/AccountStatus.xml.aspx", MASK);

        this.keyID = keyID;
        this.key = key;
        putParam("keyID", keyID);
        putParam("vCode", key);
    }

    public final String getKeyID() {
        return keyID;
    }

    public final void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    public final String getKey() {
        return key;
    }

    public final void setKey(String key) {
        this.key = key;
    }

}
