package com.tlabs.eve.crest;

import com.tlabs.eve.EveRequest;

public class CRESTRequest<T extends CRESTResponse> extends EveRequest<T> {

    public CRESTRequest(Class<T> responseClass, String page) {
        super(responseClass, page);
        
    }
}
