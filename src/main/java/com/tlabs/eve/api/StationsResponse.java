package com.tlabs.eve.api;

import java.util.LinkedList;
import java.util.List;

public class StationsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -5156850963016181222L;

    private List<Station> stations = new LinkedList<>();

    public void addStation(final Station station) {
        this.stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }
}
