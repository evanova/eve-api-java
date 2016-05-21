package com.tlabs.eve.api.corporation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.api.EveAPIRequest.Authenticated;
import com.tlabs.eve.api.EveAPIResponse;

public abstract class CorporationRequest<T extends EveAPIResponse> extends EveAPIRequest<T> implements Authenticated {

    private String keyID = null;
    private String key = null;

    private String corporationID;

    public CorporationRequest(Class<T> tea, String page, long mask, String corporationID) {
        super(tea, page, mask);

        Validate.isTrue(StringUtils.isNotBlank(corporationID), "corporationID");

        putParam("corporationID", corporationID);
        this.corporationID = corporationID;
    }

    public final String getCorporationID() {
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
