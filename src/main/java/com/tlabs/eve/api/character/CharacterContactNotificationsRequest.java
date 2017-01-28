package com.tlabs.eve.api.character;

import com.tlabs.eve.api.mail.ContactNotificationsResponse;

public final class CharacterContactNotificationsRequest extends CharacterRequest<ContactNotificationsResponse> {
    public static final long MASK = 16;

    public CharacterContactNotificationsRequest(final long characterID) {
        super(ContactNotificationsResponse.class, "/char/ContactNotifications.xml.aspx", MASK, characterID);
    }
}
