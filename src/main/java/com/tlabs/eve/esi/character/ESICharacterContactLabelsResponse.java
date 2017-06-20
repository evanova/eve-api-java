package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;

public final class ESICharacterContactLabelsResponse extends ESICharacterResponse {

    public ESICharacterContactLabelsResponse() {
        setCachedUntil(EveTime.now() + 300L * 1000L);
    }

}
