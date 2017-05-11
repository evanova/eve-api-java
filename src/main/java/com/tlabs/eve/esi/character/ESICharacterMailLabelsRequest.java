package com.tlabs.eve.esi.character;

public final class ESICharacterMailLabelsRequest extends ESICharacterRequest<ESICharacterMailLabelsResponse> {

    public ESICharacterMailLabelsRequest(final long charID) {
        super(
                ESICharacterMailLabelsResponse.class,
                charID,
                "/mail/labels/",
                "esi-mail.read_mail.v1");
    }
}
