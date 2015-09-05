package com.tlabs.eve.fitting;

import com.tlabs.eve.api.Item;
import com.tlabs.eve.api.ItemAttribute;
import com.tlabs.eve.api.ItemEffect;

import java.util.Collections;
import java.util.Map;


public class Module {

    private final Item item;

    private final Map<Integer, ItemAttribute> attributes;
    private final Map<Integer, ItemEffect> effects;

    public Module() {
        this(null, null, null);
    }

    public Module(final Module module) {
        this(module.item, module.attributes, module.effects);
    }

    public Module(
            final Item item,
            final Map<Integer, ItemAttribute> attributes,
            final Map<Integer, ItemEffect> effects) {
        this.item = item;

        if (null == attributes) {
            this.attributes = Collections.emptyMap();
        }
        else {
            this.attributes = attributes;
        }
        if (null == effects) {
            this.effects = Collections.emptyMap();
        }
        else {
            this.effects = effects;
        }
    }

    public final Item getItem() {
        return item;
    }

    public final long getItemID() {
        return (null == item) ? -1 : item.getItemID();
    }

    public final String getItemName() {
        return (null == item) ? "" : item.getName();
    }

    public ItemAttribute getAttribute(int attributeId) {
        return getAttributes().get(attributeId);
    }

    public float getAttributeValue(int attributeId) {
        final ItemAttribute attr = getAttribute(attributeId);
        return (null == attr) ? 0.0f : attr.getValue();
    }

    public final ItemEffect getEffect(final int effectId) {
        return getEffects().get(effectId);
    }

    public Map<Integer, ItemAttribute> getAttributes() {
        return this.attributes;
    }

    public Map<Integer, ItemEffect> getEffects() {
        return effects;
    }
}
