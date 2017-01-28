package com.tlabs.eve.api.character;

import com.tlabs.eve.api.StandingsResponse;



public class CharacterStandingsRequest extends CharacterRequest<StandingsResponse> {
    public static final long MASK = 524288;

    public CharacterStandingsRequest(long charID) {
        super(StandingsResponse.class, "/char/Standings.xml.aspx", MASK, charID);
    }
}
