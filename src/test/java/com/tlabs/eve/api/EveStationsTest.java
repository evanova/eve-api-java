package com.tlabs.eve.api;



import org.junit.Assert;
import org.junit.Test;

public class EveStationsTest extends EveApiTest {

    @Test(timeout = 10000)
    public void testEveStationsParser() throws Exception {
        StationsResponse r = apiCall(new StationsRequest());

        Assert.assertTrue("No station parsed (size=0)", r.getStations().size() > 0);
    }
}
