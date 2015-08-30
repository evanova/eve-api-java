package com.tlabs.eve.fitting;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

//What the Eve Online export function provides...
public class Fitting implements Serializable {

    private static final long serialVersionUID = 384757313634349249L;

    private final List<String> modules;

    //This is NOT in saved XML; you have to find a way to populate it.
    private String name;
    private String description;

    private long shipTypeID;
    private String shipTypeName;
    
    public Fitting() {
        this.modules = new LinkedList<>();
    }

    public Fitting(final Fitting f) {
        this();
        this.modules.addAll(f.modules);
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

    public final void addModule(final String module) {
        this.modules.add(module);
    }

    public final List<String> getModules() {
        return this.modules;
    }

}
