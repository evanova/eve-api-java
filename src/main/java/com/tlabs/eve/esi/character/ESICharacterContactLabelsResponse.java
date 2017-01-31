package com.tlabs.eve.esi.character;

public final class ESICharacterContactLabelsResponse extends ESICharacterResponse {

    public ESICharacterContactLabelsResponse() {
        setCachedUntil(System.currentTimeMillis() + 300L * 1000L);
    }

}
