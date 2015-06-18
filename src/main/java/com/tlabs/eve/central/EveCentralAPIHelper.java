package com.tlabs.eve.central;


import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

final class EveCentralAPIHelper {

    private static final Map<Class<? extends EveCentralRequest<?>>, Class<? extends EveCentralParser<?>>> parserMap;
    private static final Map<Class<?>, SoftReference<EveCentralParser<? extends EveCentralResponse>>> parsers;

    static {
        parserMap = new HashMap<>();
        parsers = new HashMap<>();

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

        SoftReference<EveCentralParser<? extends EveCentralResponse>> ref = parsers.get(request.getClass().getName());

        EveCentralParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference<EveCentralParser<?>>(parser);
            parsers.put(request.getClass(), ref);
        }
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
        catch (IllegalAccessException | InstantiationException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
    }

}
