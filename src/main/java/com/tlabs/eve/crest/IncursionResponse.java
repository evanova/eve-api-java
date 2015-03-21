package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
