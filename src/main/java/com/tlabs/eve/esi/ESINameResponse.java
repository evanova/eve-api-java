package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIName;

import java.util.Collections;
import java.util.List;

public final class ESINameResponse extends ESIResponse {

    private List<ESIName> names = Collections.emptyList();

    public List<ESIName> getNames() {
        return names;
    }

    public void setNames(List<ESIName> names) {
        this.names = names;
    }
}
