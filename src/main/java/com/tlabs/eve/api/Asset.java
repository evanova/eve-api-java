package com.tlabs.eve.api;



import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Asset implements Serializable {

    private static final long serialVersionUID = 3312515668424970872L;

    private long itemID;//it is the typeID	

    private long locationID;
    private String locationName;//Not in XML

    private long quantity;

    private int inventoryFlag;
    private String inventoryFlagName;//not in XML
    private boolean packaged;

    private List<Asset> items = new LinkedList<>();

    public Asset() {
        super();
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getLocationID() {
        return locationID;
    }

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

    public long getQuantity() {
        return quantity;
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

    public boolean getPackaged() {
        return packaged;
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

    public final String getLocationName() {
        return locationName;
    }

    public final void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public final List<Asset> getContainedItems() {
        return this.items;
    }

    public final int getContainedCount() {
        return this.items.size();
    }
}
