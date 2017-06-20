package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

public final class ESICharacterMailPostResponse extends ESICharacterResponse {

    private ESIMail mail;

    public ESIMail getMail() {
        return mail;
    }

    public void setMail(final ESIMail mail) {
        this.mail = mail;
    }

}
