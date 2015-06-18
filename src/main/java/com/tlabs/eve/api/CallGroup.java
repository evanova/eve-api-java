package com.tlabs.eve.api;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CallGroup implements Serializable {

    private static final long serialVersionUID = -1224708978395100947L;

    private int groupID;
    private String name;
    private String description;

    private List<CallEntry> entries = new LinkedList<>();

    public final int getGroupID() {
        return groupID;
    }

    public final void setGroupID(int groupID) {
        this.groupID = groupID;
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

    public final List<CallEntry> getEntries() {
        return entries;
    }

    public final void addEntry(CallEntry entry) {
        this.entries.add(entry);
    }
}
