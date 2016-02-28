package com.tlabs.eve.central;



import java.util.ArrayList;
import java.util.List;

public class EveCentralQuickLookResponse extends EveCentralResponse {

    private final List<EveCentralOrder> buyOrders = new ArrayList<>();
    private final List<EveCentralOrder> sellOrders = new ArrayList<>();

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
