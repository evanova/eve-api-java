package com.tlabs.eve.crest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;

public class AllianceTest extends EveCRESTTest {

    @Test
    public void testParseAlliances() throws Exception {
        final AllianceRequest request = new AllianceRequest();
        final AllianceResponse response = apiCall(request);
        System.out.println(ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
        
        for (Object o: response.getAlliances()) {
            System.out.println(ToStringBuilder.reflectionToString(o));
        }
    }
    
    @Test
    public void testParseOneAlliance() throws Exception {
        final AllianceRequest request = new AllianceRequest("99000006");
        final AllianceResponse response = apiCall(request);
        System.out.println(ToStringBuilder.reflectionToString(response, ToStringStyle.MULTI_LINE_STYLE));
        
        for (Object o: response.getAlliances()) {
            System.out.println(ToStringBuilder.reflectionToString(o));
        }
    }
}
