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


import java.util.LinkedList;
import java.util.List;

import com.tlabs.eve.api.character.EveCharacter;

/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfoResponse extends EveAPIResponse {
	
	public static final int UNKNOWN = -1;
	public static final int CHARACTER = 0;
	public static final int CORPORATION = 1;
	public static final int ACCOUNT = 2;
	
	private int accessMask = 0;
	
	private int type = UNKNOWN;
	
	private long expires = 0;
	private long keyID = -1;
	
	private List<EveCharacter> characters = new LinkedList<EveCharacter>();
	
	public AccessInfoResponse() {
		super();
	}
	
	public final int getAccessMask() {
		return accessMask;
	}

	public final void setAccessMask(int accessMask) {
		this.accessMask = accessMask;
	}

	public final int getType() {
		return type;
	}

	public final void setType(String type) {
		if ("Account".equalsIgnoreCase(type)) {
			this.type = ACCOUNT;
			return;
		}
		if ("Character".equalsIgnoreCase(type)) {
			this.type = CHARACTER;
			return;
		}
		if ("Corporation".equalsIgnoreCase(type)) {
			this.type = CORPORATION;
			return;
		}
		
		this.type = UNKNOWN;
	}

	public final long getExpires() {
		return expires;
	}

	public final void setExpires(long expires) {
		this.expires = expires;
	}
	
	public final void setExpires(String expires) {
		this.expires = EveAPI.parseDateTime(expires);
	}
	
	public final long getKeyID() {
		return keyID;
	}

	public final void setKeyID(long keyID) {
		this.keyID = keyID;
	}

	public void addCharacter(EveCharacter c) {
		this.characters.add(c);
	}
	
	public List<EveCharacter> getCharacters() {
		return this.characters;
	}	
}
