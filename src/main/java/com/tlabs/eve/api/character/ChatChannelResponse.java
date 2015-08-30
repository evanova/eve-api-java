package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.LinkedList;
import java.util.List;

public class ChatChannelResponse extends EveAPIResponse {

    private List<ChatChannel> channels = new LinkedList<>();

    public List<ChatChannel> getChannels() {
        return channels;
    }

    public void addChannel(final ChatChannel chatChannel) {
        this.channels.add(chatChannel);
    }
}
