package com.tlabs.eve.api;

import org.junit.Assert;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class ServerStatusTest extends EveTest {

    @Test
    public void testServerStatusRequest() {
        final ServerStatusResponse status = execute(new ServerStatusRequest());
        Assert.assertFalse(status.hasAuthenticationError());
    }
}
