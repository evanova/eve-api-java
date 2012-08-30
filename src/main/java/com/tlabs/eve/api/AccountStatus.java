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


import java.io.Serializable;


public class AccountStatus extends Object implements Serializable {
		
	private static final long serialVersionUID = -1731735135378886230L;
	
	private long userID;
	private long creationDate;
	private long paidUntil;
	
	private int logonCount;
	private long logonMinutes;
	
	public long getUserID() {
		return userID;
	}
	
	public void setUserID(long userID) {
		this.userID = userID;
	}
	
	public long getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}
	
	public long getPaidUntil() {
		return paidUntil;
	}
	
	public void setPaidUntil(long paidUntil) {
		this.paidUntil = paidUntil;
	}
		
	public int getLogonCount() {
		return logonCount;
	}
	
	public void setLogonCount(int logonCount) {
		this.logonCount = logonCount;
	}
	
	
	public long getLogonMinutes() {
		return logonMinutes;
	}
	
	public void setLogonMinutes(long logonMinutes) {
		this.logonMinutes = logonMinutes;
	}
	
}
