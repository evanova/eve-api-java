package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIToken;

public interface ESIStore {

    void save(final ESIToken token);

    void delete(final String refresh);

    ESIToken get(final String refresh);

}
