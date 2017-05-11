package com.tlabs.eve.esi.character;

public final class ESICharacterMailHeadersRequest extends ESICharacterRequest<ESICharacterMailHeadersResponse> {

    public ESICharacterMailHeadersRequest(final long charID) {
        this(charID, -1);
    }

    public ESICharacterMailHeadersRequest(final long charID, final long lastMailID) {
        super(
                ESICharacterMailHeadersResponse.class,
                charID,
                "/mail/",
                "esi-mail.read_mail.v1");
        if (lastMailID > 0) {
            putParam("last_mail_id", lastMailID);
        }
    }

    public Long getLastMailID() {
        return getLong("last_mail_id");
    }
}
