package com.tlabs.eve.esi.character;

public final class ESICharacterAssetRequest extends ESICharacterRequest<ESICharacterAssetResponse> {

    public ESICharacterAssetRequest(final long charID) {
        super(ESICharacterAssetResponse.class, charID);
    }
}
