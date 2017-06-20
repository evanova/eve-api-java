package com.tlabs.eve.esi.model;

public class ESIName {
    private String name;
    private String group;

    private long id;

    public final String getName() {
        return name;
    }

    public final <T extends ESIName> T setName(String name) {
        this.name = name;
        return (T)this;
    }

    public final String getGroup() {
        return group;
    }

    public final <T extends ESIName> T setGroup(String group) {
        this.group = group;
        return (T)this;
    }

    public final long getId() {
        return id;
    }

    public final <T extends ESIName> T setId(long id) {
        this.id = id;
        return (T)this;
    }
}
