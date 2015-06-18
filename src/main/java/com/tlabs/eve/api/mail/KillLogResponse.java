package com.tlabs.eve.api.mail;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;



public final class KillLogResponse extends EveAPIResponse {

    private static final long serialVersionUID = -5581824066223953632L;

    private List<KillMail> killMails = new LinkedList<>();

    public List<KillMail> getKillMails() {
        return this.killMails;
    }

    public void addKill(final KillMail k) {
        this.killMails.add(k);
    }
}
