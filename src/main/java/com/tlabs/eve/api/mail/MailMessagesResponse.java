package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public class MailMessagesResponse extends EveAPIResponse {

    private List<MailMessage> messages = new ArrayList<>();

    public final List<MailMessage> getMessages() {
        return messages;
    }

    public final void addMessage(MailMessage m) {
        this.messages.add(m);
    }

}
