package com.tlabs.eve.dotlan.impl;

import com.tlabs.eve.dotlan.DotlanService;
import com.tlabs.eve.dotlan.model.DotlanJumpOptions;
import com.tlabs.eve.dotlan.model.DotlanOptions;
import com.tlabs.eve.dotlan.model.DotlanRoute;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class DotlanServiceImpl implements DotlanService {

    private static final Logger LOG = LoggerFactory.getLogger(DotlanServiceImpl.class.getName());

    private final Dotlan dotlan;
    private final DotlanRouteParser parser;

    public DotlanServiceImpl() {
        this.parser = new DotlanRouteParser();
        this.dotlan =
            new Retrofit.Builder()
            .baseUrl("http://evemaps.dotlan.net")
            .client(new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    final Response r = chain.proceed(chain.request());

                    String body = null;
                    if (chain.request().url().pathSegments().contains("jump")) {
                        body = parser.jumpJSON(r.body().string());
                    }
                    else if (chain.request().url().pathSegments().contains("route")) {
                        body = parser.routeJSON(r.body().string());
                    }
                    if (StringUtils.isEmpty(body)) {
                        return r;
                    }

                    return r.newBuilder()
                            .body(ResponseBody.create(MediaType.parse("application/json"), body))
                            .build();
                }
            }).build())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(Dotlan.class);
    }

    @Override
    public DotlanRoute getFastestRoute(DotlanOptions options) {
        return getRoute(1 + ":" + toWaypointsQuery(options));
    }

    @Override
    public DotlanRoute getHighSecRoute(DotlanOptions options) {
        return getRoute(2 + ":" + toWaypointsQuery(options));
    }

    @Override
    public DotlanRoute getLowSecRoute(DotlanOptions options) {
        return getRoute(3 + ":" + toWaypointsQuery(options));
    }

    @Override
    public DotlanRoute getJumpRoute(DotlanJumpOptions options) {
        try {
            return new DotlanRoute(
                    this.dotlan.getJumps(
                        toSpecificationQuery(options),
                        toWaypointsQuery(options))
                    .execute()
                    .body());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    private DotlanRoute getRoute(final String query) {
        try {
            return new DotlanRoute(dotlan.getRoute(query).execute().body());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    private static String toWaypointsQuery(final DotlanOptions options) {
        final StringBuilder b = new StringBuilder();
        for (String wp: options.getWaypoints()) {
            b.append(wp).append(":");
        }
        return StringUtils.removeEnd(b.toString(), ":");
    }

    private static String toSpecificationQuery(final DotlanJumpOptions options) {
        final StringBuilder b = new StringBuilder();
        b.append(options.getJumpShip());
        b.append(",");
        b.append(options.getJumpDriveCalibrationSkill());
        b.append(options.getJumpFuelConservationSkill());
        b.append(options.getJumpFreighterSkill());
        return b.toString();
    }
}
