package com.tlabs.eve.zkb;

public final class ZKillCorporationLogRequest extends ZKillRequest<ZKillCorporationLogResponse> {

    public ZKillCorporationLogRequest(final long corporationID) {
        super(ZKillCorporationLogResponse.class, "corporationID" + "/" + corporationID + "/");
    }
}
