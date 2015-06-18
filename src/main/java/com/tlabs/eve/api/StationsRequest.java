package com.tlabs.eve.api;

public class StationsRequest extends EveAPIRequest<StationsResponse> {

    public StationsRequest() {
        super(StationsResponse.class, "/eve/ConquerableStationList.xml.aspx", 0);
    }

}
