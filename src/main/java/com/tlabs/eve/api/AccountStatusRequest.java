package com.tlabs.eve.api;

import com.tlabs.eve.api.EveAPIRequest.Authenticated;


public final class AccountStatusRequest extends EveAPIRequest<AccountStatusResponse> implements Authenticated {
    public static final long MASK = 33554432;

    public AccountStatusRequest() {
        super(AccountStatusResponse.class, "/account/AccountStatus.xml.aspx", MASK);
    }

}
