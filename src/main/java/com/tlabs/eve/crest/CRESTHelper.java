package com.tlabs.eve.crest;

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

final class CRESTHelper {
    
    private static final Map<Class<? extends CRESTRequest<?>>, Class<? extends CRESTParser<?>>> parserMap;    
    private static final Map<Class<?>, SoftReference<CRESTParser<? extends CRESTResponse>>> parsers;
   
    static {
        parserMap = new HashMap<Class<? extends CRESTRequest<?>>, Class<? extends CRESTParser<?>>>();
        parsers = new HashMap<Class<?>, SoftReference<CRESTParser<? extends CRESTResponse>>>();
        
        parserMap.put(IncursionRequest.class, IncursionParser.class);
        parserMap.put(AllianceRequest.class, AllianceParser.class);
        parserMap.put(MarketHistoryRequest.class, MarketHistoryParser.class);
    }
    
    private CRESTHelper() {
    }


    @SuppressWarnings("unchecked")
    public static <T extends CRESTResponse> CRESTParser<T> getParser(final CRESTRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null CRESTRequest parameter.");
        }
        
        SoftReference<CRESTParser<? extends CRESTResponse>> ref = parsers.get(request.getClass().getName());
        
        CRESTParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference<CRESTParser<?>>(parser);
            parsers.put(request.getClass(), ref);
        }        
        return (CRESTParser<T>)parser;
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
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
    }
    
}
