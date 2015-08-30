package com.tlabs.eve.crest;

import com.tlabs.eve.EveTest;
import com.tlabs.eve.api.NamesRequest;
import com.tlabs.eve.api.NamesResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

public class AllianceRequestTest extends EveTest {

    @Test
    public void testAlliance() {
        final NamesResponse names = execute(new NamesRequest(new String[]{"Yuilai Federation"}));
        final long id = names.getNames().keySet().iterator().next();

        final AllianceResponse response = execute(new AllianceRequest(Long.toString(id)));
        Assert.assertNotNull(response);
        System.out.println(ToStringBuilder.reflectionToString(response));
    }
}
