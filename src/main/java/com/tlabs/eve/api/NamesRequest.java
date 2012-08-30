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




//This can actually query item names, ids, stations, etc.
//@see http://wiki.eve-id.net/APIv2_Eve_CharacterName_XML
//@see http://wiki.eve-id.net/APIv2_Eve_CharacterID_XML
public final class NamesRequest extends EveRequest<NamesResponse> {
	
	public NamesRequest(String[] names) {
		super(NamesResponse.class, "/eve/CharacterID.xml.aspx", 0);
		putParam("names", filter(names));//API rejects duplicates
	}
	
	public NamesRequest(long[] ids) {
		super(NamesResponse.class, "/eve/CharacterName.xml.aspx", 0);
		putParam("ids", filter(ids));//API rejects duplicates
	}

	public NamesRequest(Long[] ids) {
		super(NamesResponse.class, "/eve/CharacterName.xml.aspx", 0);
		putParam("ids", filter(ids));//API rejects duplicates
	}
	
}
