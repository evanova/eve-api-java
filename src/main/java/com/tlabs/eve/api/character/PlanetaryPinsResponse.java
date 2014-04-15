package com.tlabs.eve.api.character;

import java.util.LinkedList;
import java.util.List;

import com.tlabs.eve.api.EveAPIResponse;

public class PlanetaryPinsResponse extends EveAPIResponse {

	private static final long serialVersionUID = -4950190993664796945L;

	private final List<PlanetaryPin> pins;
	
	public PlanetaryPinsResponse() {
		this.pins = new LinkedList<PlanetaryPin>();
	}
	
	public void addPin(final PlanetaryPin pin) {
		this.pins.add(pin);
	}
}
