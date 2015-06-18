package com.tlabs.eve.api.character;



public class CharacterResearchRequest extends CharacterRequest<CharacterResearchResponse> {
    public static final int MASK = 65536;

    public CharacterResearchRequest(String charID) {
        super(CharacterResearchResponse.class, "/char/Research.xml.aspx", MASK, charID);
    }
}
