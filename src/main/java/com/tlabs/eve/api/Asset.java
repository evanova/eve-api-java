package com.tlabs.eve.api;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;


public class Asset implements Serializable {

    private static final long serialVersionUID = 3312515668424970872L;

    private Item item;

    private long itemID;//typeID

    private long categoryID; //Not in XML

    private long assetID;

    private long parentID; //Not in XML

    private long locationID;

    private String locationName;//Not in XML

    private long quantity;

    private int inventoryFlag;
    private String inventoryFlagName;//not in XML

    private boolean packaged;
    
    private long rawQuantity;

    private List<Asset> items = new ArrayList<>();

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public long getAssetID() {
        return assetID;
    }

    public void setAssetID(long assetID) {
        this.assetID = assetID;
    }

    public long getParentID() {
        return parentID;
    }

    public void setParentID(long parentID) {
        this.parentID = parentID;
    }

    public long getLocationID() {
        return locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getInventoryFlagName() {
        return inventoryFlagName;
    }

    public void setInventoryFlagName(String inventoryFlagName) {
        this.inventoryFlagName = inventoryFlagName;
    }

    public boolean isPackaged() {
        return packaged;
    }

	public long getRawQuantity() {
		return rawQuantity;
	}

	public void setRawQuantity(long rawQuantity) {
		this.rawQuantity = rawQuantity;
	}

}
