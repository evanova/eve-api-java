package com.tlabs.eve.fitting;

import com.tlabs.eve.api.Item;
import com.tlabs.eve.api.ItemAttribute;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Fitting implements Serializable {

    private static final long serialVersionUID = 384757313634349249L;

    private final Map<Integer, List<String>> modules;

    private String name;
    private String description;

    private long shipTypeID;
    private String shipTypeName;

    public Fitting() {
        this.modules = new HashMap<>();
    }

    public Fitting(final Item item) {
        this();
        this.shipTypeID = item.getItemID();
        this.shipTypeName = item.getName();
        this.name = item.getName();
    }

    public Fitting(final Ship from) {
        this();
        setShipTypeID(from.getItemID());
        setTypeName(from.getItemName());
        setName(from.getName());
        setDescription(from.getDescription());
        for (int i = 0; i < from.getSlotCount(); i++) {
            final int slotId = from.getSlot(i);

            final List<Module> modules = from.getModules(from.getSlot(i));
            for (int m = 0; m < modules.size(); m++) {
                final Module module = modules.get(m);
                addModule(slotId, module.getItemName());
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

    public final void addModule(final int slotId, final String module) {
        List<String> modules = this.modules.get(slotId);
        if (null == modules) {
            modules = new LinkedList<>();
            this.modules.put(slotId, modules);
        }
        modules.add(module);
    }

    public Map<Integer, List<String>> getModules() {
        return this.modules;
    }

    public List<String> getModules(int slotId) {
        return getModules().get(slotId);
    }

    public String toClipboard() {
        return FittingHelper.toClipboardContent(this);
    }

    public String toXContent() {
        return FittingHelper.toXContent(this);
    }

    public String toJSON() {
        return FittingHelper.toJSONContent(this);
    }
}
