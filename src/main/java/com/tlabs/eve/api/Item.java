package com.tlabs.eve.api;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Item implements Serializable {

    public static boolean isShip(final long categoryID) {
        return categoryID == 6;
    }
    public static boolean isShip(final Item item) {
        return ((null != item) && (item.categoryID == 6));
    }

    private static final long serialVersionUID = 1043774614858911035L;

    private long itemID;//it is the typeID

    private String itemName;//item name;//not in Eve XML

    private int raceID;//not in Eve XML

    private String description;////not in Eve XML

    private long categoryID;//not in Eve XML

    private String categoryName;//not in Eve XML

    private long groupID;//not in Eve XML

    private String groupName;//not in Eve XML

    private long metaGroupID;//not in Eve XML

    private String metaGroupName;//not in Eve XML

    private double mass;//not in Eve XML

    private double volume;//not in Eve XML

    private double capacity;//not in Eve XML

    private float duplicateChange;//not in Eve XML

    private long portion;//not in Eve XML

    private double basePrice;//not in Eve XML

    private long marketGroupID;//not in Eve XML
    private String marketGroupName;
    private String marketGroupDescription;

    private final List<ItemTrait> traits = new ArrayList<>();//in YML only
    private final List<ItemAttribute> attributes = new ArrayList<>();
    private final List<ItemEffect> effects = new ArrayList<>();
    private final Map<Skill, Integer> requirements = new LinkedHashMap<>();

    public String getName() {
        return itemName;
    }

    public void setName(String name) {
        this.itemName = name;
    }

    public List<ItemTrait> getTraits() {
        return traits;
    }

    public void setTraits(List<ItemTrait> traits) {
        this.traits.clear();
        this.traits.addAll(traits);
    }

    public void addTrait(ItemTrait trait) {
        this.traits.add(trait);
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getGroupID() {
        return groupID;
    }

    public void setGroupID(long groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getMetaGroupID() {
        return metaGroupID;
    }

    public void setMetaGroupID(long metaGroupID) {
        this.metaGroupID = metaGroupID;
    }

    public String getMetaGroupName() {
        return metaGroupName;
    }

    public void setMetaGroupName(String metaGroupName) {
        this.metaGroupName = metaGroupName;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public float getDuplicateChange() {
        return duplicateChange;
    }

    public void setDuplicateChange(float duplicateChange) {
        this.duplicateChange = duplicateChange;
    }

    public long getPortion() {
        return portion;
    }

    public void setPortion(long portion) {
        this.portion = portion;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public long getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(long marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public void addRequirement(final Skill skill, int level) {
        for (Map.Entry<Skill, Integer> e: this.requirements.entrySet()) {
            if (e.getKey().getSkillID() == skill.getSkillID()) {
                if (level > e.getValue()) {
                    this.requirements.put(skill, level);
                }
                return;
            }
        }

        this.requirements.put(skill, level);
    }

    public Map<Skill, Integer> getRequirements() {
        return requirements;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }

    public String getMarketGroupDescription() {
        return marketGroupDescription;
    }

    public void setMarketGroupDescription(String marketGroupDesciption) {
        this.marketGroupDescription = marketGroupDesciption;
    }

    public void setEffects(final List<ItemEffect> effects) {
        this.effects.clear();
        this.effects.addAll(effects);
    }

    public void addEffect(final ItemEffect effect) {
        this.effects.add(effect);
    }

    public List<ItemEffect> getEffects() {
        return effects;
    }

    public ItemEffect findEffect(final String name) {
        for (ItemEffect attr: this.effects) {
            if (StringUtils.equals(attr.getName(), name)) {
                return attr;
            }
        }
        return null;
    }

    public ItemEffect findEffect(final long id) {
        for (ItemEffect attr: this.effects) {
            if (attr.getID() == id) {
                return attr;
            }
        }
        return null;
    }

    public boolean usesSlowSlot() {
        return hasEffect(ItemEffect.USES_LOW_SLOT);
    }

    public boolean usesMediumSlot() {
        return hasEffect(ItemEffect.USES_MEDIUM_SLOT);
    }

    public boolean usesHighSlot() {
        return hasEffect(ItemEffect.USES_HIGH_SLOT);
    }

    public boolean usesSubsystemSlot() {
        return hasEffect(ItemEffect.USES_SUBSYSTEM);
    }

    public boolean usesRigSlot() {
        return hasEffect(ItemEffect.USES_RIG_SLOT);
    }

    private boolean hasEffect(final long effect) {
        final ItemEffect e = findEffect(effect);
        return (null != e);
    }

    public void setAttributes(final List<ItemAttribute> attributes) {
        this.attributes.clear();
        this.attributes.addAll(attributes);
    }

    public void addAttributes(final ItemAttribute attribute) {
        this.attributes.add(attribute);
    }

    public List<ItemAttribute> getAttributes() {
        return attributes;
    }

    public ItemAttribute findAttribute(final String name) {
        for (ItemAttribute attr: this.attributes) {
            if (StringUtils.equals(attr.getName(), name)) {
                return attr;
            }
        }
        return null;
    }

    public ItemAttribute findAttribute(final long id) {
        for (ItemAttribute attr: this.attributes) {
            if (attr.getID() == id) {
                return attr;
            }
        }
        return null;
    }
}
