package com.tlabs.eve.esi;

public class ESIMarketStatisticsRequest extends ESIRequest<ESIMarketStatisticsResponse> implements ESIRequest.Public {

    private final long regionID;
    private final long typeID;

    public ESIMarketStatisticsRequest(final long regionID, final long typeID) {
        super(ESIMarketStatisticsResponse.class, "publicData");
        this.regionID = regionID;
        this.typeID = typeID;
    }

    public long getRegionID() {
        return regionID;
    }

    public long getTypeID() {
        return typeID;
    }
}
