package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.MarketOrderResponse;

import org.junit.Assert;
import org.junit.Test;

public final class CorporationMarketTest extends CorporationApiTest {

    @Test(timeout = 10000)
    public void testFullMarketOrders() throws Exception {
        MarketOrderResponse orders = apiCall(new CorporationMarketOrderRequest(corporationKey.id));
        Assert.assertEquals("Error Code", 0, orders.getErrorCode());

    }
}
