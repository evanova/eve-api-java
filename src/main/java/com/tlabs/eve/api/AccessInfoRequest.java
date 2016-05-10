package com.tlabs.eve.api;



import com.tlabs.eve.api.EveAPIRequest.Authenticated;

/** @since Eve API V2 (30 Aug 2011*/
public final class AccessInfoRequest extends EveAPIRequest<AccessInfoResponse> implements Authenticated {

    public AccessInfoRequest() {
        super(AccessInfoResponse.class, "/account/APIKeyInfo.xml.aspx", 0);
    }

}
