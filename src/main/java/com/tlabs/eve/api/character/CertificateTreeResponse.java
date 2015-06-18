package com.tlabs.eve.api.character;

import com.tlabs.eve.EveResponse;



public class CertificateTreeResponse extends EveResponse {

    private static final long serialVersionUID = 1510231738037120603L;

    private CertificateTree tree = null;

    public final CertificateTree getCertificateTree() {
        return tree;
    }

    public final void setTree(CertificateTree tree) {
        this.tree = tree;
    }

}
