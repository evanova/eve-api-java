package com.tlabs.eve.api.character;

import com.tlabs.eve.EveTest;

import org.junit.Ignore;
import org.junit.Test;

public class ChatChannelRequestTest extends EveTest {

    @Test
    @Ignore(value = "you need API keys to run this test")
    public void testChatChannel() {
        final long characterID = getCharacter().getCharacters().get(0).getCharacterID();
        final ChatChannelResponse response = execute(new ChatChannelRequest(Long.toString(characterID)));
        System.out.println(response);
    }
}
