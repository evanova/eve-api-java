package com.tlabs.eve.zkb;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

final class ZKillHelper {

    private static final Map<Class<? extends ZKillRequest<?>>, Class<? extends ZKillResponse>> parserMap;
    private static final Map<Class<?>, SoftReference<ZKillParser<? extends ZKillResponse>>> parsers;

    static {
        parserMap = new HashMap<>();
        parsers = new HashMap<>();

        parserMap.put(ZKillInfoRequest.class, ZKillInfoResponse.class);
        parserMap.put(ZKillCharacterLogRequest.class, ZKillCharacterLogResponse.class);
        parserMap.put(ZKillCorporationLogRequest.class, ZKillCorporationLogResponse.class);
    }

    private ZKillHelper() {}

    public static <T extends ZKillResponse> ZKillParser<T> getParser(final ZKillRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null ZKillRequest parameter.");
        }

        SoftReference<ZKillParser<? extends ZKillResponse>> ref = parsers.get(request.getClass().getName());

        ZKillParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference<ZKillParser<?>>(parser);
            parsers.put(request.getClass(), ref);
        }
        return (ZKillParser<T>) parser;
    }

    private static ZKillParser<?> createParser(final ZKillRequest<? extends ZKillResponse> request) {
        final Class<? extends ZKillResponse> responseClass = parserMap.get(request.getClass());
        if (null == responseClass) {
            throw new IllegalArgumentException("No parser found for ZKillRequest " + request.getClass().getSimpleName());
        }
        return new ZKillParser<>(responseClass);
    }
}
