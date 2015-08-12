package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.List;

public class ChatChannelResponse extends EveAPIResponse {

    private List<ChatChannel> channels;

    public List<ChatChannel> getChannels() {
        return channels;
    }

    public void setChannels(List<ChatChannel> channels) {
        this.channels = channels;
    }
}
