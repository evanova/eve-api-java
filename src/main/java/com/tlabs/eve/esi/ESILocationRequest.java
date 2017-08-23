package com.tlabs.eve.esi;

public class ESILocationRequest extends ESIRequest<ESILocationResponse> implements ESIRequest.Public {

    public static class StationRequest extends ESILocationRequest {
        public StationRequest(long locationID) {
            super(locationID);
        }
    }

    public static class SolarSystemRequest extends ESILocationRequest {
        public SolarSystemRequest(long locationID) {
            super(locationID);
        }
    }

    private final long locationID;

    protected ESILocationRequest(final long locationID) {
        super(ESILocationResponse.class, "publicData");
        this.locationID = locationID;
    }

    public long getLocationID() {
        return locationID;
    }
}
