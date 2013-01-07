package com.tlabs.eve.api;

import java.util.LinkedList;
import java.util.List;

public class ServerStationsResponse extends EveResponse {

    private List<EveStation> stations = new LinkedList<EveStation>();
    
    public void addStation(final EveStation station) {
        this.stations.add(station);
    }

    public List<EveStation> getStations() {
        return stations;
    }
}
