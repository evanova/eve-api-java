package com.tlabs.eve;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tlabs.eve.api.AccessInfo;
import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.api.character.CharacterRequest;
import com.tlabs.eve.api.corporation.CorporationRequest;
import com.tlabs.eve.net.DefaultEveNetwork;

import org.apache.commons.io.IOUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.rules.ExternalResource;

import java.io.InputStream;

public class EveResource extends ExternalResource {

    private static final class ApiKey {
        @JsonProperty
        public String apiKey;

        @JsonProperty
        public String vCode;

        @JsonIgnore
        private AccessInfo accessInfo;
    }

    static class Configuration {
        private static final ObjectMapper mapper = new ObjectMapper();

        @JsonProperty
        private ApiKey account;

        @JsonProperty
        private ApiKey character;

        @JsonProperty
        private ApiKey corporation;

        public static Configuration from(final String json) {
            final InputStream in = Configuration.class.getResourceAsStream(json);
            if (null == in) {
                throw new IllegalArgumentException(json + " not found");

            }
            try {
                return mapper.readValue(in, Configuration.class);
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
            finally {
                IOUtils.closeQuietly(in);
            }
        }
    }

    private EveNetwork eve;
    private final Configuration configuration;

    public EveResource(final String apiJSON) {
        configuration = Configuration.from(apiJSON);
    }

    @Override
    protected void before() throws Throwable {
        eve = new DefaultEveNetwork();
    }

    @Override
    protected void after() {
        eve = null;
    }

    protected final AccessInfo getAccountInfo() {
        setAccessInfo(configuration.account);
        return configuration.account.accessInfo;
    }

    protected final AccessInfo getCharacterInfo() {
        setAccessInfo(configuration.character);
        return configuration.character.accessInfo;
    }

    protected final AccessInfo getCorporationInfo() {
        setAccessInfo(configuration.corporation);
        return configuration.corporation.accessInfo;
    }

    protected final <T extends EveResponse> T execute(final EveRequest<T> request) {
        if (!(request instanceof EveAPIRequest.Authenticated)) {
            return execute(request, null);
        }
        if (request instanceof CharacterRequest) {
            return execute(request, configuration.character);
        }
        if (request instanceof CorporationRequest) {
            return execute(request, configuration.corporation);
        }
        return execute(request, configuration.account);
    }

    protected final <T extends EveResponse> T execute(final EveRequest<T> request, final ApiKey apiKey) {
        if (request instanceof EveAPIRequest.Authenticated) {
            if (nullApiKey(apiKey)) {
                Assert.assertTrue(!(request instanceof EveAPIRequest.Authenticated));
            }
            else {
                Assert.assertTrue(
                        "API key not set.",
                        (null != apiKey) && StringUtils.isNotBlank(apiKey.vCode) && StringUtils.isNotBlank(apiKey.apiKey));

                request.putParam("keyID", apiKey.apiKey);
                request.putParam("vCode", apiKey.vCode);
            }
        }

        final T response = eve.execute(request);
        Assert.assertFalse(response.getErrorMessage(), response.hasError());
        return response;
    }

    private void setAccessInfo(final ApiKey apiKey) {
        if (null == apiKey.accessInfo) {
            final AccessInfoRequest request = new AccessInfoRequest(apiKey.apiKey, apiKey.vCode);
            request.putParam("keyID", apiKey.apiKey);
            request.putParam("vCode", apiKey.vCode);
            final AccessInfoResponse info = execute(new AccessInfoRequest(apiKey.apiKey, apiKey.vCode));
            apiKey.accessInfo = info.getAccessInfo();
        }
    }

    private boolean nullApiKey(final ApiKey key) {
        return (null == key) || (null == key.apiKey) || (null == key.vCode);
    }
}
