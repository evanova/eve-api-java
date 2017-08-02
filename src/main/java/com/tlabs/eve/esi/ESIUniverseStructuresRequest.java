package com.tlabs.eve.esi;

public final class ESIUniverseStructuresRequest extends ESIRequest<ESIUniverseStructuresResponse> implements ESIRequest.Public {
    public ESIUniverseStructuresRequest() {
        super(ESIUniverseStructuresResponse.class, "publicData");
    }
}
