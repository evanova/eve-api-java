package com.tlabs.eve.esi.character;

public final class ESICharacterInfoRequest extends ESICharacterRequest<ESICharacterInfoResponse> {

    public ESICharacterInfoRequest(
            final long charID) {super(ESICharacterInfoResponse.class, charID);
    }
}
