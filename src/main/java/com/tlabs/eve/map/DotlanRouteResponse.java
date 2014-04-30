package com.tlabs.eve.map;

import com.tlabs.eve.EveResponse;

public class DotlanRouteResponse extends EveResponse {

	private static final long serialVersionUID = -1061664072155886443L;

	private Route route = null;

	public Route getRoute() {
		return route;
	}

	void setRoute(Route route) {
		this.route = route;
	}
}
