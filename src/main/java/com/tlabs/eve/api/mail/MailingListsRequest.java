package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.character.CharacterRequest;

///char/mailinglists.xml.aspx
public final class MailingListsRequest extends CharacterRequest<MailingListsResponse> {
    public static final int MASK = 1024;

    public MailingListsRequest(String characterID) {
        super(MailingListsResponse.class, "/char/mailinglists.xml.aspx", MASK, characterID);
    }
}
