package com.tlabs.eve.api;

public class ServerStationsRequest extends EveRequest<ServerStationsResponse> {

    public ServerStationsRequest() {
        super(ServerStationsResponse.class, "/eve/ConquerableStationList.xml.aspx", 0);
    }

}
