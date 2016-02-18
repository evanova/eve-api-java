package com.tlabs.eve.api.mail;

import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class NotificationMessage extends Message {

    private static final long serialVersionUID = 2130540734211587597L;

    private int typeID = -1;

    private final Map<String, String> bodyAttributes = new HashMap<>();

    public final long getNotificationID() {
        return getMessageID();
    }

    public final void setNotificationID(long notificationID) {
       super.setMessageID(notificationID);
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
    public void setBody(String body) {
        super.setBody(body);
        this.bodyAttributes.clear();
        if (StringUtils.isBlank(getBody())) {
            return;
        }
        final String[] lines = StringUtils.split(getBody(), "\n");
        for (int i = 0; i < lines.length; i++) {
            String[] line = StringUtils.split(lines[i].trim(), ":");
            if (line.length == 2) {
                this.bodyAttributes.put(line[0].trim(), line[1].trim());
            }
        }
    }
}
