package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

public final class ESICharacterMailContentResponse extends ESICharacterResponse {

    private ESIMail mail;

    public ESICharacterMailContentResponse() {
        setCachedUntil(System.currentTimeMillis() + 30L * 1000L);
    }

    public ESIMail getMail() {
        return mail;
    }

    public void setMail(ESIMail mail) {
        this.mail = mail;
    }
}
