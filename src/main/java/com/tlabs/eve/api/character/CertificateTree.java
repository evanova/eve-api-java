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


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CertificateTree extends Object implements Serializable {

    private static final long serialVersionUID = 3206517506300063885L;

    private final Map<Long, List<Certificate>> certificateGroups;//group ID->List
    private final List<Long> groups;//act as a cache for getCertificateGroups()
    
    public CertificateTree() {
        this.certificateGroups = new HashMap<Long, List<Certificate>>();
        this.groups = new LinkedList<Long>();
    }
    
    public final void add(final Certificate c) {
        List<Certificate> certs = this.certificateGroups.get(c.getGroupID());
        if (null == certs) {
            certs = new ArrayList<Certificate>(5);
            this.certificateGroups.put(c.getGroupID(), certs);
            this.groups.add(c.getGroupID());
        }
        certs.add(c);
    }
    
    public final Certificate getCertificate(final long certificateID) {
        for (List<Certificate> certs: this.certificateGroups.values()) {
            for (Certificate c: certs) {
                if (c.getCertificateID() == certificateID) {
                    return c;
                }
            }
        }
        return null;
    }
    
    public final List<Certificate> getCertificates(final long groupID) {
        return this.certificateGroups.get(groupID);
    }
    
    public final List<Long> getCertificateGroups() {
        return this.groups;
    }
}
