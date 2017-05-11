package com.tlabs.eve.esi;

import java.util.List;

public final class ESINameRequest extends ESIRequest<ESINameResponse> {

    private final List<Long> ids;

    public ESINameRequest(final List<Long> ids) {
        super(ESINameResponse.class, "/universe/names", "publicData");
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }
}
