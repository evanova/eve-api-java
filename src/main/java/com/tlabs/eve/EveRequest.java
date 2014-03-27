package com.tlabs.eve;

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


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public abstract class EveRequest<T extends EveResponse> extends Object {
    
    /** Tag interface*/
    public interface Public {}
    
    private final Class<T> responseClass;
    private final String page;
    
    private final Map<String, String> params;
    
    protected EveRequest(Class<T> responseClass, String page) {
        super();
        this.responseClass = responseClass;
        this.page = page;
        this.params = new LinkedHashMap<String, String>(2);//Order is important for CREST support
    }

    public final String getPage() {
        return page;
    }

    public final Map<String, String> getParameters() {
        return this.params;
    }
    
    protected final void removeParam(String p) {
        this.params.remove(p);
    }
    
    public final void putParam(String p, String v) {
        this.params.put(p, (null == v) ? null : v);
    }

    protected final void putParam(String p, String[] values) {
        if (null == values) {
            this.params.put(p, null);               
            return;
        }
        
        String s = "";
        for (Object v: values) {
            s = s + v + ",";
        }       
        this.params.put(p, StringUtils.removeEnd(s, ","));
    }       
    
    protected final void putParam(String p, long[] values) {
        if (null == values) {
            this.params.put(p, null);               
            return;
        }
        
        String s = "";
        for (long v: values) {
            s = s + Long.toString(v) + ",";
        }       
        this.params.put(p, StringUtils.removeEnd(s, ","));
    }       
    
    public final T createError(Throwable t) {
        return createError(500, (null == t) ? "No error message - sorry." : t.getLocalizedMessage());       
    }
    
    public final T createError(int err) {
        return createError(err, null);
    }
    
    public final T createError(final int err, final String msg) {
        try { 
            T t = responseClass.newInstance();      
            t.setErrorCode(err);
            t.setErrorMessage((null == msg) ? "Error code " + err : msg);
            t.setParsed(true);
            t.setCached(false);
            return t;
        }
        catch(Exception e) {
            System.err.println(this.getClass().getName());
            throw new RuntimeException(e);
        }
    }

    public final T createResponse(final byte[] data) {
        try { 
            T t = responseClass.newInstance();      
            t.setContent(data);
            t.setParsed(false);            
            return t;
        }
        catch(Exception e) {
            System.err.println(this.getClass().getName());
            throw new RuntimeException(e);
        }
    }
    
    //removes duplicates
    protected static final String[] filter(String[] names) {
        List<String> l = new ArrayList<String>(names.length);
        for (String s: names) {
            if (!l.contains(s)) {
                l.add(s);
            }
        }
        return l.toArray(new String[l.size()]);
    }
    //removes duplicates
    protected static final long[] filter(long[] ids) {
        List<Long> l = new ArrayList<Long>(ids.length);
        for (Long id: ids) {
            if (!l.contains(id)) {
                l.add(id);
            }
        }
        Long[] fck = l.toArray(new Long[l.size()]);
        long[] r = new long[fck.length];
        for (int i = 0; i < fck.length; i++) {
            r[i] = fck[i];          
        }
        return r;
    }
    //removes duplicates
    protected static final long[] filter(Long[] ids) {
        List<Long> l = new ArrayList<Long>(ids.length);
        for (Long id: ids) {
            if (!l.contains(id)) {
                l.add(id);
            }
        }
        Long[] fck = l.toArray(new Long[l.size()]);
        long[] r = new long[fck.length];
        for (int i = 0; i < fck.length; i++) {
            r[i] = fck[i].longValue();          
        }
        return r;
    }
}
