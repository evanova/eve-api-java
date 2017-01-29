package com.tlabs.eve.esi.impl;


import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESILocation;
import org.devfleet.esi.api.CalendarApi;
import org.devfleet.esi.api.CharacterApi;
import org.devfleet.esi.api.LocationApi;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendar200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendarEventIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCorporationhistory200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdLocationOk;
import org.devfleet.esi.model.GetCharactersCharacterIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdPortraitOk;
import org.devfleet.esi.model.PutCharactersCharacterIdCalendarEventIdResponse;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

final class CharacterRetrofit {

    private final CharacterApi characterApi;
    private final CalendarApi calendarApi;
    private final LocationApi locationApi;

    private final String datasource;

    public CharacterRetrofit(final Retrofit rf, final String datasource){
        this.characterApi = rf.create(CharacterApi.class);
        this.calendarApi = rf.create(CalendarApi.class);
        this.locationApi = rf.create(LocationApi.class);
        this.datasource = datasource;
    }

    public ESICharacter getCharacter(Long charID) throws IOException {
        final Response<GetCharactersCharacterIdOk> r = this.characterApi
                .getCharactersCharacterId(charID.intValue(), this.datasource)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final ESICharacter character = CharacterTransformer.transform(charID, r.body());
        addPortraits(character);
        addHistory(character);
        return character;
    }

    public ESILocation getCharacterLocation(final Long charID) throws IOException {
        final Response<GetCharactersCharacterIdLocationOk> r =
                this.locationApi
                        .getCharactersCharacterIdLocation(charID.intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return CharacterTransformer.transform(r.body());
    }

    public ESICalendar getCalendar(Long charID, Long afterEventID)  throws IOException {
        final Response<List<GetCharactersCharacterIdCalendar200Ok>> r =
                this.calendarApi
                        .getCharactersCharacterIdCalendar(charID.intValue(), (null == afterEventID) ? null : afterEventID.intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final ESICalendar calendar = new ESICalendar();
        for (GetCharactersCharacterIdCalendar200Ok e: r.body()) {
            addEvent(charID, e, calendar);
        }
        return calendar;
    }

    private void addEvent(final Long charID, final GetCharactersCharacterIdCalendar200Ok object, final ESICalendar to) throws IOException {
        Response<GetCharactersCharacterIdCalendarEventIdOk> r =
                this.calendarApi
                        .getCharactersCharacterIdCalendarEventId(charID.intValue(), object.getEventId(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }

        to.add(CharacterTransformer.transform(object, r.body()));
    }

    public boolean postCalendarEvent(Long charID, Long eventID, ESICalendar.Event.Response response) throws IOException {
        PutCharactersCharacterIdCalendarEventIdResponse.ResponseEnum re;
        switch (response) {
            case ACCEPTED:
                re = PutCharactersCharacterIdCalendarEventIdResponse.ResponseEnum.ACCEPTED;
                break;
            case DECLINED:
                re = PutCharactersCharacterIdCalendarEventIdResponse.ResponseEnum.DECLINED;
                break;
            case TENTATIVE:
                re = PutCharactersCharacterIdCalendarEventIdResponse.ResponseEnum.TENTATIVE;
                break;
            default:
                re = null;
                break;
        }
        if (null == re) {
            return false;
        }

        PutCharactersCharacterIdCalendarEventIdResponse r =
                new PutCharactersCharacterIdCalendarEventIdResponse().response(re);
        this.calendarApi
                .putCharactersCharacterIdCalendarEventId(charID.intValue(), eventID.intValue(), r, this.datasource)
                .execute();
        return true;
    }

    private void addPortraits(final ESICharacter to)  throws IOException{
        final Response<GetCharactersCharacterIdPortraitOk> r =
                this.characterApi
                        .getCharactersCharacterIdPortrait(to.getId().intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }

        final GetCharactersCharacterIdPortraitOk portraits = r.body();
        to.setPortrait64(portraits.getPx64x64());
        to.setPortrait128(portraits.getPx128x128());
        to.setPortrait256(portraits.getPx256x256());
        to.setPortrait512(portraits.getPx512x512());
    }

    private void addHistory(final ESICharacter to)  throws IOException{
        final Response<List<GetCharactersCharacterIdCorporationhistory200Ok>> r =
                this.characterApi
                        .getCharactersCharacterIdCorporationhistory(to.getId().intValue(), this.datasource)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }
        for (GetCharactersCharacterIdCorporationhistory200Ok h: r.body()) {
            to.add(CharacterTransformer.transform(h));
        }
    }
}
