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



public final class AccountStatusRequest extends EveAPIRequest<AccountStatusResponse> implements EveAPIRequest.Authenticated {
	private String keyID;
	private String key;

	public AccountStatusRequest(String keyID, String key, boolean v1) {
		super(AccountStatusResponse.class, "/account/AccountStatus.xml.aspx", 33554432);

		this.keyID = keyID;		
		this.key = key;

		if (v1) {
			putParam("userID", keyID);
			putParam("apiKey", key);
		}
		else {
			putParam("keyID", keyID);
			putParam("vCode", key);
		}
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
