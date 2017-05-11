package com.tlabs.eve.api;

public final class SovereigntyRequest extends EveAPIRequest<SovereigntyResponse> {

    public SovereigntyRequest() {
        super(SovereigntyResponse.class, "/map/Sovereignty.xml.aspx", 0);
    }

}
