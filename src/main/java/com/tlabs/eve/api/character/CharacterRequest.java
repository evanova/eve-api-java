package com.tlabs.eve.api.character;

import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.api.EveAPIRequest.Authenticated;
import com.tlabs.eve.api.EveAPIResponse;

public abstract class CharacterRequest<T extends EveAPIResponse> extends EveAPIRequest<T> implements Authenticated {

    private String keyID = null;
    private String key = null;

    private long characterID;

    public CharacterRequest(Class<T> tea, String page, long mask, long characterID) {
        super(tea, page, mask);
        putParam("characterID", characterID);
        this.characterID = characterID;
    }

    public final long getCharacterID() {
        return characterID;
    }

    public final String getKeyID() {
        return keyID;
    }

    public final void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    public final String getKey() {
        return key;
    }

    public final void setKey(String key) {
        this.key = key;
    }

}
