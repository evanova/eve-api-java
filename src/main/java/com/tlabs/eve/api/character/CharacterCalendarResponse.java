package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

public class CharacterCalendarResponse extends EveAPIResponse {

    private static final long serialVersionUID = 285678571030192025L;

    private final CharacterCalendar calendar = new CharacterCalendar();

    public CharacterCalendar getCalendar() {
        return calendar;
    }

    public void addEntry(final CharacterCalendar.Entry entry) {
        this.calendar.addEntry(entry);
    }
}
