package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIFleet;
import org.devfleet.esi.api.FleetsApi;
import org.devfleet.esi.model.GetFleetsFleetIdMembers200Ok;
import org.devfleet.esi.model.GetFleetsFleetIdOk;
import org.devfleet.esi.model.GetFleetsFleetIdWings200Ok;
import org.devfleet.esi.model.PostFleetsFleetIdMembersInvitation;
import org.devfleet.esi.model.PostFleetsFleetIdWingsCreated;
import org.devfleet.esi.model.PostFleetsFleetIdWingsWingIdSquadsCreated;
import org.devfleet.esi.model.PutFleetsFleetIdMembersMemberIdMovement;
import org.devfleet.esi.model.PutFleetsFleetIdNewSettings;
import org.devfleet.esi.model.PutFleetsFleetIdSquadsSquadIdNaming;
import org.devfleet.esi.model.PutFleetsFleetIdWingsWingIdNaming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class FleetRetrofit {
    private static final Logger LOG = LoggerFactory.getLogger(FleetRetrofit.class);

    private final FleetsApi fleetApi;
    private final String datasource;

    public FleetRetrofit(final Retrofit rf, final String datasource){
        this.fleetApi = rf.create(FleetsApi.class);
        this.datasource = datasource;
    }

    public boolean deleteMember(final long fleetId, final long memberId) throws IOException {
        Response<Void> r = fleetApi.deleteFleetsFleetIdMembersMemberId(
                fleetId, (int)memberId, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public boolean deleteSquad(final long fleetId, final long squadId) throws IOException {
        Response<Void> r = fleetApi.deleteFleetsFleetIdSquadsSquadId(
                fleetId, squadId, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public boolean deleteWing(final long fleetId, final long wingId) throws IOException {
        Response<Void> r = fleetApi.deleteFleetsFleetIdWingsWingId(
                fleetId, wingId, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public ESIFleet getFleet(long fleetId) throws IOException {
        Response<GetFleetsFleetIdOk> r = fleetApi.getFleetsFleetId(
                fleetId, datasource, null, null, null).execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return FleetTransformer.transform(fleetId, r.body());
    }

    public List<ESIFleet.Member> getFleetMembers(final long fleetId) throws IOException {
        final Response<List<GetFleetsFleetIdMembers200Ok>> r = fleetApi.getFleetsFleetIdMembers(
                fleetId, datasource, null, null, null, null).execute();
        if (!r.isSuccessful()) {
            return null;
        }
        final List<ESIFleet.Member> members = new ArrayList<>();
        for (GetFleetsFleetIdMembers200Ok ok: r.body()) {
            members.add(FleetTransformer.transform(ok));
        }
        return members;
    }

    public List<ESIFleet.Wing> getFleetWings(final long fleetId) throws IOException {
        final Response<List<GetFleetsFleetIdWings200Ok>> r = fleetApi.getFleetsFleetIdWings(
                fleetId, datasource, null, null, null, null).execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIFleet.Wing> wings = new ArrayList<>();
        for (GetFleetsFleetIdWings200Ok ok: r.body()) {
            wings.add(FleetTransformer.transform(ok));
        }
        return wings;
    }

    public boolean postInvitation(final long fleetId, final ESIFleet.Member member) throws IOException {
        final PostFleetsFleetIdMembersInvitation invitation = FleetTransformer.invite(member);
        return fleetApi.postFleetsFleetIdMembers(
                fleetId, invitation, datasource, null, null, null)
                .execute()
                .isSuccessful();
    }

    public Long postWing(final long fleetId) throws IOException {
        final Response<PostFleetsFleetIdWingsCreated> r =
                fleetApi.postFleetsFleetIdWings(fleetId, datasource, null, null, null).execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return r.body().getWingId();
    }

    public Long postSquad(final long fleetId, final long wingId) throws IOException {
        final Response<PostFleetsFleetIdWingsWingIdSquadsCreated> r =
                fleetApi.postFleetsFleetIdWingsWingIdSquads(fleetId, wingId, datasource, null, null, null).execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return r.body().getSquadId();
    }

    public boolean updateFleet(final ESIFleet fleet) throws IOException {
        final PutFleetsFleetIdNewSettings newSettings = FleetTransformer.transform(fleet);
        final Response<Void> r = fleetApi.putFleetsFleetId(
                fleet.getFleetId(), newSettings, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public boolean updateMember(final long fleetId, final ESIFleet.Member member) throws IOException {
        final PutFleetsFleetIdMembersMemberIdMovement movement = FleetTransformer.transform(member);
        final Response<Void> r = fleetApi.putFleetsFleetIdMembersMemberId(
                fleetId, (int)member.getCharacterId(), movement, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public boolean updateSquad(final long fleetId, final long squadId, final String name) throws IOException {
        final PutFleetsFleetIdSquadsSquadIdNaming naming = new PutFleetsFleetIdSquadsSquadIdNaming();
        naming.setName(name);

        final Response<Void> r = fleetApi.putFleetsFleetIdSquadsSquadId(
                fleetId, naming, squadId, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

    public boolean updateWing(final long fleetId, final long wingId, final String name) throws IOException {
        final PutFleetsFleetIdWingsWingIdNaming naming = new PutFleetsFleetIdWingsWingIdNaming();
        naming.setName(name);

        final Response<Void> r = fleetApi.putFleetsFleetIdWingsWingId(
                fleetId, naming, wingId, datasource, null, null, null).execute();
        return r.isSuccessful();
    }

}
