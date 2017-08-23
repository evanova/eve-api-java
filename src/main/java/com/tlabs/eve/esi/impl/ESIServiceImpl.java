package com.tlabs.eve.esi.impl;

import com.github.scribejava.core.oauth.OAuth20Service;
import com.tlabs.eve.EveLocale;
import com.tlabs.eve.esi.ESIService;
import com.tlabs.eve.esi.model.ESIAsset;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICharacterStatus;
import com.tlabs.eve.esi.model.ESIFitting;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIMarketHistory;
import com.tlabs.eve.esi.model.ESIMarketItem;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import com.tlabs.eve.esi.model.ESIShip;
import com.tlabs.eve.net.EveRetrofit;
import com.tlabs.eve.net.EveStore;
import com.tlabs.eve.net.EveToken;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ESIServiceImpl extends EveRetrofit implements ESIService {

    private interface VerifyService {
        @GET("/oauth/verify")
        Call<ESICharacterStatus> getVerification(@Header("Authorization") String token);
    }

    private static final Logger LOG = LoggerFactory.getLogger(ESIServiceImpl.class);
    private static final String SOURCE = "tranquility";


    private final CharacterRetrofit rCharacter;
    private final MailRetrofit rMail;
    private final FittingRetrofit rFitting;
    private final PublicRetrofit rPublic;

    private final VerifyService verify;

    public ESIServiceImpl(
            final String host,
            final String login,
            final OAuth20Service oAuth,
            final EveStore store,
            final String agent,
            final long timeout,
            final File cache,
            final long cacheSize,
            final String refresh) {

        super(host, login, oAuth, store, agent, timeout, refresh, cache, cacheSize, ESIConverters.gson());

        this.rPublic = new PublicRetrofit(getRetrofit(), SOURCE);
        this.rCharacter = new CharacterRetrofit(getRetrofit(), SOURCE);
        this.rMail = new MailRetrofit(getRetrofit(), SOURCE);
        this.rFitting = new FittingRetrofit(getRetrofit(), SOURCE);

        OkHttpClient.Builder verifyClient =
                new OkHttpClient.Builder()
                        .certificatePinner(
                                new CertificatePinner.Builder()
                                .add(login, "sha256/5UeWOuDyX7IUmcKnsVdx+vLMkxEGAtzfaOUQT/caUBE=")
                                .add(login, "sha256/980Ionqp3wkYtN9SZVgMzuWQzJta1nfxNPwTem1X0uc=")
                                .add(login, "sha256/du6FkDdMcVQ3u8prumAo6t3i3G27uMP2EOhR8R0at/U=")
                                .build())
                        .addInterceptor(new UserAgentInterceptor(login, agent));
        if (LOG.isDebugEnabled()) {
            verifyClient = verifyClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        this.verify =
                new Retrofit.Builder()
                        .baseUrl("https://" + login + "/")
                        .addConverterFactory(ESIConverters.jackson())
                        .client(verifyClient.build())
                        .build()
                        .create(VerifyService.class);
    }

    @Override
    public ESIServerStatus getServerStatus() {
        try {
            return this.rPublic.getServerStatus();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIMarketItem> getMarketPrices() {
        try {
            return this.rPublic.getMarketItems();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIMarketOrder> getMarketOrders(Long regionID, Long itemID) {
        try {
            return this.rPublic.getMarketOrders(regionID, itemID);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIMarketHistory> getMarketHistory(Long regionID, Long itemID) {
        try {
            return this.rPublic.getMarketHistory(regionID, itemID);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIName> getNames(final List<Integer> ids) {
        try {
            return this.rPublic.getNames(ids);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIName> getRegions() {
        try {
            return this.rPublic.getRegions();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation.Region getRegion(Long id) {
        try {
            return rPublic.getRegion(id, EveLocale.DEFAULT.value());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation.Constellation getConstellation(Long id) {
        try {
            return rPublic.getConstellation(id, EveLocale.DEFAULT.value());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation.SolarSystem getSolarSystem(Long id) {
        try {
            return rPublic.getSolarSystem(id);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation.Station getStation(Long id) {
        try {
            return rPublic.getStation(id);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Long> listStructures() {
        try {
            return rPublic.listStructures();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation.Structure getStructure(Long id) {
        try {
            return rCharacter.getStructure(id);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Map<Long, ESILocation.SolarSystem> getSolarSystemStatistics() {
        try {
            return rPublic.getSolarSystemStatistics();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESIKillMail getKillMail(ESIKillMail killMail) {
        try {
            return this.rMail.getKillMail(killMail);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESICharacterStatus getCharacterStatus() {
        try {
            return verifyCharacterStatus();
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESICharacter getCharacter() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCharacter(status.getCharacterID());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESILocation getCharacterLocation() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            final ESILocation location = this.rCharacter.getCharacterLocation(status.getCharacterID());
            if (location.getId() > Integer.MAX_VALUE) {
                return getStructure(location.getId());
            }

            final List<ESIName> names = rPublic.getNames(Collections.singletonList((int)location.getId()));
            if (!CollectionUtils.isEmpty(names)) {
                location.setName(names.get(0).getName());
            }
            return location;
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESIShip getCharacterShip() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCharacterShip(status.getCharacterID());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ESICalendar getCalendar(Long afterEventID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCalendar(status.getCharacterID(), afterEventID);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }

    }
/*
    @Override
    public boolean postCalendarEvent(Long eventID, ESICalendar.Event.Response response) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.postCalendarEvent(status.getCharacterID(), eventID, response);
        }
        catch (IOException | IllegalStateException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }
*/

    @Override
    public List<ESIAsset> getAssets() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getAssets(status.getCharacterID());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean deleteMail(Long mailID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.deleteMail(status.getCharacterID(), mailID);

        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<ESIMail> getMails(Long afterMailID, String... labels) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMails(status.getCharacterID(), afterMailID, labels);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<ESIMailbox> getMailboxes() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMailboxes(status.getCharacterID());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public ESIMail getMailContent(Long mailID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMailContent(status.getCharacterID(), mailID);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Integer postMail(ESIMail mail) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.postMail(status.getCharacterID(), mail);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean updateMail(ESIMail mail) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.updateMail(status.getCharacterID(), mail);

        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean createMailbox(ESIMailbox mailbox) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.createMailbox(status.getCharacterID(), mailbox);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<ESIKillMail> getKillMails(Integer maxCount, Long maxKillID, boolean withContent) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getKillMails(status.getCharacterID(), maxCount, maxKillID, withContent);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<ESIFitting> getFittings() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rFitting.getFittings(status.getCharacterID());
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Long postFitting(final ESIFitting fitting) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rFitting.postFitting(status.getCharacterID(), fitting);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean deleteFitting(final Long fittingID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rFitting.deleteFitting(status.getCharacterID(), fittingID);
        }
        catch (IOException | IllegalStateException e) {
            LOG.debug(e.getLocalizedMessage(), e);
            LOG.error(e.getLocalizedMessage());
            return false;
        }
    }

    private ESICharacterStatus verifyCharacterStatus() throws IOException {
        final EveToken stored = verify();
        final Response<ESICharacterStatus> r = this.verify.getVerification("Bearer " + stored.getAccessToken()).execute();
        if (r.isSuccessful()) {
            return r.body();
        }
        throw new IOException(r.message());
    }
}
