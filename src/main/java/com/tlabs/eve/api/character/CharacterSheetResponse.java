package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIResponse;

public final class CharacterSheetResponse extends EveAPIResponse {

    private static final long serialVersionUID = 2952044155669731849L;

    private CharacterSheet character;

    public CharacterSheet getCharacter() {
        return character;
    }

    public void setCharacter(CharacterSheet character) {
        this.character = character;
    }

}
