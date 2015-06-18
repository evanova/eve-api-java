package com.tlabs.eve.api.mail;


import com.tlabs.eve.api.mail.Contact.Group;
import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public final class ContactListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 1803692879940276962L;

    private final List<Group> contactGroups = new LinkedList<>();

    public final List<Group> getContactGroups() {
        return this.contactGroups;
    }

    public final void addGroup(final Group group) {
        this.contactGroups.add(group);
    }
}
