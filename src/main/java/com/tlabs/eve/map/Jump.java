package com.tlabs.eve.map;

import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

public class Jump implements Serializable {

    private static final long serialVersionUID = 6189755970305582113L;

    private final SolarSystem from;
    private final SolarSystem to;

    public Jump(final SolarSystem from, final SolarSystem to) {
        this.from = from;
        this.to = to;
    }

    public final SolarSystem getFrom() {
        return from;
    }

    public final SolarSystem getTo() {
        return to;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Jump)) {
            return false;
        }
        final Jump j = (Jump) obj;
        return (this.from.getSolarSystemID() == j.from.getSolarSystemID()) && (this.to.getSolarSystemID() == j.to.getSolarSystemID());
    }
}
