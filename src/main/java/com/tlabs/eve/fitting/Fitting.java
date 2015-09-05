package com.tlabs.eve.fitting;

import com.tlabs.eve.api.ItemAttribute;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//What the Eve Online export function provides...
public class Fitting implements Serializable {

    private static final long serialVersionUID = 384757313634349249L;

    private final Map<String, String> modules;

    //This is NOT in saved XML; you have to find a way to populate it.
    private String name;
    private String description;

    private long shipTypeID;
    private String shipTypeName;

    public Fitting() {
        this.modules = new HashMap<>();
    }

    public Fitting(final Ship from) {
        this();
        setTypeName(from.getItemName());
        setName(from.getName());
        setDescription(from.getDescription());
        for (int i = 0; i < from.getSlotCount(); i++) {
            final Long slotId = from.getSlot(i);
            String prefix = "";
            switch (slotId.intValue()) {
                case ItemAttribute.FIT_HIGH_SLOTS:
                    prefix = "hi slot %s";
                    break;
                case ItemAttribute.FIT_MEDIUM_SLOTS:
                    prefix = "med slot %s";
                    break;
                case ItemAttribute.FIT_LOW_SLOTS:
                    prefix = "low slot %s";
                    break;
                case ItemAttribute.FIT_RIGS_SLOTS:
                    prefix = "rig slot %s";
                    break;
                case ItemAttribute.FIT_SUBSYSTEM_SLOTS:
                    prefix = "subsystem slot %s";
                    break;
                default:
                    prefix = "cargo";
                    break;
            }
            final List<Module> modules = from.getModules(from.getSlot(i));
            for (int m = 0; m < modules.size(); m++) {
                final Module module = modules.get(m);
                addModule(String.format(prefix, Integer.toString(m)), module.getItemName());
            }
        }
    }

    public Fitting(final Fitting f) {
        this();
        this.modules.putAll(f.modules);
        this.shipTypeID = f.shipTypeID;
        this.shipTypeName = f.shipTypeName;

        this.name = f.name;
        this.description = f.description;
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

    public final String getTypeName() {
        return shipTypeName;
    }

    public final void setTypeName(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }

    public long getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(long shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public final void addModule(final String slot, final String module) {
        this.modules.put(slot, module);
    }

    public Map<String, String> getModules() {
        return this.modules;
    }

}
