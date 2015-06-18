package com.tlabs.eve.api;



public final class ServerStatusRequest extends EveAPIRequest<ServerStatusResponse> {

    public ServerStatusRequest() {
        super(ServerStatusResponse.class, "/server/ServerStatus.xml.aspx", 0);
    }
}
