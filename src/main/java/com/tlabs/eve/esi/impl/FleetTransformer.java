package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIFleet;
import org.apache.commons.collections4.CollectionUtils;
import org.devfleet.esi.model.FleetsfleetIdwingsSquads;
import org.devfleet.esi.model.GetFleetsFleetIdMembers200Ok;
import org.devfleet.esi.model.GetFleetsFleetIdOk;
import org.devfleet.esi.model.GetFleetsFleetIdWings200Ok;
import org.devfleet.esi.model.PostFleetsFleetIdMembersInvitation;
import org.devfleet.esi.model.PutFleetsFleetIdMembersMemberIdMovement;
import org.devfleet.esi.model.PutFleetsFleetIdNewSettings;

import java.util.ArrayList;
import java.util.List;

final class FleetTransformer {

    private FleetTransformer() {}

    static ESIFleet transform(final long fleetId, final GetFleetsFleetIdOk object) {
        final ESIFleet fleet = new ESIFleet();
        fleet.setFleetId(fleetId);
        fleet.setFreeMove(null == object.getIsFreeMove() ? false : object.getIsFreeMove());
        fleet.setRegistered(null == object.getIsRegistered() ? false : object.getIsRegistered());
        fleet.setVoiceEnabled(null == object.getIsVoiceEnabled() ? false : object.getIsVoiceEnabled());
        fleet.setMotd(object.getMotd());
        return fleet;
    }

    static ESIFleet.Wing transform(final GetFleetsFleetIdWings200Ok object) {
        final ESIFleet.Wing wing = new ESIFleet.Wing();
        wing.setId(object.getId());
        wing.setName(object.getName());
        if (CollectionUtils.isEmpty(object.getSquads())) {
            return wing;
        }

        final List<ESIFleet.Squad> squads = new ArrayList<>();
        for (FleetsfleetIdwingsSquads s: object.getSquads()) {
            ESIFleet.Squad squad = new ESIFleet.Squad();
            squad.setId(s.getId());
            squad.setName(s.getName());

            squads.add(squad);
        }

        wing.setSquads(squads);
        return wing;
    }

    static ESIFleet.Member transform(final GetFleetsFleetIdMembers200Ok object) {
        final ESIFleet.Member member = new ESIFleet.Member();
        member.setCharacterId(object.getCharacterId());
        member.setJoinTime(null == object.getJoinTime() ? 0 : object.getJoinTime().getMillis());
        member.setShipTypeId(null == object.getShipTypeId() ? 0 : object.getShipTypeId());
        member.setSolarSystemId(null == object.getSolarSystemId() ? 0 : object.getSolarSystemId());
        member.setStationId(null == object.getStationId() ? 0: object.getStationId());
        member.setTakesFleetWarp(null == object.getTakesFleetWarp() ? false : object.getTakesFleetWarp());
        member.setWingId(null == object.getWingId() ? 0 : object.getWingId());
        member.setSquadId(null == object.getSquadId() ? 0 : object.getSquadId());

        if (null == object.getRoleName()) {
            member.setRole(ESIFleet.Member.SQUAD_MEMBER);
        }
        else {
            switch (object.getRoleName()) {
                case "fleet_commander":
                    member.setRole(ESIFleet.Member.FLEET_COMMANDER);
                    break;
                case "wing_commander":
                    member.setRole(ESIFleet.Member.WING_COMMANDER);
                    break;
                case "squad_commander":
                    member.setRole(ESIFleet.Member.SQUAD_COMMANDER);
                    break;
                case "squad_member":
                default:
                    member.setRole(ESIFleet.Member.SQUAD_MEMBER);
                    break;
            }
        }
        return member;
    }

    static PutFleetsFleetIdNewSettings transform(final ESIFleet fleet) {
        PutFleetsFleetIdNewSettings settings = new PutFleetsFleetIdNewSettings();
        settings.setIsFreeMove(fleet.isFreeMove());
        settings.setMotd(fleet.getMotd());
        return settings;
    }

    static PostFleetsFleetIdMembersInvitation invite(final ESIFleet.Member member) {
        final PostFleetsFleetIdMembersInvitation invitation = new PostFleetsFleetIdMembersInvitation();


        return invitation;
    }

    static PutFleetsFleetIdMembersMemberIdMovement transform(final ESIFleet.Member member) {
        final PutFleetsFleetIdMembersMemberIdMovement movement = new PutFleetsFleetIdMembersMemberIdMovement();
        movement.setSquadId(member.getSquadId());
        movement.setWingId(member.getWingId());
        switch (member.getRole()) {
            case ESIFleet.Member.FLEET_COMMANDER:
                movement.setRole(PutFleetsFleetIdMembersMemberIdMovement.RoleEnum.FLEET_COMMANDER);
                break;
            case ESIFleet.Member.WING_COMMANDER:
                movement.setRole(PutFleetsFleetIdMembersMemberIdMovement.RoleEnum.WING_COMMANDER);
                break;
            case ESIFleet.Member.SQUAD_COMMANDER:
                movement.setRole(PutFleetsFleetIdMembersMemberIdMovement.RoleEnum.SQUAD_COMMANDER);
                break;
            case ESIFleet.Member.SQUAD_MEMBER:
            default:
                movement.setRole(PutFleetsFleetIdMembersMemberIdMovement.RoleEnum.SQUAD_MEMBER);
                break;
        }
        return movement;
    }
}
