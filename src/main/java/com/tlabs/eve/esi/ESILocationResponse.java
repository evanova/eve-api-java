package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESILocation;

public class ESILocationResponse extends ESIResponse {

    private ESILocation location;

    public <T extends ESILocation> T getLocation() {
        return (T)location;
    }

    public ESILocationResponse setLocation(ESILocation location) {
        this.location = location;
        return this;
    }
}
