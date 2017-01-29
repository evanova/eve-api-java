package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.List;

public class ESICalendar {
    public static class Event {

        public enum Response {
            ACCEPTED, DECLINED, TENTATIVE;
        }

        private final Long id;

        public Event(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }

    private final List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public ESICalendar add(final ESICalendar.Event event) {
        events.add(event);
        return this;
    }
}
