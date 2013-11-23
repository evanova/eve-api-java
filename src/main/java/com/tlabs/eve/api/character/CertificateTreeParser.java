package com.tlabs.eve.api.character;

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


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tlabs.eve.parser.AbstractYAMLParser;

public final class CertificateTreeParser extends AbstractYAMLParser<CertificateTreeResponse> {
	
    public CertificateTreeParser() {
        super(CertificateTreeResponse.class);
    }

    @Override
    protected CertificateTreeResponse parse(Object yaml, CertificateTreeResponse t) throws IOException {
        t.setTree(parseTree(yaml));
        
        final long now = System.currentTimeMillis();        
        t.setDateTime(now);   
        t.setParsed(true);        
        t.setDateTime(now);
        t.setCachedUntil(now + 365l* 31l * 24l * 3600l * 1000l);            
        return t;
    }
    
    @SuppressWarnings("unchecked")
    private static final CertificateTree parseTree(Object yaml) throws IOException {
        final CertificateTree tree = new CertificateTree();        
        
        try {
            final Map<Integer, Object> certs = ((Map<Integer, Object>)yaml);
            for (Integer id: certs.keySet()) {                     
                final Map<String, Object> attributes = (Map<String, Object>)certs.get(id);
                final Certificate certificate = new Certificate();
                certificate.setCertificateID(id);
                certificate.setGroupID((Integer)attributes.get("groupID"));
                certificate.setName((String)attributes.get("name"));
                certificate.setDescription((String)attributes.get("description"));
                
                final List<Integer> recommended = (List<Integer>)attributes.get("recommendedFor");
                final List<Long> longRecommended = new ArrayList<Long>();
                if (null != recommended) {
                    for (Integer a: recommended) {
                        longRecommended.add(Long.valueOf(a.longValue()));
                    }
                }
                certificate.setRecommendedFor(longRecommended);
                
                final Map<Integer, Map<String, Integer>> skillTypes = (Map<Integer, Map<String, Integer>>)attributes.get("skillTypes");                
                final Map<Long, Map<Certificate.Level, Integer>> certificateSkills = new HashMap<Long, Map<Certificate.Level, Integer>>();                
                if (null != skillTypes) {
                    for (Integer skillId: skillTypes.keySet()) {
                        final Map<String, Integer> levels = skillTypes.get(skillId);
                        final Map<Certificate.Level, Integer> types = new HashMap<Certificate.Level, Integer>();
                        types.put(Certificate.Level.BASIC, levels.get("basic"));
                        types.put(Certificate.Level.STANDARD, levels.get("standard"));
                        types.put(Certificate.Level.IMPROVED, levels.get("improved"));
                        types.put(Certificate.Level.ADVANCED, levels.get("advanced"));
                        types.put(Certificate.Level.ELITE, levels.get("elite"));
    
                        certificateSkills.put(Long.valueOf(skillId.longValue()), types);
                    }
                }
                certificate.setRequiredSkills(certificateSkills);
                
                tree.add(certificate);
            }            
            return tree;
        }
        catch (ClassCastException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }        
    }       
}
