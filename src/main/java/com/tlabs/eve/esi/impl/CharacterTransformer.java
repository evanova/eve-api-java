package com.tlabs.eve.esi.impl;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESILocation;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendar200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendarEventIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCorporationhistory200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdLocationOk;
import org.devfleet.esi.model.GetCharactersCharacterIdOk;

final class CharacterTransformer {

    private CharacterTransformer() {}

    public static ESICharacter transform(final long charID, final GetCharactersCharacterIdOk c) {
        final ESICharacter character = new ESICharacter(charID);

        return character;
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
        ESILocation location = new ESILocation();
        location.setSolarSystemId((null == object.getSolarSystemId()) ? null : object.getSolarSystemId().longValue());
        location.setStationId((null == object.getStationId()) ? null : object.getStationId().longValue());
        location.setStructureId(object.getStructureId());
        return location;
    }

}
