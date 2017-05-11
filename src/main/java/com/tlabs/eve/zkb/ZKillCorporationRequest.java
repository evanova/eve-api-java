package com.tlabs.eve.zkb;

public final class ZKillCorporationRequest extends ZKillRequest<ZKillResponse> {

    public ZKillCorporationRequest(final long corporationID) {
        super(ZKillResponse.class, "corporationID" + "/" + corporationID + "/");
    }
}
