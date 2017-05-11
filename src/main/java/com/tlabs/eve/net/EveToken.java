package com.tlabs.eve.net;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class EveToken {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    //@JsonProperty("expires_in")
   private long expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty
    private String scope;

    private final long created = System.currentTimeMillis();

    public String getAccessToken() {
        return accessToken;
    }

	public EveToken setAccessToken(final String token) {
		this.accessToken = token;
        return this;
	}

    public String getTokenType() {
        return tokenType;
    }

	public EveToken setTokenType(String tokenType) {
		this.tokenType = tokenType;
        return this;
	}

    public String getScope() {
        return scope;
    }

    public EveToken setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public long getExpiresOn() {
        return created + (expiresIn * 1000);
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public EveToken setRefreshToken(final String token) {
		this.refreshToken = token;
        return this;
	}

    public EveToken setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
