package com.tlabs.eve.esi.model;

public class ESIKillMail {

    private Long id;
    private Long time;

    private String hash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
