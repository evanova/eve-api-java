package com.tlabs.eve.esi.character;

public final class ESICharacterLocationRequest extends ESICharacterRequest<ESICharacterLocationResponse> {

    public ESICharacterLocationRequest(final long charID) {
        super(ESICharacterLocationResponse.class, charID);
    }
}
