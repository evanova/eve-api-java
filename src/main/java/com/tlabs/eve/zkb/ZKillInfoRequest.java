package com.tlabs.eve.zkb;

public final class ZKillInfoRequest extends ZKillRequest<ZKillInfoResponse> {
    public ZKillInfoRequest(final long zKillID) {
        super(ZKillInfoResponse.class, "killID" + "/" + zKillID + "/");
        withItems(true);
        withAttackers(true);
        removeParam("limit");
        removeParam("page");
    }
}
