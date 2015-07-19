package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SovereigntyStructuresResponse extends CRESTResponse {

    private static final long serialVersionUID = 5570219482229411021L;

    @JsonProperty
    private int pageCount;

    @JsonProperty
    private int totalCount;

    @JsonProperty("items")
    private List<SovereigntyStructure> structures;
}
