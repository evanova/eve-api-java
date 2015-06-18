package com.tlabs.eve.central;



import com.tlabs.eve.EveResponse;

public abstract class EveCentralResponse extends EveResponse {

    public EveCentralResponse() {
        super();
        setCachedUntil(System.currentTimeMillis() + 1l * 3600l * 1000l);
    }
}
