package com.tlabs.eve.crest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

public class MarketHistoryTest extends EveCRESTTest {

    @Test
    public void testParseHistory() throws Exception {
        final MarketHistoryRequest request = new MarketHistoryRequest(10000041l, 587l);
        final MarketHistoryResponse response = apiCall(request);

        for (Object o : response.getHistory()) {
            System.out.println(ToStringBuilder.reflectionToString(o));
        }
    }

}
