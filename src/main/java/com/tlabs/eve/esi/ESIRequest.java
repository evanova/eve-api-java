package com.tlabs.eve.esi;

import com.tlabs.eve.EveRequest;

public abstract class ESIRequest<T extends ESIResponse> extends EveRequest<T> {


    public ESIRequest(Class<T> responseClass) {
        super(responseClass, responseClass.getSimpleName());
    }

    public final String getRefreshToken() {
        return getParam("refreshToken");
    }

    public final void setRefreshToken(final String refreshToken) {
        putParam("refreshToken", refreshToken);
    }


}
