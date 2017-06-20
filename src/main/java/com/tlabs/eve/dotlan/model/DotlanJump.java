package com.tlabs.eve.dotlan.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Deprecated //use ESI
public class DotlanJump {

    private final DotlanSolarSystem from;
    private final DotlanSolarSystem to;

    public DotlanJump(final DotlanSolarSystem from, final DotlanSolarSystem to) {
        this.from = from;
        this.to = to;
    }

    public final DotlanSolarSystem getFrom() {
        return from;
    }

    public final DotlanSolarSystem getTo() {
        return to;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DotlanJump)) {
            return false;
        }
        final DotlanJump j = (DotlanJump) obj;
        return (this.from.getSolarSystemID() == j.from.getSolarSystemID()) && (this.to.getSolarSystemID() == j.to.getSolarSystemID());
    }

    public long getRequiredFuel() {
        return this.from.getFuelToNext();
    }

    public float getDistance() {
        return this.from.getDistanceToNext();
    }
}
