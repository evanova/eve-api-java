package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class MailBodiesResponse extends EveAPIResponse {

    private List<MailMessage> messages = new LinkedList<>();

    public final List<MailMessage> getMessages() {
        return messages;
    }

    public final void addMessage(MailMessage m) {
        this.messages.add(m);
    }

}
