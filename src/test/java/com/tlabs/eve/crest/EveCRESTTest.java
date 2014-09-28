package com.tlabs.eve.crest;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
        final StringBuffer burl = new StringBuffer();
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
