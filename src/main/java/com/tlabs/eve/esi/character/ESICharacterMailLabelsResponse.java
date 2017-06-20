package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESIMailbox;

import java.util.List;

public final class ESICharacterMailLabelsResponse extends ESICharacterResponse {

    private List<ESIMailbox> mailboxes;

    public ESICharacterMailLabelsResponse() {
        setCachedUntil(EveTime.now() + 30L * 1000L);
    }

    public List<ESIMailbox> getMailboxes() {
        return mailboxes;
    }

    public void setMailboxes(List<ESIMailbox> mailboxes) {
        this.mailboxes = mailboxes;
    }
}
