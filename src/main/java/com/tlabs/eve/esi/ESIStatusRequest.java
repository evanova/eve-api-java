package com.tlabs.eve.esi;

public class ESIStatusRequest extends ESIRequest<ESIStatusResponse> implements ESIRequest.Public {

    public ESIStatusRequest() {
        super(ESIStatusResponse.class, "publicData");
    }
}
