package com.tlabs.eve.esi;

public abstract class ESIPublicRequest<T extends ESIResponse> extends ESIRequest<T> {

    public ESIPublicRequest(Class<T> rClass) {
        super(rClass, "publicData");
    }
}
