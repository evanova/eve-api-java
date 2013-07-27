package com.tlabs.eve.api.mail;

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



public class MailMessage extends EveMessage {

	private static final long serialVersionUID = 3521271683902916731L;
	 /*
	  * <rowset 
	  * name="messages" 
	  * key="messageID" 
	  * columns="messageID,senderID,sentDate,title,toCorpOrAllianceID,toCharacterIDs,toListID">
	  */

	private long messageID = -1;
	private String title = "";

	private long toListID = -1;
	private long toCorpOrAllianceID = -1;
	private String toCharsID = "";
	
	
	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}


	public final String getToCharacterIDs() {
		return toCharsID;
	}


	public final void setToCharacterIDs(String recipientsCSV) {
		this.toCharsID = recipientsCSV;
	}


	public final long getMessageID() {
		return messageID;
	}


	public final void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public final long getToListID() {
		return toListID;
	}


	public final void setToListID(long toListID) {
		this.toListID = toListID;
	}

	public final long getToCorpOrAllianceID() {
		return toCorpOrAllianceID;
	}


	public final void setToCorpOrAllianceID(long toCorpOrAllianceID) {
		this.toCorpOrAllianceID = toCorpOrAllianceID;
	}
}
