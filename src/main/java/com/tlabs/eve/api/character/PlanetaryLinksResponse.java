package com.tlabs.eve.api.character;

import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.api.EveAPIResponse;

public class PlanetaryLinksResponse extends EveAPIResponse {

    private static final long serialVersionUID = 8884162940112997405L;

    private final List<PlanetaryLink> links;

    public PlanetaryLinksResponse() {
        this.links = new ArrayList<>();
    }

    public void addLink(final PlanetaryLink link) {
        this.links.add(link);
    }

    public List<PlanetaryLink> getLinks() {
        return links;
    }
}
