package com.tlabs.eve.api;

import com.tlabs.eve.api.EveAPIRequest.Public;

public final class SovereigntyRequest extends EveAPIRequest<SovereigntyResponse> implements Public {

    public SovereigntyRequest() {
        super(SovereigntyResponse.class, "/map/Sovereignty.xml.aspx", 0);
    }

}
