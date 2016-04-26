package com.tlabs.eve.api;


/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfoResponse extends EveAPIResponse {

    private static final long serialVersionUID = -4592852922232440448L;

    private final AccessInfo accessInfo;

    public AccessInfoResponse() {
        super();
        this.accessInfo = new AccessInfo();
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

}
