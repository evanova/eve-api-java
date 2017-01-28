package com.tlabs.eve.api.character;

import com.tlabs.eve.api.mail.ContactListResponse;

public final class CharacterContactListRequest extends CharacterRequest<ContactListResponse> {
    public static final long MASK = 16;

    public CharacterContactListRequest(final long characterID) {
        super(ContactListResponse.class, "/char/ContactList.xml.aspx", MASK, characterID);
    }
}
