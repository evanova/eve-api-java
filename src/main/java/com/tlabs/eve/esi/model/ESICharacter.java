package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.List;

public class ESICharacter {
    //TODO
    public static class History {

    }

    private final List<History> history = new ArrayList<>();
    private final Long id;
    private String name;

    private String portrait64;
    private String portrait128;
    private String portrait256;
    private String portrait512;

    public ESICharacter(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<History> getHistory() {
        return history;
    }

    public String getName() {
        return name;
    }

    public ESICharacter setName(String name) {
        this.name = name;
        return this;
    }

    public ESICharacter add(final History h) {
        this.history.add(h);
        return this;
    }

    public String getPortrait64() {
        return portrait64;
    }

    public void setPortrait64(String portrait64) {
        this.portrait64 = portrait64;
    }

    public String getPortrait128() {
        return portrait128;
    }

    public void setPortrait128(String portrait128) {
        this.portrait128 = portrait128;
    }

    public String getPortrait256() {
        return portrait256;
    }

    public void setPortrait256(String portrait256) {
        this.portrait256 = portrait256;
    }

    public String getPortrait512() {
        return portrait512;
    }

    public void setPortrait512(String portrait512) {
        this.portrait512 = portrait512;
    }

}
