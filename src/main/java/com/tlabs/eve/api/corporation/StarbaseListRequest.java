package com.tlabs.eve.api.corporation;



public final class StarbaseListRequest extends CorporationRequest<StarbaseListResponse> {
    public static final long MASK = 524288;

    public StarbaseListRequest(long corporationID) {
        super(StarbaseListResponse.class, "/corp/StarbaseList.xml.aspx", MASK, corporationID);
    }

}
