package com.tlabs.eve.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route implements Serializable {

    private static final long serialVersionUID = -1410498800558095313L;

    private final List<SolarSystem> jumps;

    public Route() {
        this(new ArrayList<SolarSystem>(0));
    }

    public Route(final List<SolarSystem> route) {
        this.jumps = route;
    }

    public final List<SolarSystem> getRoute() {
        return Collections.unmodifiableList(jumps);
    }

    public final int size() {
        return jumps.size();
    }

    public final SolarSystem getFrom() {
        return (this.jumps.isEmpty()) ? null : this.jumps.get(0);
    }

    public final SolarSystem getTo() {
        return (this.jumps.isEmpty()) ? null : this.jumps.get(this.jumps.size() - 1);
    }
}
