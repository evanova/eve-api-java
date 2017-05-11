package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import org.devfleet.esi.model.GetStatusOk;
import org.devfleet.esi.model.PostUniverseNames200Ok;

final class PublicTransformer {
    private PublicTransformer() {}

    public static ESIServerStatus transform(GetStatusOk object) {
        final ESIServerStatus status = new ESIServerStatus();
        status.setPlayers(object.getPlayers());
        status.setStartTime(object.getStartTime().getMillis());
        status.setVersion(object.getServerVersion());
        return status;
    }

    public static ESIName transform(PostUniverseNames200Ok object) {
        final ESIName name = new ESIName();
        name.setGroup(object.getCategory().toString());
        name.setId(object.getId());
        name.setName(object.getName());
        return name;
    }
}
