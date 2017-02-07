package com.tlabs.eve.api;

import java.io.Serializable;

public class ContractItem implements Serializable {

    private static final long serialVersionUID = -7114907930568872859L;

    private long typeID;
    private String typeName; //not in XML

    private long recordID;
    private long quantity;

    // This attribute will only show up if the quantity is a negative number in the DB.
    // Negative quantities are in fact codes, -1 indicates that the item is a singleton (non-stackable).
    // If the item happens to be a Blueprint, -1 is an Original and -2 is a Blueprint Copy.
    private long rawQuantity = 0;

    private boolean singleton;

    // 1 if the contract issuer has submitted this item with the contract,
    // 0 if the issuer is asking for this item in the contract.
    private boolean included;

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public long getRecordID() {
        return recordID;
    }

    public void setRecordID(long recordID) {
        this.recordID = recordID;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getRawQuantity() {
        return rawQuantity;
    }

    public void setRawQuantity(long rawQuantity) {
        this.rawQuantity = rawQuantity;
    }

    public boolean getSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public void setSingleton(int singleton) {
        this.singleton = (singleton == 1);
    }

    // 1 if the contract issuer has submitted this item with the contract,
    // 0 if the issuer is asking for this item in the contract.
    public boolean getIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public void setIncluded(int included) {
        this.included = (included == 1);
    }
}
