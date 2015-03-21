package com.tlabs.eve.api.mail;

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

public class NotificationMessage extends Message {

    private static final long serialVersionUID = 2130540734211587597L;

    private long notificationID = -1;
    private int typeID = -1;

    private final Map<String, String> bodyAttributes = new HashMap<>();

    public final long getNotificationID() {
        return notificationID;
    }

    public final void setNotificationID(long notificationID) {
        this.notificationID = notificationID;
    }

    public final int getTypeID() {
        return typeID;
    }

    public final void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public final Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.bodyAttributes);
    }

    @Override
    protected void onBodyChanged(String body) {
        this.bodyAttributes.clear();
        if (StringUtils.isBlank(body)) {
            return;
        }
        final String[] lines = StringUtils.split(body, "\n");
        for (int i = 0; i < lines.length; i++) {
            String[] line = StringUtils.split(lines[i].trim(), ":");
            if (line.length == 2) {
                this.bodyAttributes.put(line[0].trim(), line[1].trim());
            }
        }
    }
}
