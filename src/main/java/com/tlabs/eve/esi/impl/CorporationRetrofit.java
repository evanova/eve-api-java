package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESICorporation;
import org.devfleet.esi.api.CorporationApi;
import org.devfleet.esi.model.GetCorporationsCorporationIdAlliancehistory200Ok;
import org.devfleet.esi.model.GetCorporationsCorporationIdIconsOk;
import org.devfleet.esi.model.GetCorporationsCorporationIdMembers200Ok;
import org.devfleet.esi.model.GetCorporationsCorporationIdOk;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class CorporationRetrofit {

    private final CorporationApi corporationApi;

    private final String datasource;

    public CorporationRetrofit(final Retrofit rf, final String datasource) {
        this.corporationApi = rf.create(CorporationApi.class);
        this.datasource = datasource;
    }

    public ESICorporation getCorporation(Long corpID) throws IOException {
        final Response<GetCorporationsCorporationIdOk> r =
                this.corporationApi
                        .getCorporationsCorporationId(corpID.intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final ESICorporation corporation = CorporationTransformer.transform(corpID, r.body());
        addPortraits(corporation);
        addHistory(corporation);
        return corporation;
    }

    public List<ESICorporation.Member> getMembers(Long corpID) throws IOException {
        final Response<List<GetCorporationsCorporationIdMembers200Ok>> r =
                this.corporationApi.getCorporationsCorporationIdMembers(corpID.intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<GetCorporationsCorporationIdMembers200Ok> members = r.body();
        final List<ESICorporation.Member> returned = new ArrayList<>(members.size());
        for (GetCorporationsCorporationIdMembers200Ok m: members) {
            returned.add(CorporationTransformer.transform(m));
        }
        return returned;
    }

    private void addPortraits(final ESICorporation to) throws IOException {
        final Response<GetCorporationsCorporationIdIconsOk> r =
                this.corporationApi
                        .getCorporationsCorporationIdIcons(to.getId().intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }

        final GetCorporationsCorporationIdIconsOk icons = r.body();
        to.setPortrait64(icons.getPx64x64());
        to.setPortrait128(icons.getPx128x128());
        to.setPortrait256(icons.getPx256x256());
    }

    private void addHistory(final ESICorporation to) throws IOException {
        final Response<List<GetCorporationsCorporationIdAlliancehistory200Ok>> r =
                this.corporationApi
                        .getCorporationsCorporationIdAlliancehistory(to.getId().intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }
        for (GetCorporationsCorporationIdAlliancehistory200Ok h: r.body()) {
            to.add(CorporationTransformer.transform(h));
        }
    }
}
