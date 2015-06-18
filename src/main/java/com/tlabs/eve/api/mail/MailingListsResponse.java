package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class MailingListsResponse extends EveAPIResponse {

    private List<MailingList> mailingLists = new LinkedList<>();

    public final List<MailingList> getMailingLists() {
        return mailingLists;
    }

    public final void addMailingList(MailingList m) {
        this.mailingLists.add(m);
    }

}
