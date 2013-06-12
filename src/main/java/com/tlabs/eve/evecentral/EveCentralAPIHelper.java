package com.tlabs.eve.evecentral;

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

final class EveCentralAPIHelper {
    
    private static final Map<Class<? extends EveCentralRequest<?>>, Class<? extends EveCentralParser<?>>> parserMap;    
    private static final Map<Class<?>, SoftReference<EveCentralParser<? extends EveCentralResponse>>> parsers;
   
    static {
        parserMap = new HashMap<Class<? extends EveCentralRequest<?>>, Class<? extends EveCentralParser<?>>>();
        parsers = new HashMap<Class<?>, SoftReference<EveCentralParser<? extends EveCentralResponse>>>();
        
        parserMap.put(MarketStatsRequest.class, MarketStatsParser.class);
    }
    
    private EveCentralAPIHelper() {
    }


    @SuppressWarnings("unchecked")
    public static <T extends EveCentralResponse> EveCentralParser<T> getParser(final EveCentralRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null EveRequest parameter.");
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
        return (EveCentralParser<T>)parser;
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
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
    }
    
}
