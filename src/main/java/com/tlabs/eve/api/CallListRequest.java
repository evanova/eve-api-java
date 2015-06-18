package com.tlabs.eve.api;



/** @since Eve API V3 (30 Aug 2011*/
public final class CallListRequest extends EveAPIRequest<CallListResponse> {

    public CallListRequest() {
        super(CallListResponse.class, "/api/calllist.xml.aspx", 0);
    }

}
