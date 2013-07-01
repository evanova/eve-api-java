package com.tlabs.eve.api;

/*
 * #%L This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova %% Copyright (C) 2010 - 2012 Evanova
 * (Traquenard Labs) %% Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. #L%
 */

import java.io.Serializable;

public class EveContractItem extends Object implements Serializable {

    private static final long serialVersionUID = -7114907930568872859L;

    private long typeID;
    private String typeName; //not in XML
    
    private long recordID;
    private long quantity;

    // This attribute will only show up if the quantity is a negative number in the DB.
    // Negative quantities are in fact codes, -1 indicates that the item is a singleton (non-stackable).
    // If the item happens to be a Blueprint, -1 is an Original and -2 is a Blueprint Copy.
    private int rawQuantity = 0;

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

    public int getRawQuantity() {
        return rawQuantity;
    }

    public void setRawQuantity(int rawQuantity) {
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
