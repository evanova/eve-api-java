package com.tlabs.eve.esi;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESILocation;

import java.util.Calendar;
import java.util.Map;

public final class ESIUniverseStatisticsResponse extends ESIResponse {

    private Map<Long, ESILocation.SolarSystem> statistics;

    public ESIUniverseStatisticsResponse() {
        final Calendar calendar = EveTime.calendar();
        calendar.add(Calendar.HOUR, 1);
        setCachedUntil(calendar.getTimeInMillis());
    }

    public Map<Long, ESILocation.SolarSystem> getStatistics() {
        return statistics;
    }

    public ESIUniverseStatisticsResponse setStatistics(Map<Long, ESILocation.SolarSystem> statistics) {
        this.statistics = statistics;
        return this;
    }
}
