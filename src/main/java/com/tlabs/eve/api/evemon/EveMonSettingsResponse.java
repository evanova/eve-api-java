package com.tlabs.eve.api.evemon;

import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.EveResponse;
import com.tlabs.eve.api.AccessInfo;

public class EveMonSettingsResponse extends EveResponse {

    private static final long serialVersionUID = -3321752925913502110L;

    private final List<AccessInfo> accessInfo;

    public EveMonSettingsResponse() {
        super();
        this.accessInfo = new ArrayList<>();
    }

    public final List<AccessInfo> getApiKeys() {
        return this.accessInfo;
    }

    public final void addApiKey(final AccessInfo accessInfo) {
        this.accessInfo.add(accessInfo);
    }
}
