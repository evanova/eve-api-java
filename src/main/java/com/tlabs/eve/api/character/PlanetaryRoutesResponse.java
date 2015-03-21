package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class PlanetaryRoutesResponse extends EveAPIResponse {

    private static final long serialVersionUID = -9090915969564594981L;

    private final List<PlanetaryRoute> routes;

    public PlanetaryRoutesResponse() {
        this.routes = new LinkedList<>();
    }

    public void addRoute(final PlanetaryRoute route) {
        this.routes.add(route);
    }
}
