package com.tlabs.eve.api;

import org.junit.Assert;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class NamesRequestTest extends EveTest {

    @Test
    public void testNames() {
        final NamesResponse response1 = execute(new NamesRequest(new String[]{"Evanova Android"}));
        Assert.assertEquals(1, response1.getNames().size());
        Assert.assertEquals("Evanova Android", response1.getNames().values().iterator().next());

        final Long id = response1.getNames().keySet().iterator().next();

        final NamesResponse response2 = execute(new NamesRequest(new Long[]{id}));
        Assert.assertEquals(1, response2.getNames().size());
        Assert.assertEquals("Evanova Android", response2.getNames().values().iterator().next());
    }
}
