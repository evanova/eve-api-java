package com.tlabs.eve.esi;

public class ESIStatusRequest extends ESIPublicRequest<ESIStatusResponse> {

    public ESIStatusRequest() {
        super(ESIStatusResponse.class);
    }
}
