package com.tlabs.eve.ccp;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;

final class CCPHelper {

    public static final class LogoParser extends ImageParser<CorporationLogoResponse> {
        @Override
        protected CorporationLogoResponse createResponse() {
            return new CorporationLogoResponse();
        }           
    };
    
    public static final class PortraitParser extends ImageParser<PortraitResponse> {   
        @Override
        protected PortraitResponse createResponse() {
            return new PortraitResponse();
        }           
    };
    
    private static final Map<Class<? extends EveRequest<?>>, Class<? extends EveParser<?>>> parserMap;    
    private static final Map<Class<?>, SoftReference<EveParser<? extends EveResponse>>> parsers;
   
    static {
        parserMap = new HashMap<Class<? extends EveRequest<?>>, Class<? extends EveParser<?>>>();
        parsers = new HashMap<Class<?>, SoftReference<EveParser<? extends EveResponse>>>();
        
        parserMap.put(MessageOfTheDayRequest.class, MessageOfTheDayParser.class);

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
        return (EveParser<T>)parser;
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
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
    }
    
}
