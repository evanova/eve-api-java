package com.tlabs.eve.crest;

public final class MarketHistoryRequest extends CRESTRequest<MarketHistoryResponse> {

    private final long regionID;
    private final long typeID;

    public MarketHistoryRequest(final long regionID, final long typeID) {
        ///market/<region_id>/types/<type_id>/history/
        super(MarketHistoryResponse.class, "/market/" + regionID + "/types/" + typeID + "/history/");
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
