package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

public final class ESICharacterMailPostResponse extends ESICharacterResponse {

    private ESIMail mail;

    public ESICharacterMailPostResponse() {
        setCachedUntil(System.currentTimeMillis() + 30L * 1000L);
    }

    public ESIMail getMail() {
        return mail;
    }

    public void setMail(final ESIMail mail) {
        this.mail = mail;
    }

}
