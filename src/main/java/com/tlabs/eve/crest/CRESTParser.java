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


import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.tlabs.eve.EveParser;

public abstract class CRESTParser<T extends CRESTResponse> implements EveParser<T> {
    
    private final Class<T> responseClass;
    private final ObjectMapper mapper;
    
    public CRESTParser(final Class<T> responseClass) {
        super();
        this.responseClass = responseClass;
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        init(mapper);
    }

    @Override
    public T parse(InputStream in) throws IOException {
        try {
            T response = this.mapper.readValue(in, this.responseClass);
            response.setParsed(true);                      
            return response;
        }
        catch (JsonMappingException e) {
            throw new IOException(e);
        }
        catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }
    
    protected void init(final org.codehaus.jackson.map.ObjectMapper mapper) {
        
    }
}
