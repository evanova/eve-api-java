package com.tlabs.eve.api;

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


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.tlabs.eve.HttpClientTest;

public abstract class EveApiTest extends HttpClientTest {
	
	//public static final String URL = "http://localhost:8080/test";
	public static final String URL = "http://apitest.eveonline.com";

	private String keyID;
	private String keyValue;
	
	protected final void setKeyID(String keyID) {
		this.keyID = keyID;
	}

	protected final void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	
	protected final <T extends EveResponse> T apiCall(final EveRequest<T> r) {
		T q = callEveAPI(r);
		if (q.getErrorCode() != 0) {
			throw new IllegalArgumentException("Eve API Error " + q.getErrorCode());
		}
		return q;
	}
		
	private final <T extends EveResponse> T callEveAPI(final EveRequest<T> r) {
		final List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		
		if (r instanceof EveRequest.Authenticated) {
			EveRequest.Authenticated auth = (EveRequest.Authenticated)r;
			if (StringUtils.isBlank(auth.getKeyID())) {
				nvps.add(new BasicNameValuePair("keyID", this.keyID));
			}
			else {
				nvps.add(new BasicNameValuePair("keyID", auth.getKeyID()));
			}
			if (StringUtils.isBlank(auth.getKey())) {
				nvps.add(new BasicNameValuePair("vCode", this.keyValue));
			}
			else {
				nvps.add(new BasicNameValuePair("vCode", auth.getKey()));
			}
		}
		
		final Map<String, String> params = r.getParameters();		
		for (String p: params.keySet()) {
			if (!"vCode".equalsIgnoreCase(p) && !"keyID".equalsIgnoreCase(p)) {
				String v = params.get(p);
				if (StringUtils.isNotBlank(v)) {
					nvps.add(new BasicNameValuePair(p, params.get(p)));						
				}
			}
		}
		
		String result = post(URL + r.getPage(), nvps);		
		try {
			return EveAPI.parse(r, new StringReader(result));		
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}	
}
