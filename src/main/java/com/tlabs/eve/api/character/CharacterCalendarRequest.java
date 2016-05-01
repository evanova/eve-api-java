package com.tlabs.eve.api.character;


public final class CharacterCalendarRequest extends CharacterRequest<CharacterCalendarResponse> {

    public static final long MASK = 1048576;

    public CharacterCalendarRequest(String characterID) {
        super(CharacterCalendarResponse.class, "/char/UpcomingCalendarEvents.xml.aspx", MASK, characterID);
    }

}
