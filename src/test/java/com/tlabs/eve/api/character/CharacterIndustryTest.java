package com.tlabs.eve.api.character;



import com.tlabs.eve.api.IndustryJobsResponse;

import org.junit.Test;

public final class CharacterIndustryTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testIndustryJobs() throws Exception {
        IndustryJobsResponse r = apiCall(new CharacterIndustryJobsRequest(characterKey.id));
    }

}
