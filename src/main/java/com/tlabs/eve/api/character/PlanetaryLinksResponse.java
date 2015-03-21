package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class PlanetaryLinksResponse extends EveAPIResponse {

    private static final long serialVersionUID = 8884162940112997405L;

    private final List<PlanetaryLink> links;

    public PlanetaryLinksResponse() {
        this.links = new LinkedList<>();
    }

    public void addLink(final PlanetaryLink link) {
        this.links.add(link);
    }
}
