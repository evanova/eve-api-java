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
import java.util.LinkedList;
import java.util.List;

public class CallGroup implements Serializable {

    private static final long serialVersionUID = -1224708978395100947L;

    private int groupID;
    private String name;
    private String description;

    private List<CallEntry> entries = new LinkedList<>();

    public final int getGroupID() {
        return groupID;
    }

    public final void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final List<CallEntry> getEntries() {
        return entries;
    }

    public final void addEntry(CallEntry entry) {
        this.entries.add(entry);
    }
}
