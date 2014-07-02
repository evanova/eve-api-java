package com.tlabs.eve.map;

import com.tlabs.eve.EveRequest;

public final class DotlanRouteRequest extends EveRequest<DotlanRouteResponse> {

    public DotlanRouteRequest(final String fromSolarSystemName, final String toSolarSystemName, final String type) {
        super(DotlanRouteResponse.class, "/route/" + type + ":" + fromSolarSystemName + ":" + toSolarSystemName);
    }
}
