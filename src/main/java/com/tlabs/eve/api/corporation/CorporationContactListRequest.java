package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.mail.ContactListResponse;

public final class CorporationContactListRequest extends CorporationRequest<ContactListResponse> {
    public static final long MASK = 16;

    public CorporationContactListRequest(final String corporationID) {
        super(ContactListResponse.class, "/corp/ContactList.xml.aspx", MASK, corporationID);
    }
}
