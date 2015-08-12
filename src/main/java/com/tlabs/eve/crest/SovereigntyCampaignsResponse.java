package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SovereigntyCampaignsResponse extends CRESTResponse {

    private static final long serialVersionUID = -6276270403461126425L;

    @JsonProperty
    private int pageCount;

    @JsonProperty
    private int totalCount;

    @JsonProperty("items")
    private List<SovereigntyCampaign> campaigns;

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

    public List<SovereigntyCampaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<SovereigntyCampaign> campaigns) {
        this.campaigns = campaigns;
    }
}
