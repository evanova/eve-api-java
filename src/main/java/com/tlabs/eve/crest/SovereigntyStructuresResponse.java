package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class SovereigntyStructuresResponse extends CRESTResponse {

    private static final long serialVersionUID = 5570219482229411021L;

    @JsonProperty
    private int pageCount;

    @JsonProperty
    private int totalCount;

    @JsonProperty("items")
    private List<SovereigntyStructure> structures;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<SovereigntyStructure> getStructures() {
        return structures;
    }

    public void setStructures(List<SovereigntyStructure> structures) {
        this.structures = structures;
    }
}
