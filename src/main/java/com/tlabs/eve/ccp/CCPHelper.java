package com.tlabs.eve.ccp;


import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

final class CCPHelper {

    public static final class LogoParser extends ImageParser<CorporationLogoResponse> {
        @Override
        protected CorporationLogoResponse createResponse() {
            return new CorporationLogoResponse();
        }
    }

    public static final class PortraitParser extends ImageParser<PortraitResponse> {
        @Override
        protected PortraitResponse createResponse() {
            return new PortraitResponse();
        }
    }

    private static final Map<Class<? extends EveRequest<?>>, Class<? extends EveParser<?>>> parserMap;
    private static final Map<Class<?>, SoftReference<EveParser<? extends EveResponse>>> parsers;

    static {
        parserMap = new HashMap<>();
        parsers = new HashMap<>();

        parserMap.put(EveNewsRequest.class, EveRSSParser.class);
        parserMap.put(GameNewsRequest.class, EveRSSParser.class);
        parserMap.put(PressNewsRequest.class, EveRSSParser.class);
        parserMap.put(CorporationLogoRequest.class, LogoParser.class);
        parserMap.put(PortraitRequest.class, PortraitParser.class);
    }

    private CCPHelper() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends EveResponse> EveParser<T> getParser(final EveRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null EveAPIRequest parameter.");
        }

        SoftReference<EveParser<? extends EveResponse>> ref = parsers.get(request.getClass().getName());

        EveParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference<EveParser<?>>(parser);
            parsers.put(request.getClass(), ref);
        }
        return (EveParser<T>) parser;
    }

    private static EveParser<?> createParser(final EveRequest<? extends EveResponse> request) {
        final Class<? extends EveParser<?>> parserClass = parserMap.get(request.getClass());
        if (null == parserClass) {
            throw new IllegalArgumentException("No parser found for EveAPIRequest " + request.getClass().getSimpleName());
        }
        try {
            return parserClass.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

}
