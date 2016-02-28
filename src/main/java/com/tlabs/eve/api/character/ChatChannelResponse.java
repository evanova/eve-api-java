package com.tlabs.eve.api.character;

import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.api.EveAPIResponse;

public class ChatChannelResponse extends EveAPIResponse {

    private List<ChatChannel> channels = new ArrayList<>();

    public List<ChatChannel> getChannels() {
        return channels;
    }

    public void addChannel(final ChatChannel chatChannel) {
        this.channels.add(chatChannel);
    }
}
