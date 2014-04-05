package com.tlabs.eve.map;
import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;


public class Jump extends Object implements Serializable {
    
    private static final long serialVersionUID = 6189755970305582113L;
    
    private final SolarSystem from;
    private final SolarSystem to;
    
    private double weight;
    
    public Jump(final SolarSystem from, final SolarSystem to) {
        this.from = from;
        this.to = to;
    }

   // @Override
    public final double getWeight() {
        return weight;
    }

    public final void setWeight(double weight) {
        this.weight = weight;
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
        final Jump j = (Jump)obj;
        return (this.from.getSolarSystemID() == j.from.getSolarSystemID()) && (this.to.getSolarSystemID() == j.to.getSolarSystemID());
    }    
}
