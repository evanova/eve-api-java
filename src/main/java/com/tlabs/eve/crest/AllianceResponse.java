package com.tlabs.eve.crest;

import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AllianceResponse extends CRESTResponse {

    private static final long serialVersionUID = -1191289543661432529L;

    private final List<Alliance> alliances = new LinkedList<Alliance>();

    public final List<Alliance> getAlliances() {
        return alliances;
    }

    @JsonProperty("items")
    public void setAlliances(final List<Alliance> alliances) {
        this.alliances.addAll(alliances);
    }
     
    public void setAlliance(final Alliance alliance) {
        this.alliances.add(alliance);
    }
}
