/**
 * 
 */
package com.tlabs.eve.api.character;

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


import com.tlabs.eve.api.EveRequest;

/**@deprecated as of API keys V2*/
public final class CharacterListRequest extends EveRequest<CharacterListResponse> 
	implements com.tlabs.eve.api.EveRequest.Authenticated {
	
	private String keyID;
	private String key;
	
	public CharacterListRequest(String userID, String key) {
		super(CharacterListResponse.class, "/account/Characters.xml.aspx", 0);
		this.keyID = userID;
		putParam("userID", userID);
		
		this.key = key;
		putParam("apiKey", key);
	}

	@Override
	public String getKeyID() {
		return this.keyID;
	}

	@Override
	public String getKey() {
		return this.key;
	}

}
