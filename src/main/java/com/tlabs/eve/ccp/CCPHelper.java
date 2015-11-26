package com.tlabs.eve.ccp;


import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;

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

    static {
        parserMap = new HashMap<>();
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

        final EveParser<?> parser = createParser(request);
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
        catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

}
