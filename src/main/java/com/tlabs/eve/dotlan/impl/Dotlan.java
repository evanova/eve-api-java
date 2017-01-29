package com.tlabs.eve.dotlan.impl;

import com.tlabs.eve.dotlan.model.DotlanSolarSystem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

interface Dotlan {
    @GET("/route/{dotlanQuery}")
    Call<List<DotlanSolarSystem>> getRoute(
            @Path("dotlanQuery") final String query);

    @GET("/jump/{shipSpec}/{dotlanQuery}")
    Call<List<DotlanSolarSystem>> getJumps(
            @Path("shipSpec") final String spec,
            @Path("dotlanQuery") final String query);
}
