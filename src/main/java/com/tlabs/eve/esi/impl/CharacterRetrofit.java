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
import org.devfleet.esi.api.SkillsApi;
import org.devfleet.esi.api.UniverseApi;
import org.devfleet.esi.api.WalletApi;
import org.devfleet.esi.model.GetCharactersCharacterIdAssets200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdAttributesOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendar200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdCalendarEventIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdCorporationhistory200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdLocationOk;
import org.devfleet.esi.model.GetCharactersCharacterIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdPortraitOk;
import org.devfleet.esi.model.GetCharactersCharacterIdShipOk;
import org.devfleet.esi.model.GetCharactersCharacterIdSkillqueue200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdSkillsOk;
import org.devfleet.esi.model.GetCharactersCharacterIdSkillsOkSkills;
import org.devfleet.esi.model.GetUniverseStructuresStructureIdOk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class CharacterRetrofit {
    private static final Logger LOG = LoggerFactory.getLogger(CharacterRetrofit.class);

    private final AssetsApi assetsApi;
    private final CharacterApi characterApi;
    private final SkillsApi skillApi;
    private final WalletApi walletApi;

    private final CalendarApi calendarApi;
    private final LocationApi locationApi;
    private final UniverseApi universeApi;

    private final String datasource;

    public CharacterRetrofit(final Retrofit rf, final String datasource) {
        this.assetsApi = rf.create(AssetsApi.class);
        this.characterApi = rf.create(CharacterApi.class);
        this.skillApi = rf.create(SkillsApi.class);
        this.walletApi = rf.create(WalletApi.class);
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
        addAttributes(character);
        addWallet(character);
        addSkills(character);
        addTraining(character);
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

    public Boolean getCharacterOnline(final Long charID) throws IOException {
        final Response<Boolean> r =
                this.locationApi
                        .getCharactersCharacterIdOnline(charID.intValue(), this.datasource, null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return r.body();
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
        GetCharactersCharacterIdCalendarEventIdOk events = execute(
                this.calendarApi
                        .getCharactersCharacterIdCalendarEventId(
                                charID.intValue(),
                                object.getEventId(),
                                this.datasource, null, null, null));
        if (null == events) {
            return;
        }
        to.add(CharacterTransformer.transform(object, events));
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
    private void addPortraits(final ESICharacter to) throws IOException {
        final GetCharactersCharacterIdPortraitOk portraits =
                execute(
                this.characterApi
                        .getCharactersCharacterIdPortrait(
                                to.getId().intValue(),
                                this.datasource,
                                null, null));
        if (null == portraits) {
            return;
        }

        to.setPortrait64(portraits.getPx64x64());
        to.setPortrait128(portraits.getPx128x128());
        to.setPortrait256(portraits.getPx256x256());
        to.setPortrait512(portraits.getPx512x512());
    }

    private void addHistory(final ESICharacter to) {
        final List<GetCharactersCharacterIdCorporationhistory200Ok> r =
                execute(
                this.characterApi
                        .getCharactersCharacterIdCorporationhistory(
                                to.getId().intValue(),
                                this.datasource,
                                null, null));
        if (null == r) {
            return;
        }
        for (GetCharactersCharacterIdCorporationhistory200Ok h: r) {
            to.add(CharacterTransformer.transform(h));
        }
    }

    private void addAttributes(final ESICharacter to) {
        final GetCharactersCharacterIdAttributesOk attrs = execute(
                this.skillApi.getCharactersCharacterIdAttributes(
                        to.getId().intValue(),
                        this.datasource,
                        null, null, null));
        if (null == attrs) {
            return;
        }

        to.setCharisma(attrs.getCharisma());
        to.setIntelligence(attrs.getIntelligence());
        to.setMemory(attrs.getMemory());
        to.setPerception(attrs.getPerception());
        to.setWillpower(attrs.getWillpower());

        to.setBonusRemaps(attrs.getBonusRemaps());
        to.setLastRemapDate((null == attrs.getLastRemapDate()) ? 0 : attrs.getLastRemapDate().getMillis());
        to.setRemapCooldownDate((null == attrs.getAccruedRemapCooldownDate() ? 0 : attrs.getAccruedRemapCooldownDate().getMillis()));
    }

    private void addWallet(final ESICharacter to) {
        final Float r = execute(walletApi.getCharactersCharacterIdWallet(
                to.getId().intValue(),
                this.datasource,
                null, null, null));
        to.setWalletBalance((null == r) ? 0 : r);
    }

    private void addSkills(final ESICharacter to) {
        final GetCharactersCharacterIdSkillsOk r =
                execute(skillApi.getCharactersCharacterIdSkills(to.getId().intValue(), this.datasource, null, null, null));
        if (null == r) {
            return;
        }

        to.setTotalSkillPoints(null == r.getTotalSp() ? 0L : r.getTotalSp());
        if (null == r.getSkills()) {
            return;
        }

        for (GetCharactersCharacterIdSkillsOkSkills s: r.getSkills()) {
            final ESICharacter.Skill skill = new ESICharacter.Skill();
            skill.setSkillId(s.getSkillId());
            skill.setSkillLevel(s.getCurrentSkillLevel());
            skill.setSkillPoints(s.getSkillpointsInSkill());
            to.add(skill);
        }
    }

    private void addTraining(final ESICharacter to) {
        final List<GetCharactersCharacterIdSkillqueue200Ok> r = execute(
                skillApi.getCharactersCharacterIdSkillqueue(to.getId().intValue(), this.datasource, null, null, null));
        if (null == r) {
            return;
        }

        for (GetCharactersCharacterIdSkillqueue200Ok ok: r) {
            final ESICharacter.Training t = new ESICharacter.Training();
            t.setFinishDate(null == ok.getFinishDate() ? 0 : ok.getFinishDate().getMillis());
            t.setFinishedLevel(null == ok.getFinishedLevel() ? 0 : ok.getFinishedLevel());
            t.setLevelEndSp(null == ok.getLevelEndSp() ? 0 : ok.getLevelEndSp());
            t.setLevelStartSp(null == ok.getLevelStartSp() ? 0 : ok.getLevelStartSp());
            t.setQueuePosition(null == ok.getQueuePosition() ? 0 : ok.getQueuePosition());
            t.setSkillId(null == ok.getSkillId() ? 0: ok.getSkillId());
            t.setStartDate(null == ok.getStartDate() ? 0 : ok.getStartDate().getMillis());
            t.setTrainingStartSp(null == ok.getTrainingStartSp() ? 0 : ok.getTrainingStartSp());

            to.add(t);
        }
    }

    private static <T> T execute(Call<T> call) {
        try {
            final Response<T> r = call.execute();
            return r.isSuccessful() ? r.body() : null;
        }
        catch (IOException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }
}
