package com.tlabs.eve.api;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Item implements Serializable {

    public static boolean isShip(final long categoryID) {
        return categoryID == 6;
    }
    public static boolean isShip(final Item item) {
        return ((null != item) && (item.categoryID == 6));
    }

    private static final long serialVersionUID = 1043774614858911035L;

    @Getter
    @Setter
    private long itemID;//it is the typeID


    private String itemName;//item name;//not in Eve XML

    @Getter
    @Setter
    private int raceID;//not in Eve XML

    @Getter
    @Setter
    private String description;////not in Eve XML

    @Getter
    @Setter
    private long categoryID;//not in Eve XML

    @Getter
    @Setter
    private String categoryName;//not in Eve XML

    @Getter
    @Setter
    private long groupID;//not in Eve XML

    @Getter
    @Setter
    private String groupName;//not in Eve XML

    @Getter
    @Setter
    private long metaGroupID;//not in Eve XML

    @Getter
    @Setter
    private String metaGroupName;//not in Eve XML

    @Getter
    @Setter
    private double mass;//not in Eve XML

    @Getter
    @Setter
    private double volume;//not in Eve XML

    @Getter
    @Setter
    private double capacity;//not in Eve XML

    @Getter
    @Setter
    private float duplicateChange;//not in Eve XML

    @Getter
    @Setter
    private long portion;//not in Eve XML

    @Getter
    @Setter
    private double basePrice;//not in Eve XML

    @Getter
    @Setter
    private long marketGroupID;//not in Eve XML

    @Getter
    @Setter
    private int published;//not in Eve XML

    private final List<ItemTrait> traits = new LinkedList<>();//in YML only

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
}
