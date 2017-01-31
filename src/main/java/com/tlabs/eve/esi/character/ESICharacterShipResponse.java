package com.tlabs.eve.esi.character;

import com.tlabs.eve.esi.model.ESIShip;

public final class ESICharacterShipResponse extends ESICharacterResponse {

    private ESIShip ship;

    public ESICharacterShipResponse() {
        setCachedUntil(System.currentTimeMillis() + 5L * 1000L);
    }

    public ESIShip getShip() {
        return ship;
    }

    public void setShip(ESIShip ship) {
        this.ship = ship;
    }
}
