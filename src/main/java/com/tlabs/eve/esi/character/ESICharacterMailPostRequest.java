package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

public final class ESICharacterMailPostRequest extends ESICharacterRequest<ESICharacterMailPostResponse> {

    private final ESIMail mail;

    public ESICharacterMailPostRequest(final long charID, final ESIMail mail) {
        super(ESICharacterMailPostResponse.class, charID);
        this.mail = mail;
    }

    public ESIMail getMail() {
        return mail;
    }
}
