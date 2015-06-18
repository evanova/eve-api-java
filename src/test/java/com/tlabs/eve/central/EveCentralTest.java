package com.tlabs.eve.central;



import com.tlabs.eve.HttpClientTest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EveCentralTest extends HttpClientTest {

    protected final <T extends EveCentralResponse> T apiCall(final EveCentralRequest<T> r) {
        T q = callEveCentralAPI(r);
        if (q.hasError()) {
            throw new IllegalArgumentException(q.getErrorMessage());
        }
        return q;
    }

    private <T extends EveCentralResponse> T callEveCentralAPI(final EveCentralRequest<T> r) {
        String url = "http://localhost:8080/central" + r.getPage();
        //String url = "http://api.eve-central.com" + r.getPage();

        final List<NameValuePair> nvps = new ArrayList<>();
        final Map<String, String> params = r.getParameters();
        for (String p : params.keySet()) {
            String v = params.get(p);
            if (StringUtils.isNotBlank(v)) {
                nvps.add(new BasicNameValuePair(p, params.get(p)));
            }
        }

        try {
            final String result = get(url, nvps);
            return EveCentral.parse(r, IOUtils.toInputStream(result));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
