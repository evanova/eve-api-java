package com.tlabs.eve.esi;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.tlabs.eve.esi.impl.ESIServiceImpl;
import com.tlabs.eve.net.EveStore;
import com.tlabs.eve.net.EveToken;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ESIClient {

    public static final String[] SCOPES = {
            "corporationContactsRead",
            "publicData",
            "characterStatsRead",
            "characterFittingsRead",
            "characterFittingsWrite",
            "characterContactsRead",
            "characterContactsWrite",
            "characterLocationRead",
            "characterNavigationWrite",
            "characterWalletRead",
            "characterAssetsRead",
            "characterCalendarRead",
            "characterFactionalWarfareRead",
            "characterIndustryJobsRead",
            "characterKillsRead",
            "characterMailRead",
            "characterMarketOrdersRead",
            "characterMedalsRead",
            "characterNotificationsRead",
            "characterResearchRead",
            "characterSkillsRead",
            "characterAccountRead",
            "characterContractsRead",
            "characterBookmarksRead",
            "characterChatChannelsRead",
            "characterClonesRead",
            "characterOpportunitiesRead",
            "characterLoyaltyPointsRead",
            "corporationWalletRead",
            "corporationAssetsRead",
            "corporationMedalsRead",
            "corporationFactionalWarfareRead",
            "corporationIndustryJobsRead",
            "corporationKillsRead",
            "corporationMembersRead",
            "corporationMarketOrdersRead",
            "corporationStructuresRead",
            "corporationShareholdersRead",
            "corporationContractsRead",
            "corporationBookmarksRead",
            "fleetRead",
            "fleetWrite",
            "structureVulnUpdate",
            "remoteClientUI",
            "esi-calendar.respond_calendar_events.v1",
            "esi-calendar.read_calendar_events.v1",
            "esi-location.read_location.v1",
            "esi-location.read_ship_type.v1",
            "esi-mail.organize_mail.v1",
            "esi-mail.read_mail.v1",
            "esi-mail.send_mail.v1",
            "esi-skills.read_skills.v1",
            "esi-skills.read_skillqueue.v1",
            "esi-wallet.read_character_wallet.v1",
            "esi-search.search_structures.v1",
            "esi-clones.read_clones.v1",
            "esi-characters.read_contacts.v1",
            "esi-universe.read_structures.v1",
            "esi-bookmarks.read_character_bookmarks.v1",
            "esi-killmails.read_killmails.v1",
            "esi-corporations.read_corporation_membership.v1",
            "esi-assets.read_assets.v1",
            "esi-planets.manage_planets.v1",
            "esi-fleets.read_fleet.v1",
            "esi-fleets.write_fleet.v1",
            "esi-ui.open_window.v1",
            "esi-ui.write_waypoint.v1",
            "esi-characters.write_contacts.v1",
            "esi-fittings.read_fittings.v1",
            "esi-fittings.write_fittings.v1",
            "esi-markets.structure_markets.v1",
            "esi-corporations.read_structures.v1",
            "esi-corporations.write_structures.v1",
            "esi-characters.read_loyalty.v1",
            "esi-characters.read_opportunities.v1",
            "esi-characters.read_chat_channels.v1",
            "esi-characters.read_medals.v1",
            "esi-characters.read_standings.v1",
            "esi-characters.read_agents_research.v1",
            "esi-industry.read_character_jobs.v1",
            "esi-markets.read_character_orders.v1",
            "esi-characters.read_blueprints.v1",
            "esi-characters.read_corporation_roles.v1",
            "esi-location.read_online.v1",
            "esi-contracts.read_character_contracts.v1",
            "esi-clones.read_implants.v1",
            "esi-characters.read_fatigue.v1",
            "esi-killmails.read_corporation_killmails.v1"
    };

    private static final Logger LOG = LoggerFactory.getLogger(ESIClient.class);

    private static final String LOGIN = "login.eveonline.com";
    private static final String ESI = "esi.tech.ccp.is";

    private static final String AGENT = "eve-esi-java (https://github.com/evanova/eve-esi-java)";

    private static final class ESIOAuth extends com.github.scribejava.core.builder.api.DefaultApi20 {
        private final String loginHost;

        public ESIOAuth(String loginHost) {
            this.loginHost = loginHost;
        }

        @Override
        public String getAccessTokenEndpoint() {
            return "https://"  + loginHost + "/oauth/token";
        }

        @Override
        protected String getAuthorizationBaseUrl() {
            return "https://"  + loginHost + "/oauth/authorize";
        }
    }

    public static final class Builder {

        private final List<String> scopes;
        private EveStore store = EveStore.DEFAULT;

        private String loginHost = LOGIN;
        private String esiHost = ESI;

        private String clientID;
        private String clientKey;
        private String clientRedirect = "http://localhost/redirect";

        private String userAgent = AGENT;
        private long timeout = 30L * 1000L;

        private File cache;

        public Builder() {
            this.scopes = new ArrayList<>();
        }

        public ESIClient.Builder store(final EveStore store) {
            this.store = store;
            return this;
        }

        public ESIClient.Builder login(final String host) {
            this.loginHost = host;
            return this;
        }

        public ESIClient.Builder api(final String host) {
            this.esiHost = host;
            return this;
        }

        public ESIClient.Builder id(final String clientID) {
            this.clientID = clientID;
            return this;
        }

        public ESIClient.Builder key(final String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public ESIClient.Builder redirect(final String to) {
            this.clientRedirect = to;
            return this;
        }

        public ESIClient.Builder timeout(final long timeoutInMillis) {
            this.timeout = timeoutInMillis;
            return this;
        }


        public ESIClient.Builder scopes(final String... scopes) {
            for (String s: scopes) {
                if (!this.scopes.contains(s)) {
                    this.scopes.add(s);
                }
            }
            return this;
        }

        public ESIClient.Builder agent(final String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder cache(File cache) {
            this.cache = cache;
            return this;
        }

        public final ESIClient build() {
            return new ESIClient(
                    this.loginHost,
                    this.esiHost,
                    this.clientID,
                    this.clientKey,
                    this.clientRedirect,
                    this.userAgent,
                    this.store,
                    this.cache,
                    this.timeout,
                    this.scopes.toArray(new String[this.scopes.size()]));
        }
    }

    private final OAuth20Service oAuth;
    private final String esiHost;
    private final String loginHost;

    private final String userAgent;

    private final EveStore store;
    private final long timeout;

    private File cache = null;

    private ESIClient(
            final String loginHost,
            final String esiHost,
            final String clientID,
            final String clientKey,
            final String callback,
            final String userAgent,
            final EveStore store,
            final File cache,
            final long timeout,
            final String... scopes) {

        this.esiHost = esiHost;
        this.loginHost = loginHost;
        this.userAgent = userAgent;
        this.timeout = timeout;
        this.store = store;
        this.cache = cache;
        StringBuilder scope = new StringBuilder();
        if (!ArrayUtils.isEmpty(scopes)) {
            for (String s : scopes) {
                scope.append(s);
                scope.append(" ");
            }
        }
        this.oAuth = new ServiceBuilder()
                .apiKey(clientID)
                .apiSecret(clientKey)
                .scope(StringUtils.removeEnd(scope.toString(), " "))
                .callback(callback)
                .build(new ESIOAuth(loginHost));
    }

    public static ESIClient.Builder TQ(String... scopes) {
        return new ESIClient.Builder()
                .login(LOGIN)
                .api(ESI)
                .scopes(scopes);
    }

    public static ESIClient.Builder TQ() {
        return new ESIClient.Builder()
                .login(LOGIN)
                .api(ESI)
                .scopes("publicData");
    }

    public String getAuthorizationUrl() {
        return this.oAuth.getAuthorizationUrl();
    }

    public EveToken fromAuthCode(final String authCode) {
        try {
            final OAuth2AccessToken token = this.oAuth.getAccessToken(authCode);
            return save(token);
        }
        catch (OAuthException | IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public EveToken fromRefresh(final String refresh) {
        try {
            EveToken existing = this.store.get(refresh);
            if ((null == existing) || (existing.getExpiresOn() < (System.currentTimeMillis() - 5 * 1000))) {
                final OAuth2AccessToken token = this.oAuth.refreshAccessToken(refresh);
                return save(token);
            }
            return existing;
        }
        catch (OAuthException | IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public ESIService obtain(final String refresh) {
        return new ESIServiceImpl(
                this.esiHost,
                this.loginHost,
                this.oAuth,
                this.store,
                this.userAgent,
                this.timeout,
                this.cache,
                1 * 1024 * 1024,
                refresh);
    }

    private EveToken save(final OAuth2AccessToken token) {
        EveToken returned =
                new EveToken()
                        .setAccessToken(token.getAccessToken())
                        .setRefreshToken(token.getRefreshToken())
                        .setTokenType(token.getTokenType())
                        .setScope(token.getScope())
                        .setExpiresIn(token.getExpiresIn());
        this.store.save(returned);
        return returned;
    }

}
