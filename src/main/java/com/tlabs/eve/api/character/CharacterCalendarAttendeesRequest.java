package com.tlabs.eve.api.character;


public final class CharacterCalendarAttendeesRequest extends CharacterRequest<CharacterCalendarAttendeesResponse> {

    public static final long MASK = 4;

    public CharacterCalendarAttendeesRequest(String characterID, long... eventIds) {
        super(CharacterCalendarAttendeesResponse.class, "/char/CalendarEventAttendees.xml.aspx", MASK, characterID);
        putParam("eventIDs", eventIds);
    }
}
