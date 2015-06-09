package com.tlabs.eve.zkb;

public final class ZKillCharacterLogRequest extends ZKillRequest<ZKillCharacterLogResponse> {

    public ZKillCharacterLogRequest(final long characterID) {
        super(ZKillCharacterLogResponse.class, "characterID" + "/" + characterID + "/");
    }
}
