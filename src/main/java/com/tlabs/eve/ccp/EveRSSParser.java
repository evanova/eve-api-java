package com.tlabs.eve.ccp;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
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


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.TimeZone;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.tlabs.eve.EveParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class EveRSSParser extends Object implements EveParser<EveRSSResponse> {
    
    protected static final Log LOG = LogFactory.getLog("EveAPI");
    
    private final Digester digester;
    
    public EveRSSParser() {
        super();
        this.digester = new Digester();
        //this.digester.setRules(new ExtendedBaseRules());
        this.digester.setNamespaceAware(false);
        this.digester.setValidating(false);
        
        //BUG Fixes an Android 1.5 (and apparently in 2.1-update1 too) SAX parser bug: cannot have both at the same time,
        //but the Android impl checks those feature against each other incorrectly.
        //This is probably causing or related to the bug described in CharacterSheetParser
        try {
            //this.digester.setFeature("http://xml.org/sax/features/namespaces", false);
            this.digester.setFeature("http://xml.org/sax/features/namespace-prefixes", true);       
        }
        catch (SAXNotSupportedException e) {
            throw new IllegalStateException(e.getLocalizedMessage());
        }
        catch (SAXNotRecognizedException e) {
            throw new IllegalStateException(e.getLocalizedMessage());
        }
        catch (ParserConfigurationException e) {
            throw new IllegalStateException(e.getLocalizedMessage());
        }
        init(this.digester);            
    }
    
    public final EveRSSResponse parse(String s) throws IOException {
        return parse(s.getBytes());
    }
    
    public synchronized final EveRSSResponse parse(byte[] data) throws IOException {
        this.digester.clear();      
        try {           
            EveRSSResponse t = new EveRSSResponse();            
            this.digester.push(t);
            t = (EveRSSResponse)this.digester.parse(new ByteArrayInputStream(data));
            t.setContent(data);
            t.setParsed(true); 
            final long now = System.currentTimeMillis();      
            t.setCachedUntil(now - TimeZone.getDefault().getOffset(now) + 1l *3600l * 1000l);                      
            return t;
        }        
        catch (SAXException e) {
            e.printStackTrace(System.err);
            throw new IOException(e.getLocalizedMessage());
        }
        
    }
  
    private void init(Digester digester) {
        digester.addRule("feed/title", new SetElementPropertyRule());      
        digester.addRule("feed/link", new SetAttributePropertyRule("href", "link"));
        digester.addRule("feed/updated", new SetElementPropertyRule("dateUpdated"));
        digester.addObjectCreate("feed/entry", EveRSSEntry.class);        
        digester.addRule("feed/entry", new SetNextRule("addEntry"));
        
        digester.addRule("feed/entry/id", new SetElementPropertyRule());
        digester.addRule("feed/entry/title", new SetElementPropertyRule());
        digester.addRule("feed/entry/published", new SetElementPropertyRule("datePublished"));
        digester.addRule("feed/entry/updated", new SetElementPropertyRule("dateUpdated"));
        digester.addRule("feed/entry/author/name", new SetElementPropertyRule("author"));
        digester.addRule("feed/entry/link", new SetAttributePropertyRule("href", "link"));
        //in a CDATA block
        digester.addRule("feed/entry/content", new SetElementPropertyRule("htmlContent"));        
    }
    
}
