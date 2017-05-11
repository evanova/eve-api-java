package com.tlabs.eve.esi.impl;


import com.tlabs.eve.esi.model.ESIFitting;
import org.devfleet.esi.api.FittingsApi;
import org.devfleet.esi.model.GetCharactersCharacterIdFittings200Ok;
import org.devfleet.esi.model.PostCharactersCharacterIdFittingsCreated;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class FittingRetrofit {

    private final FittingsApi api;
    private final String datasource;

    public FittingRetrofit(final Retrofit rf, final String datasource){
        this.api = rf.create(FittingsApi.class);
        this.datasource = datasource;
    }

    public List<ESIFitting> getFittings(final Long charID) throws IOException {
        final Response<List<GetCharactersCharacterIdFittings200Ok>> r =
                this.api.getCharactersCharacterIdFittings(
                charID.intValue(),
                this.datasource,
                null,
                null,
                null).execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIFitting> fittings = new ArrayList<>();
        for (GetCharactersCharacterIdFittings200Ok f: r.body()) {
            fittings.add(FittingTransformer.transform(f));
        }
        return fittings;
    }

    public Long postFitting(final Long charID, final ESIFitting fitting) throws IOException {
        final Response<PostCharactersCharacterIdFittingsCreated> r =
                this.api.postCharactersCharacterIdFittings(
                charID.intValue(),
                this.datasource,
                FittingTransformer.transform(fitting),
                null,
                null,
                null)
                .execute();
        return (r.isSuccessful()) ?
            r.body().getFittingId().longValue() :
            null;
    }

    public boolean deleteFitting(final Long charID, final Long fittingID) throws IOException {
        return this.api.deleteCharactersCharacterIdFittingsFittingId(
                charID.intValue(),
                fittingID.intValue(),
                this.datasource,
                null,
                null,
                null)
                .execute()
                .isSuccessful();
    }
}
