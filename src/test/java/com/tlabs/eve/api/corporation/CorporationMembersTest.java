package com.tlabs.eve.api.corporation;



import org.junit.Test;

public final class CorporationMembersTest extends CorporationApiTest {

    @Test(timeout = 10000)
    public void testCorporationMembers() throws Exception {
        MemberTrackingResponse members = apiCall(new MemberTrackingRequest(corporationKey.id, true));
    }

}
