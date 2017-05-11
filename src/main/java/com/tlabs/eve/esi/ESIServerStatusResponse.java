package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIServerStatus;

public class ESIServerStatusResponse extends ESIResponse {

    private ESIServerStatus status;

    public ESIServerStatus getStatus() {
        return status;
    }

    public void setStatus(ESIServerStatus status) {
        this.status = status;
    }
}
