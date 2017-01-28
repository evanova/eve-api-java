package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.character.CharacterRequest;

//char/MailBodies.xml.aspx
public final class MailBodiesRequest extends CharacterRequest<MailBodiesResponse> {
    public static final long MASK = 512;
    private long[] messageIds;

    public MailBodiesRequest(long characterID, long[] messageIds) {
        super(MailBodiesResponse.class, "/char/MailBodies.xml.aspx", MASK, characterID);
        //Validate.isTrue(ArrayUtils.isNotEmpty(messageIds), "messages");

        this.messageIds = messageIds;
        putParam("ids", messageIds);
    }

    public long[] getMessages() {
        return this.messageIds;
    }

}
