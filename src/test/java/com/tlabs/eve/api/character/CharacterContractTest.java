package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.ContractItemsResponse;
import com.tlabs.eve.api.ContractListResponse;

import org.junit.Test;

public final class CharacterContractTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testValidContract() throws Exception {
        ContractListResponse contracts = apiCall(new CharacterContractsRequest(characterKey.id));
    }

    @Test(timeout = 10000)
    public void testAllCharacterContracts() throws Exception {
        AccessInfoRequest r = new AccessInfoRequest(accountKey.keyId, accountKey.keyValue);

        AccessInfoResponse q = apiCall(r);
        for (CharacterSheet c : q.getCharacters()) {
            ContractListResponse contracts = apiCall(new CharacterContractsRequest(String.valueOf(c.getCharacterID())));
        }
    }

    @Test(timeout = 10000)
    public void testContractItems() throws Exception {
        final CharacterContractItemsRequest r = new CharacterContractItemsRequest(characterKey.keyId, 1);
        ContractItemsResponse q = apiCall(r);
    }
}
