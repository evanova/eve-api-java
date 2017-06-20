package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESICharacterStatus;

public final class ESICharacterStatusResponse extends ESICharacterResponse {

    private ESICharacterStatus status;

    public ESICharacterStatusResponse() {
        setCachedUntil(EveTime.now() + 3600L * 1000L);
    }

    public ESICharacterStatus getStatus() {
        return status;
    }

    public void setStatus(ESICharacterStatus status) {
        this.status = status;
    }
}
