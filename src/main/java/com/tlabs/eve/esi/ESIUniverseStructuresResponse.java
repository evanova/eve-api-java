package com.tlabs.eve.esi;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESILocation;

import java.util.Calendar;
import java.util.Map;

public final class ESIUniverseStructuresResponse extends ESIResponse {

    private Map<Long, ESILocation.Structure> structures;

    public ESIUniverseStructuresResponse() {
        final Calendar calendar = EveTime.calendar();
        calendar.add(Calendar.HOUR, 24);
        setCachedUntil(calendar.getTimeInMillis());
    }

    public Map<Long, ESILocation.Structure> getStructures() {
        return structures;
    }

    public void setStructures(Map<Long, ESILocation.Structure> structures) {
        this.structures = structures;
    }
}
