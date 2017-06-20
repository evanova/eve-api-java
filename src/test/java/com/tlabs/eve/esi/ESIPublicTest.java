package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIMarketItem;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIName;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ESIPublicTest {

    protected static ESIService ESI;

    @BeforeClass
    public static void beforeESITest() {
        ESI = ESIClient
                .TQ()
                .id("65bb75ff50c74f039ec6496d1754904a")
                .key("LPLVKxyiEKBYhiFf985tQyF2D3CdYBNiQGqxIyFY")
                .scopes("publicData")
                .build()
                .obtain(null);
    }

    @Test
    public void testGetServerStatus() {
        Assert.assertNotNull(ESI.getServerStatus());
    }

    @Test
    public void testGetMarketPrices() {
        final List<ESIMarketItem> prices = ESI.getMarketPrices();
        Assert.assertNotNull(prices);
        Assert.assertFalse(prices.isEmpty());
    }

    @Test
    public void testGetMarketOrders() {
        final List<ESIName> regions = ESI.getRegions();
        Assert.assertNotNull(regions);
        Assert.assertFalse(regions.isEmpty());

        final List<ESIMarketItem> prices = ESI.getMarketPrices();
        Assert.assertNotNull(prices);
        Assert.assertFalse(prices.isEmpty());

        Assert.assertNotNull(
                ESI.getMarketOrders(regions.get(0).getId(), prices.get(0).getTypeID()));
    }

    @Test
    public void testGetNames() {

        long a = Integer.MAX_VALUE - 1023217532861L;
        List<ESIName> names = ESI.getNames(Arrays.asList(
                60002251L,
                60012949L,
                60014071L,
                1023217532861L));
    }
   /* @Test
    public void testAllGetMarketOrders() {
        final long typeID = 32772;
        final List<ESIName> regions = publicESI.getRegions();
        Assert.assertNotNull(regions);
        Assert.assertFalse(regions.isEmpty());

        final List<ESIMarketOrder> orders = new ArrayList<>();
        regions
            .stream()
            .parallel()
            .map(r -> publicESI.getMarketOrders(r.getId(), typeID))
            .forEach(l -> orders.addAll(l));

        Assert.assertFalse(orders.isEmpty());
    }*/

    @Test
    public void testGetRegions() {
        final List<ESIName> regions = ESI.getRegions();
        Assert.assertNotNull(regions);
        Assert.assertFalse(regions.isEmpty());
    }


}
