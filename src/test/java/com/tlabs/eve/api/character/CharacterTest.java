package com.tlabs.eve.api.character;



import junit.framework.Assert;

import org.junit.Test;

public final class CharacterTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testCharacterSheets() throws Exception {
        CharacterSheetResponse s1 = apiCall(new CharacterSheetRequest(characterKey.id));
        Assert.assertNotNull("Null character", s1.getCharacter());

        setKeyID(characterKey.keyId);
        setKeyValue(characterKey.keyValue);
        CharacterSheetResponse s2 = apiCall(new CharacterSheetRequest(characterKey.id));
        Assert.assertNotNull("Null character", s2.getCharacter());
    }

}
