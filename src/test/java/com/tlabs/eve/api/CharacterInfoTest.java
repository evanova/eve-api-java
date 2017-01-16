package com.tlabs.eve.api;

import com.tlabs.eve.EveTest;
import com.tlabs.eve.api.character.CharacterInfo;
import com.tlabs.eve.api.character.CharacterInfoRequest;
import org.junit.Assert;
import org.junit.Test;

public class CharacterInfoTest extends EveTest {

    @Test
    public void testCharacterInfo() {
        final CharacterInfo info = execute(new CharacterInfoRequest("90808929")).getCharacterInfo();
        Assert.assertNotNull(info);
        Assert.assertEquals("Evanova Android", info.getCharacterName());
        Assert.assertEquals("Traquenard Labs", info.getCorporationName());
    }
}
