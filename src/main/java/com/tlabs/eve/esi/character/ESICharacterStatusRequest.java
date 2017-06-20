package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.ESIRequest;

public final class ESICharacterStatusRequest extends ESICharacterRequest<ESICharacterStatusResponse> implements ESIRequest.Authenticated {

    private String refreshToken;

    public ESICharacterStatusRequest(final String refreshToken) {
        super(ESICharacterStatusResponse.class, -1, "publicData");
        this.refreshToken = refreshToken;
    }
}
