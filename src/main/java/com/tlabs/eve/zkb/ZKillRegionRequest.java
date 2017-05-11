package com.tlabs.eve.zkb;

public final class ZKillRegionRequest extends ZKillRequest<ZKillResponse> {

    public ZKillRegionRequest(final long regionID) {
        super(ZKillResponse.class, "regionID/" + regionID + "/no-items/no-attackers/");
    }
}
