package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SovereigntyCampaignsResponse extends CRESTResponse {

    private static final long serialVersionUID = -6276270403461126425L;

    @JsonProperty
    private int pageCount;

    @JsonProperty
    private int totalCount;

    @JsonProperty("items")
    private List<SovereigntyCampaign> campaigns;
}
