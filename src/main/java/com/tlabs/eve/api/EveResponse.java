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



public abstract class EveResponse extends Object {

	//Authentication failures
	private static final int INVALID_KEYS_MIN = 200;
	private static final int INVALID_KEYS_MAX = 299;
	//private static final int INVALID_KEYS[] = {108, 109,202,203,204,205,222};
/*
	      <row errorCode="200" errorText="Current security level not high enough." />
	      <row errorCode="201" errorText="Character does not belong to account." />
	      <row errorCode="202" errorText="API key authentication failure." />
	      <row errorCode="203" errorText="Authentication failure." />
	      <row errorCode="204" errorText="Authentication failure." />
	      <row errorCode="205" errorText="Authentication failure (final pass)." />*/
	
	private int errorCode = 0;	
	private String errorMessage = null;
	
	private long dateTime;
	private long cachedUntil;
	
	private byte[] content = null;
	

	public EveResponse() {
		super();
		long now = System.currentTimeMillis();;
		this.dateTime = now;
		this.cachedUntil = now;
	}
	
	/** Eve Time*/
	public final long getDateTime() {
		return dateTime;
	}

	/** Eve Time*/
	public final void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	/** Eve Time*/
	public final long getCachedUntil() {
		return cachedUntil;
	}
	
	/** Eve Time*/
	public final void setCachedUntil(long cachedUntil) {
		this.cachedUntil = cachedUntil;
	}
	
	public final byte[] getContent() {
		return content;
	}

	public final void setContent(byte[] content) {
		this.content = content;
	}		
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorString) {
		this.errorMessage = errorString;
	}

	public final void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public final int getErrorCode() {
		return errorCode;
	}
	
	public final boolean hasError() {
		return errorCode > 0;
	}
	
	public final boolean hasAuthenticationError() {
		return (errorCode >= INVALID_KEYS_MIN) && (errorCode <= INVALID_KEYS_MAX);
	}
	
}
