package com.tlabs.eve.esi.model;

public class ESIShip {

    private String shipName;
    private long shipItemId;
    private long shipTypeId;

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public long getShipItemId() {
        return shipItemId;
    }

    public void setShipItemId(long shipItemId) {
        this.shipItemId = shipItemId;
    }

    public long getShipTypeId() {
        return shipTypeId;
    }

    public void setShipTypeId(long shipTypeId) {
        this.shipTypeId = shipTypeId;
    }
}
