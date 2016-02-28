package com.tlabs.eve.api;

import java.util.ArrayList;
import java.util.List;


public final class SovereigntyResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8487801645146942276L;

    private final List<Sovereignty> sovereignty;

    public SovereigntyResponse() {
        this.sovereignty = new ArrayList<>();
    }

    public void addSovereignty(final Sovereignty s) {
        this.sovereignty.add(s);
    }

    public List<Sovereignty> getSovereignty() {
        return this.sovereignty;
    }
}
