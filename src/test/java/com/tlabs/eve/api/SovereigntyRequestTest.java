package com.tlabs.eve.api;

import org.junit.Assert;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class SovereigntyRequestTest extends EveTest {

    @Test
    public void testSovereigntyRequest() {
        final SovereigntyResponse response = execute(new SovereigntyRequest());
        Assert.assertFalse(response.getSovereignty().isEmpty());
    }
}
