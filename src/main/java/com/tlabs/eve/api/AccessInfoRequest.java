package com.tlabs.eve.api;



import com.tlabs.eve.api.EveAPIRequest.Authenticated;

/** @since Eve API V2 (30 Aug 2011*/
public final class AccessInfoRequest extends EveAPIRequest<AccessInfoResponse> implements Authenticated {

    private String keyID;
    private String key;

    public AccessInfoRequest(String keyID, String key) {
        super(AccessInfoResponse.class, "/account/APIKeyInfo.xml.aspx", 0);

        this.keyID = keyID;
        putParam("keyID", keyID);

        this.key = key;
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
