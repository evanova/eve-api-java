package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIShip;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendar200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendarEventIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCorporationhistory200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdLocationOk;
import org.devfleet.esi.model.GetCharactersCharacterIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdShipOk;

final class CharacterTransformer {

    private CharacterTransformer() {}

    public static ESICharacter transform(final long charID, final GetCharactersCharacterIdOk c) {
        final ESICharacter character = new ESICharacter(charID);
        character.setName(c.getName());

        return character;
    }

    public static ESIShip transform(final GetCharactersCharacterIdShipOk s) {
        final ESIShip ship = new ESIShip();
        ship.setShipItemId(s.getShipItemId());
        ship.setShipTypeId(s.getShipTypeId());
        ship.setShipName(s.getShipName());
        return ship;
    }

    public static ESICharacter.History transform(GetCharactersCharacterIdCorporationhistory200Ok h) {
        final ESICharacter.History history = new ESICharacter.History();
        return history;
    }

    public static ESICalendar.Event transform(
            GetCharactersCharacterIdCalendar200Ok meta,
            GetCharactersCharacterIdCalendarEventIdOk details) {
        final ESICalendar.Event event = new ESICalendar.Event(Long.valueOf(meta.getEventId()));

        return event;
    }

    public static ESILocation transform(GetCharactersCharacterIdLocationOk object) {
        if (null == object.getSolarSystemId()) {
            return ESILocation.UNKNOWN;
        }

        if (null != object.getStationId()) {
            return new ESILocation.Station()
                    .setSolarSystemId(object.getSolarSystemId())
                    .setId(object.getStationId().longValue());
        }

        if (null != object.getStructureId()) {
            return new ESILocation.Structure()
                    .setSolarSystemId(object.getSolarSystemId())
                    .setId(object.getSolarSystemId());
        }
        return new ESILocation.SolarSystem()
                .setId(object.getSolarSystemId());
    }

}
