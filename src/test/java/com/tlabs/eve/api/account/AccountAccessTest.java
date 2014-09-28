package com.tlabs.eve.api.account;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.AccountStatusRequest;
import com.tlabs.eve.api.AccountStatusResponse;
import com.tlabs.eve.api.EveApiTest;
import com.tlabs.eve.api.character.Capsuleer;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class AccountAccessTest extends EveApiTest {

    @Test(timeout = 10000, expected = IllegalArgumentException.class)
    public void invalidAccountAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(accountKey.keyId, "123145");
        AccessInfoResponse q = apiCall(r);
    }

    @Test(timeout = 10000, expected = IllegalArgumentException.class)
    public void invalidCorporationAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(corporationKey.keyId, "123145");
        AccessInfoResponse q = apiCall(r);
    }

    @Test(timeout = 10000)
    public void validAccountAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(accountKey.keyId, accountKey.keyValue);
        AccessInfoResponse q = apiCall(r);

        int size = q.getCharacters().size();
        assertTrue("Character count = " + size, size > 0);
        print(q.getCharacters());
    }

    @Test(timeout = 10000)
    public void validCharacterAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(characterKey.keyId, characterKey.keyValue);

        AccessInfoResponse q = apiCall(r);
        int size = q.getCharacters().size();
        assertTrue("Character count = " + size, size > 0);
        print(q.getCharacters());
    }

    @Test(timeout = 10000)
    public void validCorporationAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(corporationKey.keyId, corporationKey.keyValue);

        AccessInfoResponse q = apiCall(r);

        int size = q.getCharacters().size();
        assertTrue("Corporation count = " + size, size > 0);
        print(q.getCharacters());
    }

    @Test(timeout = 10000)
    public void validAccountRequest() throws Exception {
        AccountStatusRequest r = new AccountStatusRequest(accountKey.keyId, accountKey.keyValue);
        AccountStatusResponse q = apiCall(r);
    }

    @Test(timeout = 10000)
    public void validCharacterRequest() throws Exception {
        AccountStatusRequest r = new AccountStatusRequest(characterKey.keyId, characterKey.keyValue);
        AccountStatusResponse q = apiCall(r);
    }

    /*@Test(timeout=10000) 
    public void validCorporationRequestV2() {
    	AccountStatusRequest r = 
    		new AccountStatusRequest(
    			EveApiKeys.CorporationV2.keyId, 
    			EveApiKeys.CorporationV2.keyValue,
    			false);
    	AccountStatusResponse q = testEveAPI(Api.APIV2, r);	
    }*/

    private static void print(final List<Capsuleer> eves) {
        System.out.println("\nCharacters:");
        for (Capsuleer c : eves) {
            System.out.println(c.getCharacterName() + " - " + c.getCorporationName());
        }
    }
}
