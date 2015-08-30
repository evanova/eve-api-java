package com.tlabs.eve;

import com.tlabs.eve.api.AccessInfo;

import org.junit.ClassRule;

public class EveTest {

    @ClassRule
    public static EveResource resource = new EveResource("/apikeys.json");

    protected static final AccessInfo getAccount() {
        return resource.getAccountInfo();
    }

    protected static final AccessInfo getCharacter() {
        return resource.getCharacterInfo();
    }

    protected static final AccessInfo getCorporation() {
        return resource.getCorporationInfo();
    }

    protected static final <T extends EveResponse> T execute(final EveRequest<T> request) {
        return resource.execute(request);
    }
}
