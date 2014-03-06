package com.tlabs.eve.fitting;

import java.util.LinkedList;
import java.util.List;

import com.tlabs.eve.EveResponse;

public class EveFittingResponse extends EveResponse {

    private final List<ShipFitting> shipFittings;
    
    public EveFittingResponse() {
        this.shipFittings = new LinkedList<ShipFitting>();
    }


    public void addShipFitting(final ShipFitting fit) {
        this.shipFittings.add(fit);
    }
    
    public List<ShipFitting> getShipFittings() {
        return this.shipFittings;
    }
}
