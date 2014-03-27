package com.tlabs.eve.crest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

public class IncursionTest extends EveCRESTTest {

    @Test
    public void testParseIncursions() throws Exception {
        final IncursionRequest request = new IncursionRequest();
        final IncursionResponse response = apiCall(request);
        System.out.println(ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
        
        for (Object o: response.getItems()) {
            System.out.println(ToStringBuilder.reflectionToString(o));
        }
    }
}
