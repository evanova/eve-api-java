package com.tlabs.eve.zkb;

public final class ZKillCharacterRequest extends ZKillRequest<ZKillResponse> {

    public ZKillCharacterRequest(final long characterID) {
        super(ZKillResponse.class, "characterID" + "/" + characterID + "/");
    }
}
