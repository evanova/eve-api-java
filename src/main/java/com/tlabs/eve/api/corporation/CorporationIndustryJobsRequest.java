package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.IndustryJobsResponse;

public final class CorporationIndustryJobsRequest extends CorporationRequest<IndustryJobsResponse> {
    public static final int MASK = 128;

    public CorporationIndustryJobsRequest(String corpID) {
        super(IndustryJobsResponse.class, "/corp/IndustryJobs.xml.aspx", MASK, corpID);
    }

}
