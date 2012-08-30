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


import com.tlabs.eve.api.ImageRequest;

public final class CorporationLogoRequest extends ImageRequest<CorporationLogoResponse> {
	public enum Size {
		S64("64"), S256("256");
		
		private String value;
		
		private Size(String value) {
			this.value = value;
		}
		
		public String getSize() {
			return this.value;
		}
	}
	
	private static final String URL = "/Corporation/%1$s_%2$s.png";
	
	private CorporationLogoRequest.Size size;
	private String corporationID;
	
	public CorporationLogoRequest(String corpID) {
		this(corpID, Size.S256);
	}
	
	public CorporationLogoRequest(String corpID, CorporationLogoRequest.Size size) {
		super(CorporationLogoResponse.class, String.format(URL, corpID, size.getSize()));
		this.corporationID = corpID;
		this.size = size;
	}

	public CorporationLogoRequest.Size getSize() {
		return size;
	}

	public final String getCorporationID() {
		return corporationID;
	}
	
}
