package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

import java.util.List;

public final class ESICharacterMailHeadersResponse extends ESICharacterResponse {

    private List<ESIMail> mails;

    public ESICharacterMailHeadersResponse() {
        setCachedUntil(System.currentTimeMillis() + 30L * 1000L);
    }

    public List<ESIMail> getMails() {
        return mails;
    }

    public void setMails(List<ESIMail> mails) {
        this.mails = mails;
    }
}
