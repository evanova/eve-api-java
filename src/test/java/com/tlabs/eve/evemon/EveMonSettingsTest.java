package com.tlabs.eve.evemon;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tlabs.eve.api.evemon.EveMonSettingsParser;
import com.tlabs.eve.api.evemon.EveMonSettingsResponse;

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
