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


import java.util.HashMap;
import java.util.Map;

public final class NamesResponse extends EveResponse {

	private Map<Long, String> names = new HashMap<Long, String>();
	private String key;
	
	public void add(long id, String name) {
		names.put(id, name);
	}
	
	public Map<Long, String> getNames() {
		return this.names;
	}

	public String getName(long id) {
		return this.names.get(id);
	}

	public final String getKey() {
		return key;
	}

	public final void setKey(String key) {
		this.key = key;
	}
	
	
}
