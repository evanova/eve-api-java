package com.tlabs.eve.api;



import java.io.Serializable;

public class CallEntry implements Serializable {
    private static final long serialVersionUID = 5890972341885783648L;

    private int groupID;
    private long accessMask;

    private String type;
    private String name;
    private String description;

    public final int getGroupID() {
        return groupID;
    }

    public final void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public final long getAccessMask() {
        return accessMask;
    }

    public final void setAccessMask(long accessMask) {
        this.accessMask = accessMask;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

}
