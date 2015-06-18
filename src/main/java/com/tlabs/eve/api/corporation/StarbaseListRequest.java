package com.tlabs.eve.api.corporation;



public final class StarbaseListRequest extends CorporationRequest<StarbaseListResponse> {
    public static final int MASK = 524288;

    public StarbaseListRequest(String corporationID) {
        super(StarbaseListResponse.class, "/corp/StarbaseList.xml.aspx", MASK, corporationID);
    }

}
