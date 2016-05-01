package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.character.CharacterRequest;

///char/MailMessages.xml.aspx
public final class NotificationsRequest extends CharacterRequest<NotificationsResponse> {
    public static final long MASK = 16384;

    public NotificationsRequest(String characterID) {
        super(NotificationsResponse.class, "/char/Notifications.xml.aspx", MASK, characterID);
    }

}
