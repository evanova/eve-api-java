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

public class JournalReferenceTypeResponse extends EveAPIResponse {

    private static final long serialVersionUID = -1423045891788417599L;

    private Map<Long, String> referenceTypes;//names by id
	
	public JournalReferenceTypeResponse() {
		super();
		this.referenceTypes = new HashMap<Long, String>();
	}
	
	public Map<Long, String> getReferences() {
		return this.referenceTypes;
	}
	
	public void addReference(Long id, String name) {
		this.referenceTypes.put(id, name);
	}
	
	
}
