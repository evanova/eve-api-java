package com.tlabs.eve.api.character;



import com.tlabs.eve.api.IndustryJobsResponse;

public final class CharacterIndustryJobsRequest extends CharacterRequest<IndustryJobsResponse> {
    public static final long MASK = 128;

    public CharacterIndustryJobsRequest(long charID) {
        super(IndustryJobsResponse.class, "/char/IndustryJobs.xml.aspx", MASK, charID);
    }
}
