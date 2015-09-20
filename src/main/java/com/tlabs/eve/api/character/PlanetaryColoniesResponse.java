package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class PlanetaryColoniesResponse extends EveAPIResponse {

    private static final long serialVersionUID = 2711166571030192025L;

    private final List<PlanetaryColony> colonies;

    public PlanetaryColoniesResponse() {
        this.colonies = new LinkedList<>();
    }

    public List<PlanetaryColony> getColonies() {
        return colonies;
    }

    public void addColony(final PlanetaryColony colony) {
        this.colonies.add(colony);
    }
}
