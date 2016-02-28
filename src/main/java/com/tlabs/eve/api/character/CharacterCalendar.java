package com.tlabs.eve.api.character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import com.tlabs.eve.api.EveAPI;

public class CharacterCalendar implements Serializable {
    private static final long serialVersionUID = -1558742167364668064L;

    public enum OwnerType {
        CHARACTER(0),
        CCP(1),
        CORPORATION(2),
        ALLIANCE(16159);

        private final long value;

        OwnerType(final long value) {
            this.value = value;
        }

        public static OwnerType from(long value) {
            for (OwnerType t : EnumSet.allOf(OwnerType.class)) {
                if (t.value == value) {
                    return t;
                }
            }
            return CHARACTER;
        }
    }

    public enum ResponseType {
        ACCEPTED("Accepted"),
        DECLINED("Declined"),
        UNDECIDED("Undecided"),
        TENTATIVE("Tentative");

        private final String value;

        ResponseType(final String value) {
            this.value = value;
        }

        public static ResponseType from(String value) {
            for (ResponseType t : EnumSet.allOf(ResponseType.class)) {
                if (t.value.equalsIgnoreCase(value)) {
                    return t;
                }
            }
            return UNDECIDED;
        }
    }

    public static final class Entry implements Serializable {

        private static final long serialVersionUID = -2568742167364516064L;

        private long eventID;
        private String eventTitle;
        private String eventText;

        private long ownerID;
        private String ownerName;
        private int ownerTypeID;

        private long eventDate;
        private long duration;//in minutes so far - this should be fixed to ms

        private boolean important = false;
        private String response;

        private List<Attendee> attendees = new ArrayList<>();

        public long getEventID() {
            return eventID;
        }

        public void setEventID(long eventID) {
            this.eventID = eventID;
        }

        public String getEventTitle() {
            return eventTitle;
        }

        public void setEventTitle(String eventTitle) {
            this.eventTitle = eventTitle;
        }

        public String getEventText() {
            return eventText;
        }

        public void setEventText(String eventText) {
            this.eventText = eventText;
        }

        public long getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(long ownerID) {
            this.ownerID = ownerID;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public long getEventDate() {
            return eventDate;
        }

        public void setEventDate(long eventDate) {
            this.eventDate = eventDate;
        }

        public void setEventDate(String eventDate) {
            this.eventDate = EveAPI.parseDateTime(eventDate);
        }

        public long getDurationInMillis() {
            return duration * 60000l;
        }

        //in minutes
        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public boolean getImportant() {
            return important;
        }

        public void setImportant(boolean important) {
            this.important = important;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public List<Attendee> getAttendees() {
            return attendees;
        }

        public void setAttendees(List<Attendee> attendees) {
            this.attendees = attendees;
        }

        public int getOwnerTypeID() {
            return ownerTypeID;
        }

        public void setOwnerTypeID(int ownerTypeID) {
            this.ownerTypeID = ownerTypeID;
        }

        public OwnerType getOwnerType() {
            return OwnerType.from(this.ownerTypeID);
        }

        public ResponseType getResponseType() {
            return ResponseType.from(this.response);
        }
    }

    public static final class Attendee implements Serializable {
        private static final long serialVersionUID = -3565742168364506067L;

        private long characterID;
        private String characterName;
        private String response;

        public long getCharacterID() {
            return characterID;
        }

        public void setCharacterID(long characterID) {
            this.characterID = characterID;
        }

        public String getCharacterName() {
            return characterName;
        }

        public void setCharacterName(String characterName) {
            this.characterName = characterName;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }

        public ResponseType getResponseType() {
            return ResponseType.from(this.response);
        }
    }

    private final List<CharacterCalendar.Entry> entries = new ArrayList<>();

    public List<CharacterCalendar.Entry> getEntries() {
        return this.entries;
    }

    public void addEntry(final CharacterCalendar.Entry entry) {
        this.entries.add(entry);
    }
}
