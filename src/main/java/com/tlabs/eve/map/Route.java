package com.tlabs.eve.map;

import java.io.Serializable;
import java.util.List;

public class Route extends Object implements Serializable {

	private static final long serialVersionUID = -1410498800558095313L;

	private final List<SolarSystem> jumps;
	
	protected Route(final List<SolarSystem> route) {		
		this.jumps = route;				
	}

	public final List<SolarSystem> getRoute() {
		return jumps;
	}

	public final int size() {
		return jumps.size();
	}
	
	public final SolarSystem getFrom() {
		return (this.jumps.size() == 0) ? null : this.jumps.get(0);
	}

	public final SolarSystem getTo() {
		return (this.jumps.size() == 0) ? null : this.jumps.get(this.jumps.size() - 1);
	}		
}
