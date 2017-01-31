package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.ESIRequest;

abstract class ESICharacterRequest<T extends ESICharacterResponse> extends ESIRequest<T> {

    public ESICharacterRequest(final Class<T> tClass, final long charID, final String path) {
        super(tClass, "/characters/{charID}" + path);
        putParam("charID", charID);
    }

    public final Long getCharacterID() {
        return getLong("charID");
    }
}
