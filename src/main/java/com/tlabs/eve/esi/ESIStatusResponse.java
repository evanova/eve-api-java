package com.tlabs.eve.esi;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESIServerStatus;

public class ESIStatusResponse extends ESIResponse {

    private ESIServerStatus status;

    public ESIStatusResponse() {
        setCachedUntil(EveTime.now() + 30 * 1000);
    }

    public ESIServerStatus getStatus() {
        return status;
    }

    public void setStatus(ESIServerStatus status) {
        this.status = status;
    }
}
