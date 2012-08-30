package com.tlabs.eve.api.corporation;

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


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.tlabs.eve.api.EveRequest;
import com.tlabs.eve.api.EveRequest.Authenticated;
import com.tlabs.eve.api.EveResponse;

public abstract class CorporationRequest<T extends EveResponse> extends EveRequest<T> implements Authenticated {
	
	private String keyID = null;
	private String key = null;
	
	private String corporationID;
	
	public CorporationRequest(Class<T> tea, String page, int mask, String corporationID) {
		super(tea, page, mask);
		
		Validate.isTrue(StringUtils.isNotBlank(corporationID), "corporationID");		
		
		putParam("corporationID", corporationID);
		this.corporationID = corporationID;
	}

	public final String getCorporationID() {
		return corporationID;
	}

	public final String getKeyID() {
		return keyID;
	}

	public final void setKeyID(String keyID) {
		this.keyID = keyID;
	}

	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}
	
}
