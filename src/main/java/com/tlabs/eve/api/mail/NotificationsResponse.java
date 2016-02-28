package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public class NotificationsResponse extends EveAPIResponse {

    private List<NotificationMessage> messages = new ArrayList<>();

    public final List<NotificationMessage> getMessages() {
        return messages;
    }

    public final void addMessage(NotificationMessage m) {
        this.messages.add(m);
    }

}
