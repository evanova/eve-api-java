package com.tlabs.eve.esi;

import com.tlabs.eve.EveNetwork;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;
import com.tlabs.eve.esi.character.ESICharacterAssetRequest;
import com.tlabs.eve.esi.character.ESICharacterAssetResponse;
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
import com.tlabs.eve.esi.character.ESICharacterMailPostRequest;
import com.tlabs.eve.esi.character.ESICharacterMailPostResponse;
import com.tlabs.eve.esi.character.ESICharacterMailUpdateRequest;
import com.tlabs.eve.esi.character.ESICharacterMailUpdateResponse;
import com.tlabs.eve.esi.character.ESICharacterShipRequest;
import com.tlabs.eve.esi.character.ESICharacterShipResponse;
import com.tlabs.eve.esi.character.ESICharacterStatusRequest;
import com.tlabs.eve.esi.character.ESICharacterStatusResponse;
import com.tlabs.eve.esi.character.ESICharacterStructureRequest;
import com.tlabs.eve.esi.character.ESICharacterStructureResponse;
import com.tlabs.eve.esi.model.ESIAsset;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIName;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class ESINetwork implements EveNetwork, Closeable {
    private static final Map<Class<? extends ESIRequest>, ESIHandler> HANDLERS;


    interface ESIHandler<Q extends ESIRequest<R>, R extends ESIResponse> {
        boolean handle(final Q request, final R response, final ESIService service);
    }

    public static final class Builder {

        private final List<String> scopes;

        private String clientID;
        private String clientKey;
        private String clientRedirect = "http://localhost/redirect";

        private String userAgent = "eve-api-java (https://github.com/evanova/eve-api-java)";
        private long timeout = 30L * 1000L;

        private File cache = null;
        public Builder() {
            this.scopes = new ArrayList<>();
        }

        public ESINetwork.Builder id(final String clientID) {
            this.clientID = clientID;
            return this;
        }

        public ESINetwork.Builder key(final String clientKey) {
            this.clientKey = clientKey;
            return this;
        }

        public ESINetwork.Builder redirect(final String to) {
            this.clientRedirect = to;
            return this;
        }

        public ESINetwork.Builder timeout(final long timeoutInMillis) {
            this.timeout = timeoutInMillis;
            return this;
        }

        public ESINetwork.Builder scopes(final String... scopes) {
            for (String s: scopes) {
                if (!this.scopes.contains(s)) {
                    this.scopes.add(s);
                }
            }
            return this;
        }

        public Builder cache(File cache) {
            this.cache = cache;
            return this;
        }

        public ESINetwork.Builder agent(final String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public final ESINetwork build() {
            return new ESINetwork(
                    this.clientID,
                    this.clientKey,
                    this.clientRedirect,
                    this.userAgent,
                    this.timeout,
                    this.cache,
                    this.scopes.toArray(new String[this.scopes.size()]));
        }
    }

    static {
        HANDLERS = new HashMap<>();

        HANDLERS.put(ESIStatusRequest.class, new ESIHandler<ESIStatusRequest, ESIStatusResponse>() {
            @Override
            public boolean handle(ESIStatusRequest request, ESIStatusResponse response, ESIService service) {
                response.setStatus(service.getServerStatus());
                return (null != response.getStatus());
            }
        });
        HANDLERS.put(ESINameRequest.class, new ESIHandler<ESINameRequest, ESINameResponse>() {
            @Override
            public boolean handle(ESINameRequest request, ESINameResponse response, ESIService service) {
                final List<ESIName> names = service.getNames(request.getIds());
                if (null == names) {
                    return false;
                }
                response.setNames(names);
                return true;
            }
        });
        HANDLERS.put(ESIMarketStatisticsRequest.class, new ESIHandler<ESIMarketStatisticsRequest, ESIMarketStatisticsResponse>() {
            @Override
            public boolean handle(ESIMarketStatisticsRequest request, ESIMarketStatisticsResponse response, ESIService service) {
                response.setOrders(service.getMarketOrders(request.getRegionID(), request.getTypeID()));
                response.setHistory(service.getMarketHistory(request.getRegionID(), request.getTypeID()));
                return (null != response.getHistory() && null != response.getOrders());
            }
        });
        HANDLERS.put(ESIUniverseStatisticsRequest.class, new ESIHandler<ESIUniverseStatisticsRequest, ESIUniverseStatisticsResponse>() {
            @Override
            public boolean handle(ESIUniverseStatisticsRequest request, ESIUniverseStatisticsResponse response, ESIService service) {
                final Map<Long, ESILocation.SolarSystem> systems = service.getSolarSystemStatistics();
                if (null == systems) {
                    return false;
                }
                response.setStatistics(systems);
                return true;
            }
        });
        HANDLERS.put(ESIUniverseStructuresRequest.class, new ESIHandler<ESIUniverseStructuresRequest, ESIUniverseStructuresResponse>() {
            @Override
            public boolean handle(ESIUniverseStructuresRequest request, ESIUniverseStructuresResponse response, ESIService service) {
                final List<Long> ids = service.listStructures();
                if (null == ids) {
                    return false;
                }
                final Map<Long, ESILocation.Structure> map = new HashMap<>(ids.size());
                for (Long id: ids) {
                    ESILocation.Structure structure = service.getStructure(id);
                    if (null != structure) {
                        map.put(id, structure);
                    }
                }

                response.setStructures(map);
                return true;
            }
        });
        HANDLERS.put(ESILocationRequest.StationRequest.class, new ESIHandler<ESILocationRequest.StationRequest, ESILocationResponse>() {
            @Override
            public boolean handle(ESILocationRequest.StationRequest request, ESILocationResponse response, ESIService service) {
                final ESILocation.Station station = service.getStation(request.getLocationID());
                if (null == station) {
                    return false;
                }
                response.setLocation(station);
                return true;
            }
        });
        HANDLERS.put(ESILocationRequest.SolarSystemRequest.class, new ESIHandler<ESILocationRequest.SolarSystemRequest, ESILocationResponse>() {
            @Override
            public boolean handle(ESILocationRequest.SolarSystemRequest request, ESILocationResponse response, ESIService service) {
                final ESILocation.SolarSystem system = service.getSolarSystem(request.getLocationID());
                if (null == system) {
                    return false;
                }
                response.setLocation(system);
                return true;
            }
        });
        HANDLERS.put(ESICharacterStructureRequest.class, new ESIHandler<ESICharacterStructureRequest, ESICharacterStructureResponse>() {
            @Override
            public boolean handle(ESICharacterStructureRequest request, ESICharacterStructureResponse response, ESIService service) {
                final ESILocation.Structure structure = service.getStructure(request.getStructureId());
                if (null == structure) {
                    return false;
                }
                response.setStructure(structure);
                return true;
            }
        });
        HANDLERS.put(ESICharacterStatusRequest.class, new ESIHandler<ESICharacterStatusRequest, ESICharacterStatusResponse>() {
            @Override
            public boolean handle(ESICharacterStatusRequest request, ESICharacterStatusResponse response, ESIService service) {
                response.setStatus(service.getCharacterStatus());
                return (null != response.getStatus());
            }
        });
        HANDLERS.put(ESICharacterInfoRequest.class, new ESIHandler<ESICharacterInfoRequest, ESICharacterInfoResponse>() {
            @Override
            public boolean handle(ESICharacterInfoRequest request, ESICharacterInfoResponse response, ESIService service) {
                response.setCharacter(service.getCharacter());
                return (null != response.getCharacter());
            }
        });
        HANDLERS.put(ESICharacterLocationRequest.class, new ESIHandler<ESICharacterLocationRequest, ESICharacterLocationResponse>() {
            @Override
            public boolean handle(ESICharacterLocationRequest request, ESICharacterLocationResponse response, ESIService service) {
                response.setLocation(service.getCharacterLocation());
                return (null != response.getLocation());
            }
        });
        HANDLERS.put(ESICharacterShipRequest.class, new ESIHandler<ESICharacterShipRequest, ESICharacterShipResponse>() {
            @Override
            public boolean handle(ESICharacterShipRequest request, ESICharacterShipResponse response, ESIService service) {
                response.setShip(service.getCharacterShip());
                return (null != response.getShip());
            }
        });
        HANDLERS.put(ESICharacterMailLabelsRequest.class, new ESIHandler<ESICharacterMailLabelsRequest, ESICharacterMailLabelsResponse>() {
            @Override
            public boolean handle(ESICharacterMailLabelsRequest request, ESICharacterMailLabelsResponse response, ESIService service) {
                response.setMailboxes(service.getMailboxes());
                return (null != response.getMailboxes());
            }
        });
        HANDLERS.put(ESICharacterMailHeadersRequest.class, new ESIHandler<ESICharacterMailHeadersRequest, ESICharacterMailHeadersResponse>() {
            @Override
            public boolean handle(ESICharacterMailHeadersRequest request, ESICharacterMailHeadersResponse response, ESIService service) {
                response.setMails(service.getMails(request.getLastMailID()));
                return (null != response.getMails());
            }
        });
        HANDLERS.put(ESICharacterMailContentRequest.class, new ESIHandler<ESICharacterMailContentRequest, ESICharacterMailContentResponse>() {
            @Override
            public boolean handle(ESICharacterMailContentRequest request, ESICharacterMailContentResponse response, ESIService service) {
                response.setMail(service.getMailContent(request.getMailID()));
                return (null != response.getMail());
            }
        });
        HANDLERS.put(ESICharacterMailUpdateRequest.class, new ESIHandler<ESICharacterMailUpdateRequest, ESICharacterMailUpdateResponse>() {
            @Override
            public boolean handle(ESICharacterMailUpdateRequest request, ESICharacterMailUpdateResponse response, ESIService service) {
                return service.updateMail(request.getMail());
            }
        });
        HANDLERS.put(ESICharacterMailPostRequest.class, new ESIHandler<ESICharacterMailPostRequest, ESICharacterMailPostResponse>() {
            @Override
            public boolean handle(ESICharacterMailPostRequest request, ESICharacterMailPostResponse response, ESIService service) {
                final ESIMail mail = request.getMail();
                final Integer id = service.postMail(mail);
                if (null == id) {
                    return false;
                }
                mail.setId(Long.valueOf(id));
                response.setMail(mail);
                return true;
            }
        });
        HANDLERS.put(ESICharacterMailDeleteRequest.class, new ESIHandler<ESICharacterMailDeleteRequest, ESICharacterMailDeleteResponse>() {
            @Override
            public boolean handle(ESICharacterMailDeleteRequest request, ESICharacterMailDeleteResponse response, ESIService service) {
                return service.deleteMail(request.getMailID());
            }
        });
        HANDLERS.put(ESICharacterAssetRequest.class, new ESIHandler<ESICharacterAssetRequest, ESICharacterAssetResponse>() {
            @Override
            public boolean handle(ESICharacterAssetRequest request, ESICharacterAssetResponse response, ESIService service) {
                final List<ESIAsset> assets = service.getAssets();
                if (null == assets) {
                    return false;
                }
                response.setAssets(assets);
                return true;
            }
        });
    }

    private final ESIClient esi;
    private final Map<String, ESIService> services;

    private ESINetwork(
            final String appId,
            final String appKey,
            final String redirect,
            final String agent,
            final long timeout,
            final File cache,
            final String[] scopes) {

        this.esi =
                ESIClient.TQ(scopes)
                .agent(agent)
                .id(appId)
                .key(appKey)
                .redirect(redirect)
                .timeout(timeout)
                .cache(cache)
                .build();

        this.services = new WeakHashMap<>();
    }

    public static ESINetwork.Builder TQ(final String... scopes) {
        return new ESINetwork.Builder().scopes(scopes);
    }

    public final ESIClient getClient() {
        return this.esi;
    }

    @Override
    public void close() throws IOException {
        this.services.clear();
    }

    @Override
    public <Q extends EveRequest<R>, R extends EveResponse> R execute(Q request) {
        if (!(request instanceof ESIRequest<?>)) {
            return null;
        }
        return (R)executeImpl((ESIRequest)request);
    }

    private <R extends ESIResponse, Q extends ESIRequest<R>> R executeImpl(final Q request) {
        final R response = request.create();
        final ESIHandler<Q, R> h = HANDLERS.get(request.getClass());

        if (null == h) {
            throw new IllegalArgumentException("No handler found for " + request.getClass().getSimpleName());
        }

        final ESIService service = obtain(request);
        if ((null == service) || !h.handle(request, response, service)) {
            response.setErrorCode(500);
            response.setErrorMessage(request.getPage());
        }
        return response;
    }

    private synchronized ESIService obtain(final ESIRequest request) {
        ESIService service = this.services.get(request.getRefreshToken());
        if (null == service) {
            service = this.esi.obtain(request.getRefreshToken());
            this.services.put(request.getRefreshToken(), service);
        }
        return service;
    }

}
