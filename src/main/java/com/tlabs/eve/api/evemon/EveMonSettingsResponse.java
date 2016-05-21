package com.tlabs.eve.api.evemon;

import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.EveResponse;

public class EveMonSettingsResponse extends EveResponse {

    private static final long serialVersionUID = -3321752925913502110L;

    private final List<EveMonAccount> accessInfo;

    public EveMonSettingsResponse() {
        super();
        this.accessInfo = new ArrayList<>();
    }

    public final List<EveMonAccount> getApiKeys() {
        return this.accessInfo;
    }

    public final void addApiKey(final EveMonAccount accessInfo) {
        this.accessInfo.add(accessInfo);
    }
}
