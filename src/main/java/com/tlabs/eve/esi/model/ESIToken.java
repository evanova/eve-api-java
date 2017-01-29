package com.tlabs.eve.esi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class ESIToken {

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

	public ESIToken setAccessToken(final String token) {
		this.accessToken = token;
        return this;
	}

    public String getTokenType() {
        return tokenType;
    }

	public ESIToken setTokenType(String tokenType) {
		this.tokenType = tokenType;
        return this;
	}

    public String getScope() {
        return scope;
    }

    public ESIToken setScope(String scope) {
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

    public ESIToken setRefreshToken(final String token) {
		this.refreshToken = token;
        return this;
	}

    public ESIToken setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
