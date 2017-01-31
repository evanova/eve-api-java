package com.tlabs.eve.esi.character;

public final class ESICharacterMailUpdateResponse extends ESICharacterResponse {


    public ESICharacterMailUpdateResponse() {
        setCachedUntil(System.currentTimeMillis() + 30L * 1000L);
    }

}
