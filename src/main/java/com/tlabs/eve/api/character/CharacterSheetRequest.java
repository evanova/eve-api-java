/**
 * 
 */
package com.tlabs.eve.api.character;



public final class CharacterSheetRequest extends CharacterRequest<CharacterSheetResponse> {
    public static final int MASK = 8;

    public CharacterSheetRequest(String charID) {
        super(CharacterSheetResponse.class, "/char/CharacterSheet.xml.aspx", MASK, charID);
    }

}
