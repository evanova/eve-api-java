package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.api.EveAPIRequest.Authenticated;
import com.tlabs.eve.api.EveAPIResponse;

public abstract class CorporationRequest<T extends EveAPIResponse> extends EveAPIRequest<T> implements Authenticated {

    private String keyID = null;
    private String key = null;

    private long corporationID;

    public CorporationRequest(Class<T> tea, String page, long mask, long corporationID) {
        super(tea, page, mask);
        putParam("corporationID", corporationID);
        this.corporationID = corporationID;
    }

    public final long getCorporationID() {
        return corporationID;
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
