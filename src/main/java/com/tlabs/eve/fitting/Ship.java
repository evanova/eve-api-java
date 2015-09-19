package com.tlabs.eve.fitting;

import com.tlabs.eve.api.Item;
import com.tlabs.eve.api.ItemAttribute;
import com.tlabs.eve.api.ItemEffect;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Ship extends Module {

    private final Map<Integer, List<Module>> modules;//attr id -> list of modules
    private final List<Integer> slots;//attr ids

    private final Map<Item, Integer> cargo;
    private final Map<Module, Integer> drones;

    private final String name;
    private final String description;

    public Ship(final Ship ship) {
        super(
                ship.getItem(),
                ship.getAttributes(),
                ship.getEffects());

        this.name = ship.getName();
        this.description = ship.getDescription();

        this.modules = new HashMap<>();
        this.modules.putAll(ship.modules);

        this.slots = new LinkedList<>();
        this.slots.addAll(ship.slots);

        this.cargo = new HashMap<>();
        this.cargo.putAll(ship.cargo);

        this.drones = new HashMap<>();
        this.drones.putAll(ship.drones);
    }

    public Ship(
            final Item item,
            final Map<Integer, ItemAttribute> attributes,
            final Map<Integer, ItemEffect> effects,
            final String name,
            final String description) {
        super(item, attributes, effects);

        this.name = name;
        this.description = description;

        this.modules = new HashMap<>();
        this.cargo = new HashMap<>();
        this.drones = new HashMap<>();

        this.slots = new LinkedList<>();
        if (null != item) {
            addEmptyModules(ItemAttribute.FIT_HIGH_SLOTS);
            addEmptyModules(ItemAttribute.FIT_MEDIUM_SLOTS);
            addEmptyModules(ItemAttribute.FIT_LOW_SLOTS);
            addEmptyModules(ItemAttribute.FIT_RIGS_SLOTS);
            addEmptyModules(ItemAttribute.FIT_SUBSYSTEM_SLOTS);
        }
    }

    public int getSlotCount() {
        return this.slots.size();
    }

    public int getModuleCount(final int slotId) {
        final List<Module> modules = this.modules.get(slotId);
        return (null == modules) ? 0 : modules.size();
    }

    public int getModuleCount() {
        int count = 0;
        for (List<Module> l: this.modules.values()) {
            count = count + l.size();
        }
        return count;
    }

    public int getSlot(final int index) {
        if (index >= this.slots.size()) {
            return -1;
        }
        return this.slots.get(index);
    }

    public List<Module> getModules(final int slotId) {
        return this.modules.get(slotId);
    }

    public Module getModuleAt(final int slotId, final int position) {
        final List<Module> modules = this.modules.get(slotId);
        return (null == modules) ? null : modules.get(position);
    }

    public Map<Module, Integer> getDrones() {
        return drones;
    }

    public Map<Item, Integer> getCargo() {
        return cargo;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public boolean addModule(final Module module) {
        return addModuleImpl(module);
    }

    public boolean addModule(final Module module, final int slotId) {
        return reallyAddModule(module, slotId);
    }

    public boolean removeModule(final int slotId, final int position) {
        final List<Module> modules = this.modules.get(slotId);
        if (null == modules) {
            return false;
        }
        final Module removed = modules.remove(position);
        if (null == removed) {
            return false;
        }

        modules.add(position, new Module());
        return true;
    }

    public boolean getFull() {
        for (List<Module> l: this.modules.values()) {
            for (Module m: l) {
                if (m.getItemID() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getFull(final int slotId) {
        final List<Module> slot = this.modules.get(slotId);
        if (null == slot) {
            return true;
        }
        for (Module m: slot) {
            if (m.getItemID() == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean addModuleImpl(final Module module) {
        if (addModuleImpl(module, ItemAttribute.FIT_HIGH_SLOTS, ItemEffect.USES_HIGH_SLOT)) {
            return true;
        }
        if (addModuleImpl(module, ItemAttribute.FIT_MEDIUM_SLOTS, ItemEffect.USES_MEDIUM_SLOT)) {
            return true;
        }
        if (addModuleImpl(module, ItemAttribute.FIT_LOW_SLOTS, ItemEffect.USES_LOW_SLOT)) {
            return true;
        }
        if (addModuleImpl(module, ItemAttribute.FIT_RIGS_SLOTS, ItemEffect.USES_RIG_SLOT)) {
            return true;
        }
        return addModuleImpl(module, ItemAttribute.FIT_SUBSYSTEM_SLOTS, ItemEffect.USES_SUBSYSTEM);

    }

    private boolean addModuleImpl(final Module module, final int slotAttributeId, final int effectId) {
        final ItemEffect effect = module.getEffect(effectId);
        if (null == effect) {
            return false;
        }
        return reallyAddModule(module, slotAttributeId);
    }

    private boolean reallyAddModule(final Module module, final int slotAttributeId) {
        final List<Module> modules = this.modules.get(slotAttributeId);
        if (null == modules) {
            return false;
        }

        int position = -1;
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getItemID() == -1) {
                position = i;
                break;
            }
        }
        if (position == -1) {
            return false;
        }

        modules.remove(position);
        modules.add(position, module);
        return true;
    }

    private void addEmptyModules(int attributeId) {
        final ItemAttribute attr = getAttribute(attributeId);
        if ((null == attr) || (attr.getValue() == 0f)) {
            return;
        }

        final int slotSize = (int)attr.getValue();
        final List<Module> modules = new ArrayList<>((int)attr.getValue());
        for (int i = 0; i < slotSize; i++) {
            modules.add(new Module());
        }

        this.slots.add(attributeId);
        this.modules.put(attributeId, modules);
    }

}
