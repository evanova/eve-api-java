package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMarketHistory;
import com.tlabs.eve.esi.model.ESIMarketItem;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import org.devfleet.esi.api.RoutesApi;
import org.devfleet.esi.api.StatusApi;
import org.devfleet.esi.api.UniverseApi;
import org.devfleet.esi.model.GetMarketsPrices200Ok;
import org.devfleet.esi.model.GetMarketsRegionIdHistory200Ok;
import org.devfleet.esi.model.GetMarketsRegionIdOrders200Ok;
import org.devfleet.esi.model.GetStatusOk;
import org.devfleet.esi.model.GetUniverseConstellationsConstellationIdOk;
import org.devfleet.esi.model.GetUniverseRegionsRegionIdOk;
import org.devfleet.esi.model.GetUniverseStationsStationIdOk;
import org.devfleet.esi.model.GetUniverseSystemJumps200Ok;
import org.devfleet.esi.model.GetUniverseSystemKills200Ok;
import org.devfleet.esi.model.GetUniverseSystemsSystemIdOk;
import org.devfleet.esi.model.PostUniverseNames200Ok;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class PublicRetrofit {
    private final String datasource;

    private final StatusApi statusApi;
    private final UniverseApi universeApi;
    private final RoutesApi routeApi;
    private final MarketApi2 marketApi;

    public PublicRetrofit(final Retrofit rf, final String datasource) {
        this.statusApi = rf.create(StatusApi.class);
        this.universeApi = rf.create(UniverseApi.class);
        this.routeApi = rf.create(RoutesApi.class);
        this.marketApi = rf.create(MarketApi2.class);
        this.datasource = datasource;
    }

    public ESIServerStatus getServerStatus() throws IOException {
        Response<GetStatusOk> r =
                this.statusApi.getStatus(this.datasource, null, null).execute();
        return (r.isSuccessful()) ? PublicTransformer.transform(r.body()) : null;
    }

    public List<ESIMarketItem> getMarketItems() throws IOException {
        Response<List<GetMarketsPrices200Ok>> r =
                this.marketApi.getMarketsPrices(this.datasource, null, null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        final List<ESIMarketItem> returned = new ArrayList<>();
        for (GetMarketsPrices200Ok o: r.body()) {
            returned.add(PublicTransformer.transform(o));
        }
        return returned;
    }

    public List<ESIMarketOrder> getMarketOrders(final Long regionID, final Long typeID) throws IOException {
        Response<List<GetMarketsRegionIdOrders200Ok>> r =
                this.marketApi.getMarketsRegionIdOrders(
                        regionID.intValue(),
                        null,
                        this.datasource,
                        null,
                        typeID.intValue(),
                        null,
                        null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        final List<ESIMarketOrder> returned = new ArrayList<>();
        for (GetMarketsRegionIdOrders200Ok o: r.body()) {
            returned.add(PublicTransformer.transform(o));
        }
        return returned;
    }

    public List<ESIMarketHistory> getMarketHistory(final Long regionID, final Long typeID) throws IOException {
        Response<List<GetMarketsRegionIdHistory200Ok>> r =
                this.marketApi.getMarketsRegionIdHistory(
                        regionID.intValue(),
                        typeID.intValue(),
                        this.datasource,
                        null,
                        null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        final List<ESIMarketHistory> returned = new ArrayList<>();
        for (GetMarketsRegionIdHistory200Ok o: r.body()) {
            final ESIMarketHistory h = PublicTransformer.transform(o);
            h.setTypeID(typeID);
            h.setRegionID(regionID);
            returned.add(h);
        }
        return returned;
    }

    public List<ESIName> getRegions() throws IOException {
        Response<List<Integer>> r =
                this.universeApi.getUniverseRegions(this.datasource, null, null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return getNames(r.body());
    }

    public List<ESIName> getNames(final List<Integer> ids) throws IOException {
        Response<List<PostUniverseNames200Ok>> r =
                this.universeApi.postUniverseNames(
                        ids,
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

    public ESILocation.Region getRegion(Long regionId, String language) throws IOException {
        Response<GetUniverseRegionsRegionIdOk> r =
                this.universeApi.getUniverseRegionsRegionId(
                        regionId.intValue(),
                        this.datasource,
                        language,
                        null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        ESILocation.Region region = PublicTransformer.transform(r.body());
        //fill(region, r.body().getConstellations(), language);

        return region;
    }

    public final ESILocation.Constellation getConstellation(final Long id, final String language) throws IOException {
        Response<GetUniverseConstellationsConstellationIdOk> r = this.universeApi.getUniverseConstellationsConstellationId(
                id.intValue(),
                this.datasource,
                language,
                null,
                null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return PublicTransformer.transform(r.body());
    }

    public final ESILocation.SolarSystem getSolarSystem(final Long id) throws IOException {
        Response<GetUniverseSystemsSystemIdOk> r = this.universeApi.getUniverseSystemsSystemId(
                id.intValue(),
                this.datasource,
                null,
                null,
                null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return PublicTransformer.transform(r.body());
    }

    public final ESILocation.Station getStation(final Long id) throws IOException {
        Response<GetUniverseStationsStationIdOk> r = this.universeApi.getUniverseStationsStationId(
                id.intValue(),
                this.datasource,
                null,
                null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return PublicTransformer.transform(id, r.body());
    }

    public List<ESILocation.SolarSystem> getRoute(
            final Long from,
            final Long to,
            final String option) throws IOException {
        Response<List<Integer>> r = this.routeApi.getRouteOriginDestination(
                from.intValue(),
                to.intValue(),
                null,
                null,
                this.datasource,
                option,
                null,
                null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESILocation.SolarSystem> systems = new ArrayList<>();
        for (Integer a: r.body()) {
            ESILocation.SolarSystem system = getSolarSystem(a.longValue());
            if (null != system) {
                systems.add(system);
                //fill(system, r.body().g)
            }
        }
        return systems;
    }


    public Map<Long, ESILocation.SolarSystem> getSolarSystemStatistics() throws IOException {
        final Response<List<GetUniverseSystemJumps200Ok>> rj =
                this.universeApi.getUniverseSystemJumps(this.datasource, null, null)
                .execute();

        final Map<Long, ESILocation.SolarSystem> result = new HashMap<>();
        if (rj.isSuccessful()) {
            for (GetUniverseSystemJumps200Ok j: rj.body()) {
                final ESILocation.SolarSystem system = new ESILocation.SolarSystem()
                        .setShipJumps(j.getShipJumps())
                        .setId(j.getSystemId());
                result.put(system.getId(), system);
            }
        }

        final Response<List<GetUniverseSystemKills200Ok>> rk =
                this.universeApi.getUniverseSystemKills(this.datasource, null, null)
                .execute();

        if (rk.isSuccessful()) {
            for (GetUniverseSystemKills200Ok k: rk.body()) {
                ESILocation.SolarSystem system = result.get(k.getSystemId().longValue());
                if (null == system) {
                    system = new ESILocation.SolarSystem().setId(k.getSystemId());
                    result.put(system.getId(), system);
                }
                system.setShipKills(k.getShipKills());
                system.setPodKills(k.getPodKills());
                system.setNpcKills(k.getNpcKills());
            }
        }
        return result;
    }

    public List<Long> listStructures() throws IOException {
        Response<List<Long>> r =
                this.universeApi.getUniverseStructures(this.datasource, null, null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return r.body();
    }


   /* private void fill(final ESILocation.Region region, final List<Integer> constellations, final String language) throws IOException {
        for (Integer a: constellations) {
            Response<GetUniverseConstellationsConstellationIdOk> r = this.universeApi.getUniverseConstellationsConstellationId(
                    a,
                    this.datasource,
                    language,
                    null,
                    null)
                    .execute();
            if (r.isSuccessful()) {
                final ESILocation.Constellation constellation = PublicTransformer.transform(r.body());
                region.addConstellation(constellation);
                fill(constellation, r.body().getSystems(), language);
            }
        }
    }*/

   /* private void fill(final ESILocation.Constellation constellation, final List<Integer> systems, final String language) throws IOException {
        for (Integer a: systems) {
            ESILocation.SolarSystem system = getSolarSystem(a.longValue(), language);
            if (null != system) {
                constellation.addSolarSystem(system);
                //fill(system, r.body().g)
            }
        }
    }*/

}
