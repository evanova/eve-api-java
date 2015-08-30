package com.tlabs.eve.fitting;

import com.tlabs.eve.EveResponse;

import java.util.LinkedList;
import java.util.List;

public class ShipFittingResponse extends EveResponse {

    private final List<Fitting> fittings;
    
    public ShipFittingResponse() {
        this.fittings = new LinkedList<>();
    }

    public void addShipFitting(final Fitting fit) {
        this.fittings.add(fit);
    }
    
    public List<Fitting> getFittings() {
        return this.fittings;
    }
}
