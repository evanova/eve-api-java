package com.tlabs.eve.ccp;

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


import java.util.LinkedList;
import java.util.List;

import com.tlabs.eve.EveResponse;

public final class EveRSSResponse extends EveResponse {
		
    private List<EveRSSEntry> rssEntries = new LinkedList<EveRSSEntry>();
    private String title;
    private String link;
    
    private long dateUpdated;
    
    public EveRSSResponse() {
        super();
        setCachedUntil(System.currentTimeMillis() + 24l * 3600l * 1000l);
    }
    
    public final List<EveRSSEntry> getEntries() {
        return this.rssEntries;
    }
    
    public final void addEntry(final EveRSSEntry entry) {
        this.rssEntries.add(entry);
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
