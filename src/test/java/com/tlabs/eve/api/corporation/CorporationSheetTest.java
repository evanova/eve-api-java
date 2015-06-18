package com.tlabs.eve.api.corporation;



import org.junit.Test;

public final class CorporationSheetTest extends CorporationApiTest {

    @Test(timeout = 10000)
    public void testFullSheet() throws Exception {
        CorporationSheetResponse sheet = apiCall(new CorporationSheetRequest(corporationKey.id));
    }

    @Test(timeout = 10000/*, expected=IllegalArgumentException.class*/)
    public void testNoKeysSheet() throws Exception {
        setKeyID(null);
        setKeyValue(null);

        CorporationSheetResponse sheet = apiCall(new CorporationSheetRequest(corporationKey.id));
    }

}
