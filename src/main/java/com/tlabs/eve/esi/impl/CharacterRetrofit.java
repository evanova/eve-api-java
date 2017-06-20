package com.tlabs.eve.esi.impl;


import com.tlabs.eve.esi.model.ESIAsset;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIShip;
import org.devfleet.esi.api.AssetsApi;
import org.devfleet.esi.api.CalendarApi;
import org.devfleet.esi.api.CharacterApi;
import org.devfleet.esi.api.LocationApi;
import org.devfleet.esi.api.UniverseApi;
import org.devfleet.esi.model.GetCharactersCharacterIdAssets200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendar200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendarEventIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCorporationhistory200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdLocationOk;
import org.devfleet.esi.model.GetCharactersCharacterIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdPortraitOk;
import org.devfleet.esi.model.GetCharactersCharacterIdShipOk;
import org.devfleet.esi.model.GetUniverseStructuresStructureIdOk;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class CharacterRetrofit {
    private final AssetsApi assetsApi;
    private final CharacterApi characterApi;
    private final CalendarApi calendarApi;
    private final LocationApi locationApi;
    private final UniverseApi universeApi;

    private final String datasource;

    public CharacterRetrofit(final Retrofit rf, final String datasource) {
        this.assetsApi = rf.create(AssetsApi.class);
        this.characterApi = rf.create(CharacterApi.class);
        this.calendarApi = rf.create(CalendarApi.class);
        this.locationApi = rf.create(LocationApi.class);
        this.universeApi = rf.create(UniverseApi.class);

        this.datasource = datasource;
    }

    public ESICharacter getCharacter(Long charID) throws IOException {
        final Response<GetCharactersCharacterIdOk> r = this.characterApi
                .getCharactersCharacterId(charID.intValue(), this.datasource, null, null)
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
                        .getCharactersCharacterIdLocation(charID.intValue(), this.datasource, null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return CharacterTransformer.transform(r.body());
    }

    public ESIShip getCharacterShip(final Long charID) throws IOException {
        final Response<GetCharactersCharacterIdShipOk> r =
                this.locationApi
                        .getCharactersCharacterIdShip(charID.intValue(), this.datasource, null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return CharacterTransformer.transform(r.body());
    }

    public ESICalendar getCalendar(Long charID, Long afterEventID) throws IOException {
        final Response<List<GetCharactersCharacterIdCalendar200Ok>> r =
                this.calendarApi
                        .getCharactersCharacterIdCalendar(
                                charID.intValue(),
                                this.datasource,
                                (null == afterEventID) ? null : afterEventID.intValue(),
                                null, null, null)
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

    public List<ESIAsset> getAssets(final Long charID) throws IOException {
        final Response<List<GetCharactersCharacterIdAssets200Ok>> r = this.assetsApi.getCharactersCharacterIdAssets(
                charID.intValue(),
                this.datasource,
                null, null, null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIAsset> assets = new ArrayList<>();
        for (GetCharactersCharacterIdAssets200Ok a: r.body()) {
            assets.add(AssetTransformer.transform(a));
        }
        return assets;
    }

    public ESILocation.Structure getStructure(final Long id) throws IOException {
        Response<GetUniverseStructuresStructureIdOk> r =
                this.universeApi
                        .getUniverseStructuresStructureId(id, this.datasource, null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return PublicTransformer.transform(id, r.body());
    }

    private void addEvent(final Long charID, final GetCharactersCharacterIdCalendar200Ok object, final ESICalendar to) throws IOException {
        Response<GetCharactersCharacterIdCalendarEventIdOk> r =
                this.calendarApi
                        .getCharactersCharacterIdCalendarEventId(
                                charID.intValue(),
                                object.getEventId(),
                                this.datasource, null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }

        to.add(CharacterTransformer.transform(object, r.body()));
    }

    /*public boolean postCalendarEvent(Long charID, Long eventID, ESICalendar.Event.Response response) throws IOException {
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
                .putCharactersCharacterIdCalendarEventId(
                        charID.intValue(),
                        eventID.intValue(), r,
                        this.datasource,
                        null,null,null)
                .execute();
        return true;
    }
*/
    private void addPortraits(final ESICharacter to)  throws IOException{
        final Response<GetCharactersCharacterIdPortraitOk> r =
                this.characterApi
                        .getCharactersCharacterIdPortrait(
                                to.getId().intValue(),
                                this.datasource,
                                null, null)
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
                        .getCharactersCharacterIdCorporationhistory(
                                to.getId().intValue(),
                                this.datasource,
                                null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return;
        }
        for (GetCharactersCharacterIdCorporationhistory200Ok h: r.body()) {
            to.add(CharacterTransformer.transform(h));
        }
    }
}
