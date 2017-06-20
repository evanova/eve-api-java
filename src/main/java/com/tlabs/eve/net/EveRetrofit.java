package com.tlabs.eve.net;

import com.github.scribejava.core.exceptions.OAuthException;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EveRetrofit {

    private static final Logger LOG = LoggerFactory.getLogger(EveRetrofit.class);

    protected static final class ClientInterceptor implements Interceptor {
        private final EveRetrofit cr;

        public ClientInterceptor(EveRetrofit cr) {
            this.cr = cr;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder =
                    chain
                            .request()
                            .newBuilder();
            final EveToken token = cr.store.get(cr.refresh);
            if (null != token) {
                builder.addHeader("Authorization", "Bearer " + token.getAccessToken());
            }
            return chain.proceed(builder.build());
        }
    }

    protected static final class RetryInterceptor implements Interceptor {
        private final EveRetrofit cr;

        public RetryInterceptor(EveRetrofit cr) {
            this.cr = cr;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Response r = chain.proceed(chain.request());
            if (r.isSuccessful()) {
                return r;
            }
            if (r.body().string().contains("invalid_token")) {
                cr.refreshToken();
                r = chain.proceed(chain.request());
            }
            return r;
        }
    }

    protected static final class UserAgentInterceptor implements  Interceptor {
        private final String host;
        private final String agent;

        public UserAgentInterceptor(String host, String agent) {
            this.host = host;
            this.agent = agent;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder =
                    chain
                            .request()
                            .newBuilder()
                            //.addHeader("Host", host)
                            .addHeader("User-Agent", agent);
            return chain.proceed(builder.build());
        }
    }

    private final String host;

    private final Retrofit retrofit;
    private final OkHttpClient httpClient;

    private final OAuth20Service oAuth;
    private final EveStore store;
    private final String refresh;

    protected EveRetrofit(
            final String host,
            final String login,
            final OAuth20Service oAuth,
            final EveStore store,
            final String agent,
            final long timeout,
            final String refresh,
            final Converter.Factory converter) {

        Validate.isTrue(StringUtils.isNotBlank(host), "host parameter cannot be empty.");
        Validate.isTrue(StringUtils.isNotBlank(login), "login parameter cannot be empty.");
        Validate.isTrue(StringUtils.isNotBlank(agent), "agent parameter cannot be empty.");

        Validate.notNull(oAuth, "oAuth parameter cannot be null.");
        Validate.notNull(store, "store parameter cannot be null.");

        this.host = host;
        this.store = store;
        this.refresh = refresh;
        this.oAuth = oAuth;

        OkHttpClient.Builder retrofitClient =
                new OkHttpClient.Builder()
                        .readTimeout(timeout, TimeUnit.MILLISECONDS)
                        .addInterceptor(new EveRetrofit.UserAgentInterceptor(host, agent))
                        .addInterceptor(new EveRetrofit.ClientInterceptor(this))
                        .addInterceptor(new EveRetrofit.RetryInterceptor(this));
        if (LOG.isDebugEnabled()) {
            retrofitClient = retrofitClient
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        this.httpClient = retrofitClient.build();
        this.retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://" + host + "/")
                        .addConverterFactory(converter)
                        .client(this.httpClient)
                        .build();
    }

    protected final Retrofit getRetrofit() {
        return retrofit;
    }

    protected final OkHttpClient getClient() {
        return httpClient;
    }

    protected final EveToken verify() throws IOException {
        try {
            return verifyImpl();
        }
        catch (OAuthException e) {
            throw new IOException(e);
        }
    }

    protected final String getHost() {
        return host;
    }

    private EveToken verifyImpl() throws IOException, OAuthException {
        if (StringUtils.isBlank(this.refresh)) {
            throw new IOException("No refresh token available");
        }

        EveToken stored = this.store.get(this.refresh);
        if (null == stored) {
            stored = new EveToken().setRefreshToken(this.refresh);
            this.store.save(stored);
        }

        if (StringUtils.isBlank(stored.getAccessToken())) {
            updateToken(stored, this.oAuth.refreshAccessToken(this.refresh));
            this.store.save(stored);
        }
        return stored;
    }

    private void refreshToken() throws IOException {
        EveToken stored = this.store.get(this.refresh);
        updateToken(stored, this.oAuth.refreshAccessToken(stored.getRefreshToken()));
        this.store.save(stored);
    }

    private static void updateToken(final EveToken token, OAuth2AccessToken with) {
        LOG.debug("updateToken {} -> {} ", token.getAccessToken(), with.getAccessToken());
        token.setAccessToken(with.getAccessToken());
        token.setExpiresIn(with.getExpiresIn());
        token.setScope(with.getScope());
        token.setTokenType(with.getTokenType());
    }
}
