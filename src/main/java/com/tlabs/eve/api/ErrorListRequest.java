package com.tlabs.eve.api;



public final class ErrorListRequest extends EveAPIRequest<ErrorListResponse> {

    public ErrorListRequest() {
        super(ErrorListResponse.class, "/eve/ErrorList.xml.aspx", 0);
    }
}
