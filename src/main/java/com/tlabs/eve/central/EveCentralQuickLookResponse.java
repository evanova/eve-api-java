package com.tlabs.eve.central;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.LinkedList;
import java.util.List;

public class EveCentralQuickLookResponse extends EveCentralResponse {

    private final List<EveCentralOrder> buyOrders = new LinkedList<>();
    private final List<EveCentralOrder> sellOrders = new LinkedList<>();

    private long typeID;
    private String typeName;
    private long typeMinimumQuantity;

    private long postedLastInMillis;

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

    public long getTypeMinimumQuantity() {
        return typeMinimumQuantity;
    }

    public void setTypeMinimumQuantity(long typeMinimumQuantity) {
        this.typeMinimumQuantity = typeMinimumQuantity;
    }

    public long getPostedLastInMillis() {
        return postedLastInMillis;
    }

    public void setPostedLastInMillis(long postedLastInMillis) {
        this.postedLastInMillis = postedLastInMillis;
    }

    public void setPostedLastInHours(long postedLastInHours) {
        this.postedLastInMillis = postedLastInHours * 60l * 60l * 1000l;
    }

    public final List<EveCentralOrder> getBuyOrders() {
        return buyOrders;
    }

    public final List<EveCentralOrder> getSellOrders() {
        return sellOrders;
    }

    public void add(EveCentralOrder p) {
        switch (p.getType()) {
        case EveCentralOrder.BUY:
            this.buyOrders.add(p);
            break;
        case EveCentralOrder.SELL:
            this.sellOrders.add(p);
            break;
        default:
            throw new IllegalArgumentException("Invalid EveCentralOrder.type " + p.getType());
        }
    }
}
