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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tlabs.eve.api.EveAPI;

public class EveMessage extends Object implements Serializable {
    
    private static final long serialVersionUID = 4815557437352503649L;
    
    private long senderID = -1;
	private String senderName = "";//not in XML
	
	private long sentDate = 0;
	private boolean read;

	private String body = null;//supposedly a CDATA block 
	private final Map<String, Long> bodyAttributes = new HashMap<String, Long>();
	private final Map<Long, Long> wants = new HashMap<Long, Long>();//types ID->Qty
	
	protected EveMessage() {
	    
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

	public final boolean isRead() {
		return read;
	}

	public final void setRead(boolean read) {
		this.read = read;
	}

	public final String getBody() {
		return body;
	}

	public final void setBody(String body) {
		if (StringUtils.isBlank(body)) {
			this.wants.clear();
			this.bodyAttributes.clear();
			this.body = "";
			return;
		}
		
		String b = StringUtils.removeEnd(
						StringUtils.removeStart(body.trim(), "<![CDATA[").trim(),
						"]]>").trim();
		b = StringUtils.remove(b, "{}");
		this.body = b;
		parseBodyContent(b);
	}

	public final void setSentDate(long sentDate) {
		this.sentDate = sentDate;
	}

	public final long getSentDate() {
		return sentDate;
	}

	public final void setSentDate(String d) {
		sentDate = EveAPI.parseDateTime(d);
	}
	
	private void parseBodyContent(final String b) {
		this.wants.clear();
		this.bodyAttributes.clear();
		
		BufferedReader r = new BufferedReader(new StringReader(b));
		String line = null;
		boolean wanted = false;
		Long quantity = null;
		
		try {
			while ((line = r.readLine()) != null) {
				line = line.trim();
				if (line.length() == 0) {
					continue;
				}
				if (line.startsWith("wants:")) {
					wanted = true;
					continue;
				}
				if (line.startsWith("- quantity:")) {
					//quantity (type Id not know yet)
					quantity = longOf(StringUtils.substringAfter(line, "- quantity:"));
					continue;
				}
				if (line.startsWith("typeID:")) {
					Long tid = longOf(StringUtils.substringAfter(line, "typeID:"));
					if (wanted) {
						this.wants.put(tid, (null == quantity) ? 0L : quantity);
						quantity = 0L;
					}
					else {
						this.bodyAttributes.put("typeID", tid);
					}
					continue;
				}
				if (!wanted) {
					String[] split = StringUtils.split(line, ":");
					if (split.length == 2) {
						this.bodyAttributes.put(split[0], longOf(split[1]));
					}
				}
			}
		}
		catch (IOException e) {
			//This should not happen
		}
		finally {
			try {
				r.close();
			}
			catch (IOException uh) {
				
			}
		}
	}
	
	private static final Long longOf(String s) {
		if (StringUtils.isBlank(s)) {
			return null;
		}
		try {
			return Long.parseLong(s.trim());
		}
		catch (NumberFormatException e) {
			return null;
		}
	}
}
