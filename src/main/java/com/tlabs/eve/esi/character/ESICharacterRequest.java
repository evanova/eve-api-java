package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.ESIRequest;

public abstract class ESICharacterRequest<T extends ESICharacterResponse> extends ESIRequest<T> implements ESIRequest.Authenticated {

    public ESICharacterRequest(
            final Class<T> tClass,
            final long charID,
            final String path,
            final String scope) {
        super(tClass, "/characters/{charID}" + path, scope);
        putParam("charID", charID);
    }

    public final Long getCharacterID() {
        return getLong("charID");
    }
}
