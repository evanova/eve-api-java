package com.tlabs.eve.crest;


import java.util.HashMap;
import java.util.Map;

final class CRESTHelper {

    private static final Map<Class<? extends CRESTRequest<?>>, Class<? extends CRESTParser<?>>> parserMap;

    static {
        parserMap = new HashMap<>();
        parserMap.put(IncursionRequest.class, IncursionParser.class);
        parserMap.put(AllianceRequest.class, AllianceParser.class);
        parserMap.put(MarketHistoryRequest.class, MarketHistoryParser.class);
        parserMap.put(SovereigntyStructuresRequest.class, SovereigntyStructuresParser.class);
        parserMap.put(SovereigntyCampaignsRequest.class, SovereigntyCampaignsParser.class);
    }

    private CRESTHelper() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends CRESTResponse> CRESTParser<T> getParser(final CRESTRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null CRESTRequest parameter.");
        }

        CRESTParser<?> parser = createParser(request);
        return (CRESTParser<T>) parser;
    }

    private static CRESTParser<?> createParser(final CRESTRequest<? extends CRESTResponse> request) {
        final Class<? extends CRESTParser<?>> parserClass = parserMap.get(request.getClass());
        if (null == parserClass) {
            throw new IllegalArgumentException("No parser found for CRESTRequest " + request.getClass().getSimpleName());
        }
        try {
            return parserClass.newInstance();
        }
        catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

}
