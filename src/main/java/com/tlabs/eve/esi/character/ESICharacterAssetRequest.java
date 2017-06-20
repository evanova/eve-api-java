package com.tlabs.eve.esi.character;

public final class ESICharacterAssetRequest extends ESICharacterRequest<ESICharacterAssetResponse> {

    public static final String SCOPE = "esi-assets.read_assets.v1";

    public ESICharacterAssetRequest(final long charID) {
        super(ESICharacterAssetResponse.class, charID, SCOPE);
    }
}
