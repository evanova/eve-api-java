package com.tlabs.eve.esi;

import java.util.List;

public final class ESINameRequest extends ESIRequest<ESINameResponse> implements ESIRequest.Public {

    private final List<Integer> ids;


    public ESINameRequest(final List<Integer> ids) {
        super(ESINameResponse.class);
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

}
