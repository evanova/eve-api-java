package com.tlabs.eve.esi;

import com.tlabs.eve.EveNetwork;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;
import com.tlabs.eve.esi.character.ESICharacterInfoRequest;
import com.tlabs.eve.esi.character.ESICharacterInfoResponse;
import com.tlabs.eve.esi.character.ESICharacterLocationRequest;
import com.tlabs.eve.esi.character.ESICharacterLocationResponse;
import com.tlabs.eve.esi.character.ESICharacterMailContentRequest;
import com.tlabs.eve.esi.character.ESICharacterMailContentResponse;
import com.tlabs.eve.esi.character.ESICharacterMailDeleteRequest;
import com.tlabs.eve.esi.character.ESICharacterMailDeleteResponse;
import com.tlabs.eve.esi.character.ESICharacterMailHeadersRequest;
import com.tlabs.eve.esi.character.ESICharacterMailHeadersResponse;
import com.tlabs.eve.esi.character.ESICharacterMailLabelsRequest;
import com.tlabs.eve.esi.character.ESICharacterMailLabelsResponse;
import com.tlabs.eve.esi.character.ESICharacterMailUpdateRequest;
import com.tlabs.eve.esi.character.ESICharacterMailUpdateResponse;
import com.tlabs.eve.esi.character.ESICharacterShipRequest;
import com.tlabs.eve.esi.character.ESICharacterShipResponse;
import org.apache.commons.lang3.StringUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class ESINetwork implements EveNetwork, Closeable {
    private static final Map<Class<? extends ESIRequest>, Handler> HANDLERS;

    interface Handler<Q extends ESIRequest<R>, R extends ESIResponse> {
        boolean handle(final Q request, final R response, final ESIService service);
    }

    static {
        HANDLERS = new HashMap<>();
        HANDLERS.put(ESICharacterInfoRequest.class, new Handler<ESICharacterInfoRequest, ESICharacterInfoResponse>() {
            @Override
            public boolean handle(ESICharacterInfoRequest request, ESICharacterInfoResponse response, ESIService service) {
                response.setCharacter(service.getCharacter(request.getCharacterID()));
                return (null != response.getCharacter());
            }
        });
        HANDLERS.put(ESICharacterLocationRequest.class, new Handler<ESICharacterLocationRequest, ESICharacterLocationResponse>() {
            @Override
            public boolean handle(ESICharacterLocationRequest request, ESICharacterLocationResponse response, ESIService service) {
                response.setLocation(service.getCharacterLocation(request.getCharacterID()));
                return (null != response.getLocation());
            }
        });
        HANDLERS.put(ESICharacterShipRequest.class, new Handler<ESICharacterShipRequest, ESICharacterShipResponse>() {
            @Override
            public boolean handle(ESICharacterShipRequest request, ESICharacterShipResponse response, ESIService service) {
                response.setShip(service.getCharacterShip(request.getCharacterID()));
                return (null != response.getShip());
            }
        });
        HANDLERS.put(ESICharacterMailLabelsRequest.class, new Handler<ESICharacterMailLabelsRequest, ESICharacterMailLabelsResponse>() {
            @Override
            public boolean handle(ESICharacterMailLabelsRequest request, ESICharacterMailLabelsResponse response, ESIService service) {
                response.setMailboxes(service.getMailboxes(request.getCharacterID()));
                return (null != response.getMailboxes());
            }
        });
        HANDLERS.put(ESICharacterMailHeadersRequest.class, new Handler<ESICharacterMailHeadersRequest, ESICharacterMailHeadersResponse>() {
            @Override
            public boolean handle(ESICharacterMailHeadersRequest request, ESICharacterMailHeadersResponse response, ESIService service) {
                response.setMails(service.getMails(request.getCharacterID(), request.getLastMailID()));
                return (null != response.getMails());
            }
        });
        HANDLERS.put(ESICharacterMailContentRequest.class, new Handler<ESICharacterMailContentRequest, ESICharacterMailContentResponse>() {
            @Override
            public boolean handle(ESICharacterMailContentRequest request, ESICharacterMailContentResponse response, ESIService service) {
                response.setMail(service.getMailContent(request.getCharacterID(), request.getMailID()));
                return (null != response.getMail());
            }
        });
        HANDLERS.put(ESICharacterMailUpdateRequest.class, new Handler<ESICharacterMailUpdateRequest, ESICharacterMailUpdateResponse>() {
            @Override
            public boolean handle(ESICharacterMailUpdateRequest request, ESICharacterMailUpdateResponse response, ESIService service) {
                return service.updateMail(request.getCharacterID(), request.getMail());
            }
        });
        HANDLERS.put(ESICharacterMailDeleteRequest.class, new Handler<ESICharacterMailDeleteRequest, ESICharacterMailDeleteResponse>() {
            @Override
            public boolean handle(ESICharacterMailDeleteRequest request, ESICharacterMailDeleteResponse response, ESIService service) {
                return service.deleteMail(request.getCharacterID(), request.getMailID());
            }
        });
    }

    private final ESIClient esi;
    private final Map<String, ESIService> services;
    private final ESIService publicService;

    public ESINetwork(
            final String appId,
            final String appKey,
            final String[] scopes) {
        this(
            appId,
            appKey,
            "eve-api-java (https://github.com/evanova/eve-api-java)",
            scopes);
    }

    public ESINetwork(
            final String appId,
            final String appKey,
            final String agent,
            final String[] scopes) {

        this.esi =
                ESIClient.TQ(scopes)
                .agent(agent)
                .id(appId)
                .key(appKey)
                .build();

        this.services = new WeakHashMap<>();
        this.publicService = this.esi.newESIService();
    }

    @Override
    public void close() throws IOException {
        this.services.clear();
    }

    @Override
    public <Q extends EveRequest<R>, R extends EveResponse> R execute(Q request) {
        if (!(request instanceof ESIRequest)) {
            return null;
        }
        return (R)executeImpl((ESIRequest)request);
    }


    private <R extends ESIResponse, Q extends ESIRequest<R>> R executeImpl(final Q request) {
        final R response = request.create();
        final Handler<Q, R> h = (Handler<Q, R>)HANDLERS.get(request.getClass());

        if (null == h) {
            throw new IllegalArgumentException("No handler found for " + request.getClass().getSimpleName());
        }

        if (!h.handle(request, response, obtain(request))) {
            response.setErrorCode(500);
            response.setErrorMessage(request.getPage());
        }
        return response;
    }

    private synchronized ESIService obtain(final ESIRequest request) {
        if (StringUtils.isBlank(request.getRefreshToken())) {
            return this.publicService;
        }
        ESIService service = this.services.get(request.getRefreshToken());
        if (null == service) {
            service = this.esi.newESIService(request.getRefreshToken());
            this.services.put(request.getRefreshToken(), service);
        }
        return service;
    }

}
