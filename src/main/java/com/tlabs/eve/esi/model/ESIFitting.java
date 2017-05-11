package com.tlabs.eve.esi.model;

import java.util.List;

public class ESIFitting {

    public static class Item {
        private int invFlag;
        private long quantity;
        private long typeID;

        public int getInvFlag() {
            return invFlag;
        }

        public void setInvFlag(int invFlag) {
            this.invFlag = invFlag;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public long getTypeID() {
            return typeID;
        }

        public void setTypeID(long typeID) {
            this.typeID = typeID;
        }
    }

    private long fittingID;
    private long shipTypeID;

    private String name;
    private String description;

    private List<Item> items;

    public long getFittingID() {
        return fittingID;
    }

    public void setFittingID(long fittingID) {
        this.fittingID = fittingID;
    }

    public long getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(long shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
