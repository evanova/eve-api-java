package com.tlabs.eve.api.account;



import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.AccountStatusRequest;
import com.tlabs.eve.api.AccountStatusResponse;
import com.tlabs.eve.api.EveApiTest;
import com.tlabs.eve.api.character.CharacterSheet;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        Assert.assertTrue("Character count = " + size, size > 0);
        print(q.getCharacters());
    }

    @Test(timeout = 10000)
    public void validCharacterAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(characterKey.keyId, characterKey.keyValue);

        AccessInfoResponse q = apiCall(r);
        int size = q.getCharacters().size();
        Assert.assertTrue("Character count = " + size, size > 0);
        print(q.getCharacters());
    }

    @Test(timeout = 10000)
    public void validCorporationAccessInfo() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(corporationKey.keyId, corporationKey.keyValue);

        AccessInfoResponse q = apiCall(r);

        int size = q.getCharacters().size();
        Assert.assertTrue("Corporation count = " + size, size > 0);
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

    private static void print(final List<CharacterSheet> eves) {
        System.out.println("\nCharacters:");
        for (CharacterSheet c : eves) {
            System.out.println(c.getCharacterName() + " - " + c.getCorporationName());
        }
    }
}
