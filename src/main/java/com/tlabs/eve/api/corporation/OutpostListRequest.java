package com.tlabs.eve.api.corporation;



public final class OutpostListRequest extends CorporationRequest<OutpostListResponse> {
    public static final int MASK = 16384;

    public OutpostListRequest(String corporationID) {
        super(OutpostListResponse.class, "/corp/OutpostList.xml.aspx", MASK, corporationID);
    }

}
