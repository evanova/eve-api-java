package com.tlabs.eve.central;


import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

final class EveCentralAPIHelper {

    private static final Map<Class<? extends EveCentralRequest<?>>, Class<? extends EveCentralParser<?>>> parserMap;

    static {
        parserMap = new HashMap<>();

        parserMap.put(EveCentralStatsRequest.class, EveCentralStatsParser.class);
        parserMap.put(EveCentralQuickLookRequest.class, EveCentralQuickLookParser.class);
    }

    private EveCentralAPIHelper() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends EveCentralResponse> EveCentralParser<T> getParser(final EveCentralRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null EveAPIRequest parameter.");
        }
        EveCentralParser<?> parser = createParser(request);
        return (EveCentralParser<T>) parser;
    }

    private static EveCentralParser<?> createParser(final EveCentralRequest<? extends EveCentralResponse> request) {
        final Class<? extends EveCentralParser<?>> parserClass = parserMap.get(request.getClass());
        if (null == parserClass) {
            throw new IllegalArgumentException("No parser found for EveAPIRequest " + request.getClass().getSimpleName());
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
