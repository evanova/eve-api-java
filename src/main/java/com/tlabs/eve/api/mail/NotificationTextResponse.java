package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class NotificationTextResponse extends EveAPIResponse {

    private List<NotificationMessage> messages = new LinkedList<>();

    public final List<NotificationMessage> getMessages() {
        return messages;
    }

    public final void addMessage(NotificationMessage m) {
        this.messages.add(m);
    }

}
