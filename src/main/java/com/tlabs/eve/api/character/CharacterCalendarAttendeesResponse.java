package com.tlabs.eve.api.character;

import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.api.EveAPIResponse;

public class CharacterCalendarAttendeesResponse extends EveAPIResponse {

    private static final long serialVersionUID = 295878771001782025L;

    private final List<CharacterCalendar.Attendee> attendees = new ArrayList<>();

    public List<CharacterCalendar.Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(final CharacterCalendar.Attendee attendee) {
        this.attendees.add(attendee);
    }
}
