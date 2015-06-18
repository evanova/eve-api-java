package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIResponse;

public final class CharacterInfoResponse extends EveAPIResponse {

    private static final long serialVersionUID = -1694114269772030170L;

    private CharacterInfo characterInfo;

    public CharacterInfo getCharacterInfo() {
        return characterInfo;
    }

    public void setCharacterInfo(CharacterInfo characterInfo) {
        this.characterInfo = characterInfo;
    }

}
