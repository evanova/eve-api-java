package com.tlabs.eve.api.character;

import java.util.LinkedList;
import java.util.List;

import com.tlabs.eve.api.EveAPIResponse;

public class PlanetaryRoutesResponse extends EveAPIResponse {

    private static final long serialVersionUID = -9090915969564594981L;

    private final List<PlanetaryRoute> routes;

    public PlanetaryRoutesResponse() {
        this.routes = new LinkedList<PlanetaryRoute>();
    }

    public void addRoute(final PlanetaryRoute route) {
        this.routes.add(route);
    }
}
