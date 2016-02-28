package com.tlabs.eve.zkb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tlabs.eve.EveResponse;

import java.util.ArrayList;
import java.util.List;

public class ZKillResponse extends EveResponse {

    @JsonIgnore
    private List<ZKillMail> kills = new ArrayList<>();

    public ZKillResponse() {
        setCachedUntil(System.currentTimeMillis() + 60l * 1000l);
    }

    public List<ZKillMail> getKills() {
        return kills;
    }

    @JsonProperty
    public void setKills(List<ZKillMail> kills) {
        this.kills.clear();
        this.kills.addAll(kills);
    }
}
