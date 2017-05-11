package com.tlabs.eve.crest.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.tlabs.eve.crest.CrestService;
import com.tlabs.eve.crest.model.CrestCharacter;
import com.tlabs.eve.crest.model.CrestCharacterStatus;
import com.tlabs.eve.crest.model.CrestContact;
import com.tlabs.eve.crest.model.CrestDictionary;
import com.tlabs.eve.crest.model.CrestFitting;
import com.tlabs.eve.crest.model.CrestInventoryItem;
import com.tlabs.eve.crest.model.CrestItem;
import com.tlabs.eve.crest.model.CrestLocation;
import com.tlabs.eve.crest.model.CrestMarketBulkOrder;
import com.tlabs.eve.crest.model.CrestMarketHistory;
import com.tlabs.eve.crest.model.CrestMarketOrder;
import com.tlabs.eve.crest.model.CrestMarketPrice;
import com.tlabs.eve.crest.model.CrestServerStatus;
import com.tlabs.eve.crest.model.CrestSolarSystem;
import com.tlabs.eve.crest.model.CrestType;
import com.tlabs.eve.crest.model.CrestWaypoint;
import com.tlabs.eve.net.EveStore;
import com.tlabs.eve.net.EveToken;
import com.tlabs.eve.net.EveRetrofit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class CrestRetrofit extends EveRetrofit implements CrestService {

    private static final ObjectMapper JACKSON;
    static {
        JACKSON = new ObjectMapper();
        JACKSON.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    interface VerifyService {
        @GET("/oauth/verify")
        Call<CrestCharacterStatus> getVerification(@Header("Authorization") String token);
    }

    private static final Logger LOG = LoggerFactory.getLogger(CrestRetrofit.class);

    private final CrestRetrofitService retrofit;
    private final VerifyService verify;

    protected CrestRetrofit(
            final String host,
            final String login,
            final OAuth20Service oAuth,
            final EveStore store,
            final String agent,
            final long timeout,
            final String refresh) {
        super(host, login, oAuth, store, agent, timeout, refresh, JacksonConverterFactory.create(JACKSON));

        this.retrofit = getRetrofit().create(CrestRetrofitService.class);

        OkHttpClient.Builder verifyClient =
                new OkHttpClient.Builder()
                        .addInterceptor(new UserAgentInterceptor(login, agent));
        if (LOG.isDebugEnabled()) {
            verifyClient = verifyClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        this.verify =
                new Retrofit.Builder()
                .baseUrl("https://" + login + "/")
                .addConverterFactory(JacksonConverterFactory.create(JACKSON))
                .client(verifyClient.build())
                .build()
                .create(VerifyService.class);
    }

    @Override
    public final CrestServerStatus getServerStatus() {
        try {
            return this.retrofit.getServerStatus().execute().body();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final CrestSolarSystem getSolarSystem(long solarSystemId) {
        try {
            return this.retrofit.getSolarSystem(solarSystemId).execute().body();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public CrestType getInventoryType (int typeId) {
        try {
            return this.retrofit.getInventoryType(typeId).execute().body();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestSolarSystem> getLocations() {
        try {
            return this.retrofit.getSolarSystems().execute().body().getItems();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestItem> getRegions ( ) {
        try {
            final List<CrestItem> returned = new ArrayList<>();
            CrestDictionary<CrestItem> dictionary;
            int page = 0;
            do {
                page = page + 1;
                dictionary = this.retrofit.getRegions().execute().body();
                if (null == dictionary) {
                    LOG.error("getRegions: null dictionary");
                    break;
                }
                returned.addAll(dictionary.getItems());
            } while (dictionary.getPageCount() > page);
            return returned;
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final CrestCharacterStatus getCharacterStatus() {
        try {
            return verifyCharacterStatus();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final CrestCharacter getCharacter() {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            final CrestCharacter character = this.retrofit.getCharacter(status.getCharacterID()).execute().body();
            return character;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final CrestLocation getLocation() {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            return this.retrofit.getLocation(status.getCharacterID()).execute().body();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestContact> getContacts() {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            final List<CrestContact> returned = new ArrayList<>();

            CrestDictionary<CrestContact> dictionary;
            int page = 0;
            do {
                page = page + 1;
                dictionary = this.retrofit.getContacts(status.getCharacterID(), page).execute().body();
                returned.addAll(dictionary.getItems());
            }
            while ((null != dictionary) && dictionary.getPageCount() > page);

            return returned;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final CrestContact getContact(long contactID) {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            return this.retrofit.getContact(status.getCharacterID(), contactID).execute().body();
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final boolean addContact(CrestContact contact) {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();

            contact.setBlocked(null);
            contact.setWatched(null);
            contact.setHref(null);
            contact.setCharacter(null);

            final CrestItem sudo = new CrestItem();
            sudo.setId(contact.getContact().getId());
            sudo.setHref(href("characters/" + contact.getContact().getId()));
            sudo.setName("");
            contact.setContact(sudo);

            final Response r = this.retrofit.postContact(status.getCharacterID(), contact).execute();
            if (r.isSuccessful()) {
                return true;
            }

            LOG.warn("addContact: {}\n{}", r.message(), r.errorBody().string());
            return false;

        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public final boolean deleteContact(long contactID) {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            Response<Void> r = this.retrofit.deleteContact(status.getCharacterID(), contactID).execute();
            if (r.isSuccessful()) {
                return true;
            }

            LOG.warn("deleteContact: {}\n{}", r.message(), r.errorBody().string());
            return false;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public final List<CrestFitting> getFittings() {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();

            final List<CrestFitting> returned = new ArrayList<>();
            CrestDictionary<CrestFitting> dictionary;
            int page = 0;
            do {
                page = page + 1;
                dictionary = this.retrofit.getFittings(status.getCharacterID(), page).execute().body();
                if (null == dictionary) {
                    LOG.error("getFittings: null dictionary");
                }
                else {
                    returned.addAll(dictionary.getItems());
                }
            }
            while ((null != dictionary) && dictionary.getPageCount() > page);

            return returned;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final boolean addFitting(CrestFitting fitting) {
        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            fitting.getShip().setHref(href("inventory/types/" + fitting.getShip().getId()));
            for (CrestInventoryItem i: fitting.getInventory()) {
                i.getItem().setHref(href("inventory/types/" + i.getItem().getId()));
            }
            final Response r = this.retrofit.postFitting(status.getCharacterID(), fitting).execute();
            if (r.isSuccessful()) {
                return true;
            }

            LOG.warn("addFitting: {}\n{}", r.message(), r.errorBody().string());
            return false;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public final boolean deleteFitting(long fittingID) {

        try {
            final CrestCharacterStatus status = verifyCharacterStatus();
            final Response<Void> r = this.retrofit.deleteFitting(status.getCharacterID(), fittingID).execute();
            if (r.isSuccessful()) {
                return true;
            }

            LOG.warn("deleteFitting: {}\n{}", r.message(), r.errorBody().string());
            return false;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public final boolean addWaypoints(List<CrestWaypoint> waypoints) {
        return setWaypoints(waypoints, false);
    }

    @Override
    public final boolean setWaypoints(final List<CrestWaypoint> waypoints) {
        return setWaypoints(waypoints, true);
    }

    private boolean setWaypoints(final List<CrestWaypoint> waypoints, final boolean replace) {
        Validate.isTrue(!waypoints.isEmpty(), "Waypoint list cannot be empty.");

        try {
            final CrestCharacterStatus status = verifyCharacterStatus();

            boolean first = replace;
            for (CrestWaypoint wp: waypoints) {
                wp.setClearOtherWaypoints(first);
                wp.setFirst(first);
                wp.getSolarSystem().setHref(href("/solarsystems/" + wp.getSolarSystem().getId()));
                first = false;

                final Response<Void> r = this.retrofit.addWaypoint(status.getCharacterID(), wp).execute();
                if (!r.isSuccessful()) {
                    LOG.warn("addWaypoint: {}\n{}", r.message(), r.errorBody().string());
                    return false;
                }
            }
            return true;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return false;
        }
    }

    @Override
    public final List<CrestMarketHistory> getMarketHistory(long regionId, long itemId) {
        try {
            final List<CrestMarketHistory> returned = new ArrayList<>();
            CrestDictionary<CrestMarketHistory> dictionary;

            final String typePath = href("inventory/types/") + itemId;
            dictionary = this.retrofit.getMarketHistory(regionId, typePath).execute().body();
            if (null == dictionary) {
                LOG.error("getMarketHistory: null dictionary {}, {}", regionId, itemId);
                return returned;
            }
            returned.addAll(dictionary.getItems());
            return returned;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestMarketOrder> getMarketOrders(final long regionId, final String orderType, final long itemId) {
        try {
            // TODO: Change this so that it pulls the url from the root CREST
            // endpoint
            final String typePath = href("inventory/types/") + itemId;
            CrestDictionary<CrestMarketOrder> dictionary =
                    this.retrofit.getMarketOrders(regionId, orderType, typePath).execute().body();
            if (null == dictionary) {
                LOG.error("getMarketHistory: null dictionary {}, {}", regionId, itemId);
                return Collections.emptyList();
            }
            return dictionary.getItems();
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestMarketBulkOrder> getAllMarketOrders(final long regionId) {
        try {
            final List<CrestMarketBulkOrder> returned = new ArrayList<>();
            CrestDictionary<CrestMarketBulkOrder> dictionary;
            int page = 0;
            do {
                page = page + 1;
                dictionary = retrofit.getAllMarketOrders(regionId, page).execute().body();
                if (null == dictionary) {
                    LOG.error("getAllMarketOrders: null dictionary {}", regionId);
                    break;
                }
                returned.addAll(dictionary.getItems());
            } while (dictionary.getPageCount() > page);
            return returned;
        } catch (IOException e) {
            LOG.error(e.getLocalizedMessage(), e);
            return null;
        }
    }

    @Override
    public final List<CrestMarketPrice> getAllMarketPrices() {
        try {
            final List<CrestMarketPrice> returned = new ArrayList<>();

            CrestDictionary<CrestMarketPrice> dictionary;
            int page = 0;
            do {
                page = page + 1;
                dictionary = retrofit.getAllMarketPrices(page).execute().body();
                if (null == dictionary) {
                    LOG.error("getAllMarketPrices: null dictionary {}", page);
                    break;
                }
                returned.addAll(dictionary.getItems());
            } while (dictionary.getPageCount() > page);
            return returned;
        }
        catch (IOException e) {
            LOG.error(e.getLocalizedMessage());
            return null;
        }
    }

    private String href(String path) {
        return new StringBuilder()
                .append("https://")
                .append(getHost())
                .append("/")
                .append(path)
                .append("/")
                .toString();
    }

    private CrestCharacterStatus verifyCharacterStatus() throws IOException {
        final EveToken stored = verify();
        Response<CrestCharacterStatus> r = this.verify.getVerification("Bearer " + stored.getAccessToken()).execute();
        if (r.isSuccessful()) {
            return r.body();
        }
        throw new IOException(r.message());
    }

}
