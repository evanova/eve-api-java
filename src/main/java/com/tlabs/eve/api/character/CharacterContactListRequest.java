package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveContactListResponse;

public final class CharacterContactListRequest extends CharacterRequest<EveContactListResponse> {
    public static final int MASK = 16;
    
    public CharacterContactListRequest(final String characterID) {
        super(EveContactListResponse.class, "/char/ContactList.xml.aspx", MASK, characterID);        
    }
}
