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


import com.tlabs.eve.api.ImageRequest;

public final class PortraitRequest extends ImageRequest<PortraitResponse> {
	public enum Size {
		S64("64"), S128("128"), S256("256"), S512("512");
		
		private String value;
		
		private Size(String value) {
			this.value = value;
		}
		
		public String getSize() {
			return this.value;
		}
	}
	
	private static final String URL = "/Character/%1$s_%2$s.jpg";
	
	private PortraitRequest.Size size;
	private String characterID;
	
	public PortraitRequest(String characterID) {
		this(characterID, PortraitRequest.Size.S512);
	}
	
	public PortraitRequest(String characterID, PortraitRequest.Size size) {
		super(PortraitResponse.class, String.format(URL, characterID, size.getSize()));		
		this.size = size;
		this.characterID = characterID;
	}

	public PortraitRequest.Size getSize() {
		return size;
	}

	public final String getCharacterID() {
		return characterID;
	}

}
