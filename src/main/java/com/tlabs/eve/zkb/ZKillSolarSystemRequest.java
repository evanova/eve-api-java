package com.tlabs.eve.zkb;

public final class ZKillSolarSystemRequest extends ZKillRequest<ZKillResponse> {

    public ZKillSolarSystemRequest(final long solarSystemID) {
        this(solarSystemID, System.currentTimeMillis() - 3 * 3600 * 1000);
    }

    public ZKillSolarSystemRequest(final long solarSystemID, final long since) {
        super(ZKillResponse.class, "solarSystemID/" + solarSystemID + "/no-items/no-attackers/pastSeconds/" + past(since) + "/");
    }

    private static long past(final long since) {
        return System.currentTimeMillis() - since;
    }

}
