package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class CharacterCalendarAttendeesResponse extends EveAPIResponse {

    private static final long serialVersionUID = 295878771001782025L;

    private final List<CharacterCalendar.Attendee> attendees = new LinkedList<>();

    public List<CharacterCalendar.Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(final CharacterCalendar.Attendee attendee) {
        this.attendees.add(attendee);
    }
}
