package com.tlabs.eve.central;



import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class MarketQuickLookTest extends EveCentralTest {

    @Test(timeout = 25000)
    public void buyOrdersTest() {
        final EveCentralQuickLookRequest q = new EveCentralQuickLookRequest(34l);
        final EveCentralQuickLookResponse r = apiCall(q);
        Assert.assertTrue(r.getTypeID() > 0);
        Assert.assertTrue(StringUtils.isNotBlank(r.getTypeName()));
        Assert.assertTrue(r.getBuyOrders().size() > 0);

        marketOrderTest(r.getBuyOrders().get(0));
    }

    @Test(timeout = 25000)
    public void sellOrdersTest() {
        final EveCentralQuickLookRequest q = new EveCentralQuickLookRequest(34l);
        final EveCentralQuickLookResponse r = apiCall(q);
        Assert.assertTrue(r.getTypeID() > 0);
        Assert.assertTrue(StringUtils.isNotBlank(r.getTypeName()));
        Assert.assertTrue(r.getSellOrders().size() > 0);
        marketOrderTest(r.getSellOrders().get(0));
    }

    private void marketOrderTest(final EveCentralOrder order) {
        //System.err.println(ToStringBuilder.reflectionToString(order, ToStringStyle.MULTI_LINE_STYLE));
        Assert.assertTrue(order.getOrderID() > 0);
        Assert.assertTrue(order.getPrice() > 0);
    }

}
