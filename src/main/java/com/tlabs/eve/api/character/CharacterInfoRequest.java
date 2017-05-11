/**
 * 
 */
package com.tlabs.eve.api.character;


public final class CharacterInfoRequest extends CharacterRequest<CharacterInfoResponse> {
    public static final long MASK = 16777216;

    public CharacterInfoRequest(long charID) {
        super(CharacterInfoResponse.class, "/eve/CharacterInfo.xml.aspx", MASK, charID);
    }
}
