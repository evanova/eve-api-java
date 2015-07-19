package com.tlabs.eve.api;



import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class Asset extends Item implements Serializable {

    private static final long serialVersionUID = 3312515668424970872L;

    @Getter
    @Setter
    private long locationID;

    @Getter
    @Setter
    private String locationName;//Not in XML

    @Getter
    @Setter
    private long quantity;

    private int inventoryFlag;
    private String inventoryFlagName;//not in XML

    @Getter
    @Setter
    private boolean packaged;

    private List<Asset> items = new LinkedList<>();

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public void setLocationID(String locationID) {
        if (StringUtils.isBlank(locationID)) {
            this.locationID = -1;
        }
        else {
            this.locationID = Long.parseLong(locationID);
        }
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    public int getInventoryFlag() {
        return inventoryFlag;
    }

    public void setInventoryFlag(int inventoryFlag) {
        this.inventoryFlag = inventoryFlag;
        this.inventoryFlagName = "" + inventoryFlag;
    }

    public void setInventoryFlag(String inventoryFlag) {
        this.inventoryFlag = Integer.parseInt(inventoryFlag);
        this.inventoryFlagName = inventoryFlag;
    }

    public void setPackaged(boolean packaged) {
        this.packaged = packaged;
    }

    public void setPackaged(String packaged) {
        this.packaged = "0".equals(packaged);
    }

    public final String getInventoryName() {
        return inventoryFlagName;
    }

    public final void setInventoryName(String inventoryName) {
        this.inventoryFlagName = inventoryName;
    }

    public void addAsset(Asset item) {
        this.items.add(item);
    }

    public final List<Asset> getAssets() {
        return items;
    }

    public final void setAssets(List<Asset> items) {
        this.items = items;
    }

    public void setItem(final Item item) {
        setName(item.getName());
        setRaceID(item.getRaceID());
        setDescription(item.getDescription());
        setCategoryID(item.getCategoryID());
        setCategoryName(item.getCategoryName());
        setGroupID(item.getGroupID());
        setGroupName(item.getGroupName());
        setMetaGroupID(item.getMetaGroupID());
        setMetaGroupName(item.getMetaGroupName());
        setMass(item.getMass());
        setVolume(item.getVolume());
        setCapacity(item.getCapacity());
        setDuplicateChange(item.getDuplicateChange());
        setPortion(item.getPortion());
        setBasePrice(item.getBasePrice());
        setMarketGroupID(item.getMarketGroupID());
        setPublished(item.getPublished());
    }
}
