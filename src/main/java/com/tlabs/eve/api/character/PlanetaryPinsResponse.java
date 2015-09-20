package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class PlanetaryPinsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -4950190993664796945L;

    private final List<PlanetaryPin> pins;

    public PlanetaryPinsResponse() {
        this.pins = new LinkedList<>();
    }

    public List<PlanetaryPin> getPins() {
        return pins;
    }

    public void addPin(final PlanetaryPin pin) {
        this.pins.add(pin);
    }
}
