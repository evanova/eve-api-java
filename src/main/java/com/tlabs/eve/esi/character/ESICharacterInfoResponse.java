package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESICharacter;

public final class ESICharacterInfoResponse extends ESICharacterResponse {

    private ESICharacter character;

    public ESICharacterInfoResponse() {
        setCachedUntil(EveTime.now() + 3600L * 1000L);
    }

    public ESICharacter getCharacter() {
        return character;
    }

    public void setCharacter(ESICharacter character) {
        this.character = character;
    }
}
