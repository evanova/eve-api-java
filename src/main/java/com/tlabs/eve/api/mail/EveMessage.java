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


import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.tlabs.eve.api.EveAPI;

public class EveMessage extends Object implements Serializable {
    
    private static final long serialVersionUID = 4815557437352503649L;
    
    private long senderID = -1;
	private String senderName = "";
	
	private long sentDate = 0;
	private boolean read;

	private String body = null;//supposedly a CDATA block 
	private String title = "";

	protected EveMessage() {
	    
	}
    
    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }


	public final long getSenderID() {
		return senderID;
	}

	public final String getSenderName() {
		return senderName;
	}

	public final void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public final void setSenderID(long senderID) {
		this.senderID = senderID;
	}

	public final String getBody() {
		return body;
	}

	public final void setBody(String body) {
		if (StringUtils.isBlank(body)) {
			this.body = "";			
		}
		else {
		    String b = StringUtils.removeEnd(
		            StringUtils.removeStart(body.trim(), "<![CDATA[").trim(),
		            "]]>").trim();
		    b = StringUtils.remove(b, "{}");
		    this.body = b;
		}		
		
		onBodyChanged(this.body);
	}

	protected void onBodyChanged(final String body){}
	
	public final void setSentDate(long sentDate) {
		this.sentDate = sentDate;
	}

	public final long getSentDate() {
		return sentDate;
	}

	public final void setSentDate(String d) {
		sentDate = EveAPI.parseDateTime(d);
	}	
}
