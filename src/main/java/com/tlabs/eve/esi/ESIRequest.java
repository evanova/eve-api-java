package com.tlabs.eve.esi;

import com.tlabs.eve.EveRequest;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

public abstract class ESIRequest<T extends ESIResponse> extends EveRequest<T> {

    private final String scope;

    public ESIRequest(Class<T> responseClass, String page, String scope) {
        super(responseClass, page);
        this.scope = scope;
    }

    public final String getRefreshToken() {
        return getParam("refreshToken");
    }

    public final void setRefreshToken(final String refreshToken) {
        putParam("refreshToken", refreshToken);
    }

    public final String getScope() {
        return scope;
    }

    public final boolean inScope(final String... scopes) {
        return inScope(Arrays.asList(scopes));
    }

    public final boolean inScope(final List<String> scopes) {
        if (CollectionUtils.isEmpty(scopes)) {
            return (null == this.scope);
        }
        if (null == this.scope) {
            return true;
        }
        return scopes.contains(this.scope);
    }
}
