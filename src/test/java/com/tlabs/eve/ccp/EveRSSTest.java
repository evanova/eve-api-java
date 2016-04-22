package com.tlabs.eve.ccp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import com.tlabs.eve.EveTest;

public class EveRSSTest extends EveTest {

    @Test
    public void testRSS() {
        final EveRSSResponse r = execute(new EveRSSRequest());
        System.err.println(r.getTitle());
        for (EveRSSEntry e: r.getEntries()) {
            System.err.println(ToStringBuilder.reflectionToString(e));
        }
    }
}
