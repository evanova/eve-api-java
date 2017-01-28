package com.tlabs.eve.api.character;



public class CharacterResearchRequest extends CharacterRequest<CharacterResearchResponse> {
    public static final long MASK = 65536;

    public CharacterResearchRequest(long charID) {
        super(CharacterResearchResponse.class, "/char/Research.xml.aspx", MASK, charID);
    }
}
