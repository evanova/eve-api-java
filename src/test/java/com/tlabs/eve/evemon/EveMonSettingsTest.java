package com.tlabs.eve.evemon;

import com.tlabs.eve.api.evemon.EveMonSettingsParser;
import com.tlabs.eve.api.evemon.EveMonSettingsResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class EveMonSettingsTest {

    private EveMonSettingsParser parser;

    @Before
    public void setup() {
        this.parser = new EveMonSettingsParser();
    }

    @Test
    public void testEveMonSettings() throws Exception {
        final InputStream in = getClass().getResourceAsStream("/evemon-settings.xml");
        final EveMonSettingsResponse r = parser.parse(in);
        Assert.assertEquals("Invalid number of API keys.", 2, r.getApiKeys().size());
        in.close();
    }
}
