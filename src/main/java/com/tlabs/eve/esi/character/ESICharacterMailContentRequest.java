package com.tlabs.eve.esi.character;

public final class ESICharacterMailContentRequest extends ESICharacterRequest<ESICharacterMailContentResponse> {

    public ESICharacterMailContentRequest(final long charID, final Long mailID) {
        super(ESICharacterMailContentResponse.class, charID);
        putParam("mailID", mailID);
    }

    public Long getMailID() {
        return getLong("mailID");
    }
}
