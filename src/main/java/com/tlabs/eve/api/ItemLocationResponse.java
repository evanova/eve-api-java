package com.tlabs.eve.api;



import java.util.LinkedList;
import java.util.List;

public class ItemLocationResponse extends EveAPIResponse {

    private static final long serialVersionUID = -5989726486896932934L;

    private final List<ItemLocation> locations = new LinkedList<>();

    public void addLocation(final ItemLocation location) {
        this.locations.add(location);
    }

    public List<ItemLocation> getLocations() {
        return locations;
    }

}
