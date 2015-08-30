package com.tlabs.eve.fitting;

import com.tlabs.eve.api.Item;
import com.tlabs.eve.api.ItemAttribute;
import com.tlabs.eve.api.ItemEffect;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Module {

    private final Item item;

    private Map<Integer, ItemAttribute> attributes = new HashMap<>();//only used in fitting
    private Map<Integer, ItemEffect> effects = new HashMap<>();//only used in fitting

    public Module(final Item item) {
        this.item = item;
    }

    public final Item getItem() {
        return item;
    }

    public long getItemID() {
        return (null == item) ? -1 : item.getItemID();
    }

    public String getItemName() {
        return (null == item) ? "" : item.getName();
    }

    public final ItemAttribute getAttribute(int attributeId) {
        return this.attributes.get(attributeId);
    }

    public final float getAttributeValue(int attributeId) {
        final ItemAttribute attr = getAttribute(attributeId);
        return (null == attr) ? 0.0f : attr.getValue();
    }

    public final Map<Integer, ItemAttribute> getAttributes() {
        return this.attributes;
    }

    public final Map<Integer, ItemEffect> getEffects() {
        return effects;
    }

    public final ItemEffect getEffect(final int effectId) {
        return effects.get(effectId);
    }

    public void setAttributes(Map<Integer, ItemAttribute> attributes) {
        this.attributes = attributes;
    }

    public void setEffects(Map<Integer, ItemEffect> effects) {
        this.effects = effects;
    }
}
