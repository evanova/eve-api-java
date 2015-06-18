/**
 * 
 */
package com.tlabs.eve.api.character;



public final class CharacterTrainingRequest extends CharacterRequest<CharacterTrainingResponse> {
    public static final int MASK = 131072;

    public CharacterTrainingRequest(String charID) {
        super(CharacterTrainingResponse.class, "/char/SkillInTraining.xml.aspx", MASK, charID);
    }

}
