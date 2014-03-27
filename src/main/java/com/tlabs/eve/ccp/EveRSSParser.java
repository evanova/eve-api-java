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


import org.apache.commons.digester.Digester;

import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class EveRSSParser extends AbstractXMLParser<EveRSSResponse> {
    
    public EveRSSParser() {
        super(EveRSSResponse.class);           
    }
    
    @Override
    protected void doAfterParse(EveRSSResponse t) {
        final long now = System.currentTimeMillis();      
        t.setCachedUntil(now + 24l *3600l * 1000l);
    }

    @Override
    protected void init(Digester digester) {
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
