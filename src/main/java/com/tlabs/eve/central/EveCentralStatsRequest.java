package com.tlabs.eve.central;



//http://api.eve-central.com/api/marketstat?typeid=34&typeid=35&regionlimit=10000002
public class EveCentralStatsRequest extends EveCentralRequest<EveCentralStatsResponse> {

    private final long regionID;

    public EveCentralStatsRequest(final long[] types) {
        this(types, -1);
    }

    public EveCentralStatsRequest(final long[] types, long region) {
        super(EveCentralStatsResponse.class, "/api/marketstat");
        this.regionID = region;

        if (region > 0) {
            putParam("regionlimit", Long.toString(region));
        }

        String p = "";
        for (long id : types) {
            if (p.isEmpty()) {
                p = "" + id;
            }
            else {
                p = p + "&typeid=" + id;
            }
        }
        putParam("typeid", p);
    }

    public final long getRegionID() {
        return regionID;
    }
}
