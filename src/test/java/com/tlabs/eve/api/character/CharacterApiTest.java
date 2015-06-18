package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveApiTest;

import org.junit.Before;

public abstract class CharacterApiTest extends EveApiTest {

    @Before
    public void onCharacterSetup() {
        setKeyID(characterKey.keyId);
        setKeyValue(characterKey.keyValue);
    }

}
