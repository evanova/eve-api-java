package com.tlabs.eve.api;

import java.util.LinkedList;
import java.util.List;

public final class EveContactListResponse extends EveAPIResponse {
    
    private final List<EveContact.Group> contactGroups = new LinkedList<EveContact.Group>();
    
    public final List<EveContact.Group> getContactGroups() {
        return this.contactGroups;
    }

    public final void addGroup(final EveContact.Group group) {
        this.contactGroups.add(group);
    }
}
