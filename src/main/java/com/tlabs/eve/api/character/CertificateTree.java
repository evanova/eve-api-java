package com.tlabs.eve.api.character;



import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CertificateTree implements Serializable {

    private static final long serialVersionUID = 3206517506300063885L;

    private final Map<Long, List<Certificate>> certificates;//group ID->List
    private final List<Long> groups;//act as a cache for getCertificateGroups()

    public CertificateTree() {
        this.certificates = new HashMap<>();
        this.groups = new ArrayList<>();
    }

    public final void add(final Certificate c) {
        List<Certificate> certs = this.certificates.get(c.getGroupID());
        if (null == certs) {
            certs = new ArrayList<>(5);
            this.certificates.put(c.getGroupID(), certs);
            this.groups.add(c.getGroupID());
        }
        certs.add(c);
        Collections.sort(certs, new Comparator<Certificate>() {
            @Override
            public int compare(Certificate c1, Certificate c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
    }

    public final Certificate getCertificate(final long certificateID) {
        for (List<Certificate> certs : this.certificates.values()) {
            for (Certificate c : certs) {
                if (c.getCertificateID() == certificateID) {
                    return c;
                }
            }
        }
        return null;
    }

    public final List<Certificate> getCertificates(final long groupID) {
        return this.certificates.get(groupID);
    }

    public final List<Long> getCertificateGroups() {
        return this.groups;
    }
}
