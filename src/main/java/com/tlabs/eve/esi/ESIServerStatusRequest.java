package com.tlabs.eve.esi;

public class ESIServerStatusRequest extends ESIRequest<ESIServerStatusResponse> {

    public ESIServerStatusRequest() {
        super(ESIServerStatusResponse.class, "/status/", "publicData");
    }
}
