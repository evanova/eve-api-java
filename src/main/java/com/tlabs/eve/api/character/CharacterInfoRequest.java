/**
 * 
 */
package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPIRequest.Public;

public final class CharacterInfoRequest extends CharacterRequest<CharacterInfoResponse> implements Public {
    public static final long MASK = 16777216;

    public CharacterInfoRequest(long charID) {
        super(CharacterInfoResponse.class, "/eve/CharacterInfo.xml.aspx", MASK, charID);
    }
}
