package com.tlabs.eve.dotlan.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Deprecated //use ESI
public class DotlanRoute {

    private final List<DotlanJump> jumps;

    public DotlanRoute() {
        this(new ArrayList<DotlanSolarSystem>(0));
    }

    public DotlanRoute(final List<DotlanSolarSystem> route) {
        this.jumps = new ArrayList<>();

        DotlanSolarSystem previous = null;
        for (DotlanSolarSystem s: route) {
            if (null == previous) {
                previous = s;
                continue;
            }
            if (StringUtils.isBlank(s.getRegionName())) {
                s.setRegionName(previous.getRegionName());
            }
            if (StringUtils.isBlank(s.getHolderName())) {
                s.setHolderName(previous.getHolderName());
            }
            this.jumps.add(new DotlanJump(previous, s));
            previous = s;
        }
    }

    public final List<DotlanJump> getRoute() {
        return Collections.unmodifiableList(jumps);
    }

    public final int size() {
        return jumps.size();
    }

    public final DotlanSolarSystem getFrom() {

        return (this.jumps.isEmpty()) ? null : this.jumps.get(0).getFrom();
    }

    public final DotlanSolarSystem getTo() {
        return (this.jumps.isEmpty()) ? null : this.jumps.get(this.jumps.size() - 1).getTo();
    }
}
