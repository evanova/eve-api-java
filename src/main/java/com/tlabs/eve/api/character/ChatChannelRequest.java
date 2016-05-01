package com.tlabs.eve.api.character;
//https://developers.eveonline.com/blog/article/chat-channel-info-available-in-xml-api
public class ChatChannelRequest extends CharacterRequest<ChatChannelResponse> {
    public static final long MASK = 536870912;

    public ChatChannelRequest(String charID) {
        super(ChatChannelResponse.class, "/char/ChatChannels.xml.aspx", MASK, charID);
    }
}
