package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.StandingsResponse;



public class CorporationStandingsRequest extends CorporationRequest<StandingsResponse> {
    public static final int MASK = 262144;

    public CorporationStandingsRequest(String corpID) {
        super(StandingsResponse.class, "/corp/Standings.xml.aspx", MASK, corpID);
    }
}
