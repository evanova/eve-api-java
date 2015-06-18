package com.tlabs.eve.central;



import org.junit.Assert;
import org.junit.Test;

public class MarketStatsTest extends EveCentralTest {

    @Test(timeout = 10000)
    public void getTwoMarketStatsTest() {
        //http://api.eve-central.com/api/marketstat?typeid=34&typeid=35&regionlimit=10000002
        final EveCentralStatsRequest q = new EveCentralStatsRequest(new long[] { 34, 35 }, 10000002);
        final EveCentralStatsResponse r = apiCall(q);
        Assert.assertNotNull(r);
        Assert.assertEquals("Market Prices size mismatch", 2, r.getMarketPrices().size());

    }
}
