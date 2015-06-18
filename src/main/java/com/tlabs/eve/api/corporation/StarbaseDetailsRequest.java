package com.tlabs.eve.api.corporation;



public final class StarbaseDetailsRequest extends CorporationRequest<StarbaseDetailsResponse> {
    public static final int MASK = 131072;

    public StarbaseDetailsRequest(final String corporationID, final String itemID) {
        super(StarbaseDetailsResponse.class, "/corp/StarbaseDetail.xml.aspx", MASK, corporationID);
        putParam("itemID", itemID);
    }

}
