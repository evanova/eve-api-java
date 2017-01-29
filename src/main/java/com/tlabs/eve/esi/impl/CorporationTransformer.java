package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESICorporation;
import org.devfleet.esi.model.GetCorporationsCorporationIdAlliancehistory200Ok;
import org.devfleet.esi.model.GetCorporationsCorporationIdMembers200Ok;
import org.devfleet.esi.model.GetCorporationsCorporationIdOk;

final class CorporationTransformer {

    private CorporationTransformer() {}

    public static ESICorporation transform(final long corpID, final GetCorporationsCorporationIdOk c) {
        final ESICorporation corporation = new ESICorporation(corpID);

        return corporation;
    }

    public static ESICorporation.History transform(GetCorporationsCorporationIdAlliancehistory200Ok h) {
        final ESICorporation.History history = new ESICorporation.History();
        return history;
    }

    public static ESICorporation.Member transform(GetCorporationsCorporationIdMembers200Ok m) {
        final ESICorporation.Member member = new ESICorporation.Member();

        return member;
    }

}
