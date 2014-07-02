package com.tlabs.eve.crest;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class Incursion implements Serializable {

    private static final long serialVersionUID = 5610902832694179782L;

    @JsonProperty("influence")
    private float influence;

    @JsonProperty("hasBoss")
    private boolean hasBoss;

    @JsonProperty("state")
    private String state;

    private long stagingSolarSystemID;
    private String stagingSolarSystemName;

    private long constellationID;
    private String constellationName;

    public final float getInfluence() {
        return influence;
    }

    public final boolean isHasBoss() {
        return hasBoss;
    }

    public final String getState() {
        return state;
    }

    public final long getSolarSystemID() {
        return stagingSolarSystemID;
    }

    public final String getSolarSystemName() {
        return stagingSolarSystemName;
    }

    public final long getConstellationID() {
        return constellationID;
    }

    public final String getConstellationName() {
        return constellationName;
    }

    @JsonProperty("stagingSolarSystem")
    public final void setStagingSolarSystem(Map<String, String> stagingSolarSystem) {
        this.stagingSolarSystemID = Long.parseLong(stagingSolarSystem.get("id"));
        this.stagingSolarSystemName = stagingSolarSystem.get("name");
    }

    @JsonProperty("constellation")
    public final void setConstellation(Map<String, String> constellation) {
        this.constellationID = Long.parseLong(constellation.get("id"));
        this.constellationName = constellation.get("name");
    }

}
