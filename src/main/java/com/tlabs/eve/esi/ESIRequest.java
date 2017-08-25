package com.tlabs.eve.esi;

import com.tlabs.eve.EveRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

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
