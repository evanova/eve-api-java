package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveApiTest;

import org.junit.Before;

public abstract class CorporationApiTest extends EveApiTest {

    @Before
    public void onCorporationSetup() {
        setKeyID(corporationKey.keyId);
        setKeyValue(corporationKey.keyValue);
    }

}
