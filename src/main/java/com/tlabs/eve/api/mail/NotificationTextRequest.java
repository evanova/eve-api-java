package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.character.CharacterRequest;

public final class NotificationTextRequest extends CharacterRequest<NotificationTextResponse> {
    public static final int MASK = 32768;

    public NotificationTextRequest(String characterID, long[] ids) {
        super(NotificationTextResponse.class, "/char/NotificationTexts.xml.aspx", MASK, characterID);
        putParam("ids", ids);
    }
}
