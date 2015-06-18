package com.tlabs.eve.api.character;



import com.tlabs.eve.api.MarketOrderResponse;

import org.junit.Test;

public final class CharacterMarketTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testFullMarketOrders() throws Exception {
        MarketOrderResponse orders = apiCall(new CharacterMarketOrderRequest(characterKey.id));

    }

}
