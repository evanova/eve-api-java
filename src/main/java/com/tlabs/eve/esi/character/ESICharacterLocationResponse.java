package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESILocation;

public final class ESICharacterLocationResponse extends ESICharacterResponse {

    private ESILocation location;

    public ESICharacterLocationResponse() {
        setCachedUntil(System.currentTimeMillis() + 5L * 1000L);
    }

    public ESILocation getLocation() {
        return location;
    }

    public void setLocation(ESILocation location) {
        this.location = location;
    }
}
