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

public class AccountBalance extends Object implements Serializable {

	private static final long serialVersionUID = -5420167201513912042L;

	private long accountID;
	private long accountKey;
	
	private double balance;

	public long getAccountID() {
		return accountID;
	}
	
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public long getAccountKey() {
		return accountKey;
	}

	
	public void setAccountKey(long accountKey) {
		this.accountKey = accountKey;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
	
	public void setBalance(String balance) {
		this.balance = Double.parseDouble(balance);
	}
}
