package com.tlabs.eve.api.corporation;



public final class OutpostDetailsRequest extends CorporationRequest<OutpostDetailsResponse> {
    public static final long MASK = 32768;

    public OutpostDetailsRequest(final String corporationID, final String itemID) {
        super(OutpostDetailsResponse.class, "/corp/OutpostServiceDetail.xml.aspx", MASK, corporationID);
        putParam("itemID", itemID);
    }

}
