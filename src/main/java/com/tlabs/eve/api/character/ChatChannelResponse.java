package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIResponse;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ChatChannelResponse extends EveAPIResponse {

    @Getter
    @Setter
    private List<ChatChannel> channels;
}
