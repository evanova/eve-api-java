package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.EveContactListResponse;

public final class CorporationContactListRequest extends CorporationRequest<EveContactListResponse> {
    public static final int MASK = 16;
    public CorporationContactListRequest(final String corporationID) {
        super(EveContactListResponse.class, "/corp/ContactList.xml.aspx", MASK, corporationID);        
    }
}
