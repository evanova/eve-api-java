package com.tlabs.eve.api.corporation;



public final class StarbaseDetailsRequest extends CorporationRequest<StarbaseDetailsResponse> {
    public static final long MASK = 131072;

    public StarbaseDetailsRequest(final long corporationID, final long itemID) {
        super(StarbaseDetailsResponse.class, "/corp/StarbaseDetail.xml.aspx", MASK, corporationID);
        putParam("itemID", itemID);
    }

}
