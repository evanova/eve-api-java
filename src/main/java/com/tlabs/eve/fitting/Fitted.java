package com.tlabs.eve.fitting;

import com.tlabs.eve.api.Item;

import java.util.LinkedList;
import java.util.List;


public class Fitted extends Module {

    private final Fitting fitting;
    private List<Module> modules = new LinkedList<>();

    public Fitted(final Item item, final Fitting fitting) {
        super(item);
        this.fitting = fitting;
    }

    public final List<Module> getModules() {
        return modules;
    }

    public final String getName() {
        return fitting.getName();
    }

    public final String getDescription() {
        return fitting.getDescription();
    }

    public void addModule(final Module module) {
        this.modules.add(module);
    }

}
