package com.tlabs.eve.esi.impl;

import com.github.scribejava.core.oauth.OAuth20Service;
import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import com.tlabs.eve.esi.ESIService;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICharacterStatus;
import com.tlabs.eve.esi.model.ESIFitting;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIShip;
import com.tlabs.eve.net.EveRetrofit;
import com.tlabs.eve.net.EveStore;
import com.tlabs.eve.net.EveToken;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ESIRetrofit extends EveRetrofit implements ESIService {


    private interface VerifyService {
        @GET("/oauth/verify")
        Call<ESICharacterStatus> getVerification(@Header("Authorization") String token);
    }

    private static final String SOURCE = "tranquility";
    private static final Logger LOG = LoggerFactory.getLogger(ESIRetrofit.class);

    private final PublicRetrofit rPublic;
    private final CharacterRetrofit rCharacter;
    private final CorporationRetrofit rCorporation;
    private final MailRetrofit rMail;
    private final FittingRetrofit rFitting;
    private final ContactRetrofit rContact;

    private final VerifyService verify;

    public ESIRetrofit(
            final String host,
            final String login,
            final OAuth20Service oAuth,
            final EveStore store,
            final String agent,
            final long timeout,
            final String refresh) {

        super(host, login, oAuth, store, agent, timeout, refresh, ESIConverters.gson());

        this.rPublic = new PublicRetrofit(getRetrofit(), SOURCE);
        this.rCharacter = new CharacterRetrofit(getRetrofit(), SOURCE);
        this.rCorporation = new CorporationRetrofit(getRetrofit(), SOURCE);
        this.rMail = new MailRetrofit(getRetrofit(), SOURCE);
        this.rContact = new ContactRetrofit(getRetrofit(), SOURCE);
        this.rFitting = new FittingRetrofit(getRetrofit(), SOURCE);

        OkHttpClient.Builder verifyClient =
                new OkHttpClient.Builder()
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
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public List<ESIName> getNames(List<Long> ids) {
        try {
            return this.rPublic.getNames(ids);
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public ESICharacterStatus getCharacterStatus() {
        try {
            return verifyCharacterStatus();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public ESICharacter getCharacter() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCharacter(status.getCharacterID());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public ESILocation getCharacterLocation() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCharacterLocation(status.getCharacterID());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public ESIShip getCharacterShip() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCharacterShip(status.getCharacterID());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public ESICalendar getCalendar(Long afterEventID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.getCalendar(status.getCharacterID(), afterEventID);
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }

    }

    @Override
    public boolean postCalendarEvent(Long eventID, ESICalendar.Event.Response response) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rCharacter.postCalendarEvent(status.getCharacterID(), eventID, response);
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteMail(Long mailID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.deleteMail(status.getCharacterID(), mailID);

        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public List<ESIMail> getMails(Long afterMailID, String... labels) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMails(status.getCharacterID(), afterMailID, labels);
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<ESIMailbox> getMailboxes() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMailboxes(status.getCharacterID());
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public ESIMail getMailContent(Long mailID) {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rMail.getMailContent(status.getCharacterID(), mailID);
        }
        catch (IOException e) {
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
        catch (IOException e) {
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
        catch (IOException e) {
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
        catch (IOException e) {
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
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public ESIKillMail getKillMail(ESIKillMail killMail) {
        try {
            return this.rMail.getKillMail(killMail);
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<ESIFitting> getFittings() {
        try {
            final ESICharacterStatus status = verifyCharacterStatus();
            return this.rFitting.getFittings(status.getCharacterID());
        }
        catch (IOException e) {
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
        catch (IOException e) {
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
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
            return false;
        }
    }

    private ESICharacterStatus verifyCharacterStatus() throws IOException {
        final EveToken stored = verify();
        Response<ESICharacterStatus> r = this.verify.getVerification("Bearer " + stored.getAccessToken()).execute();
        if (r.isSuccessful()) {
            return r.body();
        }
        throw new IOException(r.message());
    }
}
