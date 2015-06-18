package com.tlabs.eve.api.character;



public class CharacterTrainingQueueRequest extends CharacterRequest<CharacterTrainingQueueResponse> {
    public static final int MASK = 262144;

    public CharacterTrainingQueueRequest(String charID) {
        super(CharacterTrainingQueueResponse.class, "/char/SkillQueue.xml.aspx", MASK, charID);
    }

}
