package com.tlabs.eve.fitting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipFitting implements Serializable {
    
    private static final long serialVersionUID = 384757313634349249L;

    public static class Slot implements Serializable {
        
        private static final long serialVersionUID = -4619249420869678966L;

        public static enum Type {
            RIG,
            HIGH,
            MEDIUM,
            LOW;
        }
        
        private final Type type;        
        
        private long itemTypeID;
        private String itemTypeName;
        
        public Slot(final Slot.Type type) {
            this.type = type;
            this.itemTypeID = -1;
            this.itemTypeName = null;
        }

        public final Type getType() {
            return type;
        }

        public final long getItemTypeID() {
            return itemTypeID;
        }

        public final void setItemTypeID(long itemTypeID) {
            this.itemTypeID = itemTypeID;
        }

        public final String getItemTypeName() {
            return itemTypeName;
        }

        public final void setItemTypeName(String itemTypeName) {
            this.itemTypeName = itemTypeName;
        }                
    }
    
    private final Map<Slot.Type, List<Slot>> slots;
    
    private String name;
    private String description;
    
    private long shipTypeID;
    private String shipTypeName;
    
    public ShipFitting() {
        this.slots = new HashMap<Slot.Type, List<Slot>>();
        this.slots.put(Slot.Type.HIGH, new ArrayList<Slot>(8));
        this.slots.put(Slot.Type.LOW, new ArrayList<Slot>(8));
        this.slots.put(Slot.Type.MEDIUM, new ArrayList<Slot>(8));
        this.slots.put(Slot.Type.RIG, new ArrayList<Slot>(8));
    }

    public final void addSlot(final Slot slot) {
        this.slots.get(slot.getType()).add(slot);
    }
    
    public final Slot getSlot(final Slot.Type slotType, final int index) {
        return this.slots.get(slotType).get(index);
    }
    
    public final List<Slot> getSlots(final Slot.Type slotType) {
        return this.slots.get(slotType);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final long getShipTypeID() {
        return shipTypeID;
    }

    public final void setShipTypeID(long shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public final String getShipTypeName() {
        return shipTypeName;
    }

    public final void setShipTypeName(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }
    
    
}
