package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.character.CharacterRequest;

///char/mailinglists.xml.aspx
public final class MailingListsRequest extends CharacterRequest<MailingListsResponse> {
    public static final long MASK = 1024;

    public MailingListsRequest(long characterID) {
        super(MailingListsResponse.class, "/char/mailinglists.xml.aspx", MASK, characterID);
    }
}
