package com.tlabs.eve.api.corporation;



public final class MemberTrackingRequest extends CorporationRequest<MemberTrackingResponse> {
    public static final int MASK = 2048;

    public MemberTrackingRequest(String corporationID, boolean extended) {
        super(MemberTrackingResponse.class, "/corp/MemberTracking.xml.aspx", MASK, corporationID);
        putParam("extended", (extended) ? "1" : "0");
    }

}
