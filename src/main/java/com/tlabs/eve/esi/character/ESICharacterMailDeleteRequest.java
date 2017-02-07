package com.tlabs.eve.esi.character;

public final class ESICharacterMailDeleteRequest extends ESICharacterRequest<ESICharacterMailDeleteResponse> {

    public ESICharacterMailDeleteRequest(final long charID, final Long mailID) {
        super(ESICharacterMailDeleteResponse.class, charID, "/mail/{mailID}/");
        putParam("mailID", mailID);
    }

    public Long getMailID() {
        return getLong("mailID");
    }
}