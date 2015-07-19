package com.tlabs.eve.crest;

public class SovereigntyCampaignsRequest extends CRESTRequest<SovereigntyStructuresResponse> {

    public SovereigntyCampaignsRequest() {
        super(SovereigntyStructuresResponse.class, "/sovereignty/campaigns");
    }
}
