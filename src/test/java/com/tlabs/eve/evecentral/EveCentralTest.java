package com.tlabs.eve.evecentral;

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


import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tlabs.eve.HttpClientTest;

public class EveCentralTest extends HttpClientTest {

	protected final <T extends EveCentralResponse> T apiCall(final EveCentralRequest<T> r) {
		T q = callEveCentralAPI(r);
		if (q.hasError()) {
			throw new IllegalArgumentException(q.getErrorMessage());
		}
		return q;
	}
		
	private final <T extends EveCentralResponse> T callEveCentralAPI(final EveCentralRequest<T> r) {
		String url = "http://localhost:8080/central" + r.getPage();
	    //String url = "http://api.eve-central.com" + r.getPage();
		
		final List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		final Map<String, String> params = r.getParameters();		
		for (String p: params.keySet()) {
			String v = params.get(p);
			if (StringUtils.isNotBlank(v)) {
				nvps.add(new BasicNameValuePair(p, params.get(p)));						
			}
		}
		
		final String result = get(url, nvps);
		try {
		    if (null == result) {
		        throw new RuntimeException("Invalid result: null");
		    }
			return 			       
				EveCentralAPI.parse(r, new StringReader(result));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	
}
