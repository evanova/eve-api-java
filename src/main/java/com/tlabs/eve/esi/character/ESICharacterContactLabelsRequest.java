package com.tlabs.eve.esi.character;

public final class ESICharacterContactLabelsRequest extends ESICharacterRequest<ESICharacterContactLabelsResponse> {
    public ESICharacterContactLabelsRequest(final long charID) {
        super(ESICharacterContactLabelsResponse.class, charID);
    }
}
