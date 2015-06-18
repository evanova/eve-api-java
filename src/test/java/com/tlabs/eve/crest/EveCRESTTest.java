package com.tlabs.eve.crest;



import com.tlabs.eve.HttpClientTest;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Map;

public abstract class EveCRESTTest extends HttpClientTest {

    public static final String URL = "http://public-crest.eveonline.com";
    private static final String PROPERTY_URL = "com.tlabs.eve.crest.url";

    protected final <T extends CRESTResponse> T apiCall(final CRESTRequest<T> r) throws IOException {
        final String url = System.getProperty(PROPERTY_URL, URL);

        T q = callCRESTAPI(url, r);
        if (q.getErrorCode() != 0) {
            throw new IllegalArgumentException("Eve CREST Error " + q.getErrorCode());
        }
        return q;
    }

    private <T extends CRESTResponse> T callCRESTAPI(final String url, final CRESTRequest<T> r) throws IOException {
        final StringBuilder burl = new StringBuilder();
        burl.append(url);
        burl.append(r.getPage());

        final Map<String, String> params = r.getParameters();
        for (String p : params.keySet()) {
            burl.append(params.get(p));
            burl.append("/");
        }

        String result = get(burl.toString());
        return CREST.parse(r, IOUtils.toInputStream(result));
    }

}
