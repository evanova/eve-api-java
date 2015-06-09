package com.tlabs.eve.api.mail;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tlabs.eve.parser.BooleanDeserializer;

public class KillMailItem {

    private long typeID;
    private String typeName;//not in JSON

    private int flag;

    @JsonProperty("qtyDropped")
    private long dropped;

    @JsonProperty("qtyDestroyed")
    private long destroyed;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean singleton;

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public long getDropped() {
        return dropped;
    }

    public void setDropped(long dropped) {
        this.dropped = dropped;
    }

    public long getDestroyed() {
        return destroyed;
    }

    public void setDestroyed(long destroyed) {
        this.destroyed = destroyed;
    }

    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }
}
