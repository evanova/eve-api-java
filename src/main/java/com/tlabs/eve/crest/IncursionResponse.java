package com.tlabs.eve.crest;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class IncursionResponse extends CRESTResponse {

    private static final long serialVersionUID = 5301172980445712069L;

    @JsonProperty("items")
    private List<Incursion> items;

    public IncursionResponse() {
    }

    public final List<Incursion> getItems() {
        return items;
    }

}
