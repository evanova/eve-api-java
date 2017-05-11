package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIMail;

public final class ESICharacterMailUpdateRequest extends ESICharacterRequest<ESICharacterMailUpdateResponse> {

    private final ESIMail mail;

    public ESICharacterMailUpdateRequest(final long charID, final ESIMail mail) {
        super(
                ESICharacterMailUpdateResponse.class,
                charID,
                "/mail/{mailID}/",
                "esi-mail.organize_mail.v1");
        putParam("mailID", mail.getId());
        this.mail = mail;
    }

    public ESIMail getMail() {
        return mail;
    }
}
