package com.tlabs.eve.central;



//http://api.eve-central.com/api/marketstat?typeid=34&typeid=35&regionlimit=10000002
public class EveCentralQuickLookRequest extends EveCentralRequest<EveCentralQuickLookResponse> {

    public EveCentralQuickLookRequest(final long typeID) {
        this(typeID, -1);
    }

    public EveCentralQuickLookRequest(final long typeID, long regionID) {
        super(EveCentralQuickLookResponse.class, "/api/quicklook");
        putParam("typeid", Long.toString(typeID));

        if (regionID != -1) {
            putParam("regionlimit", Long.toString(regionID));
        }
    }
}
