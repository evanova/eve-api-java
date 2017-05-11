package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import org.devfleet.esi.api.StatusApi;
import org.devfleet.esi.api.UniverseApi;
import org.devfleet.esi.model.GetStatusOk;
import org.devfleet.esi.model.PostUniverseNames200Ok;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class PublicRetrofit {
    private final String datasource;

    private final StatusApi statusApi;
    private final UniverseApi universeApi;

    public PublicRetrofit(final Retrofit rf, final String datasource) {
        this.statusApi = rf.create(StatusApi.class);
        this.universeApi = rf.create(UniverseApi.class);
        this.datasource = datasource;
    }

    public ESIServerStatus getServerStatus() throws IOException {
        Response<GetStatusOk> r =
                this.statusApi.getStatus(this.datasource, null, null).execute();
        return (r.isSuccessful()) ? PublicTransformer.transform(r.body()) : null;
    }

    public List<ESIName> getNames(final List<Long> ids) throws IOException {
        final List<Integer> ints = new ArrayList<>();
        for (Long l: ids) {
            ints.add(l.intValue());
        }

        Response<List<PostUniverseNames200Ok>> r =
                this.universeApi.postUniverseNames(
                ints,
                this.datasource,
                null,
                null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIName> returned = new ArrayList<>();
        for (PostUniverseNames200Ok o: r.body()) {
            returned.add(PublicTransformer.transform(o));
        }
        return returned;
    }
}
