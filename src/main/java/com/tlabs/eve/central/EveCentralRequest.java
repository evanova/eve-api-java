package com.tlabs.eve.central;



import com.tlabs.eve.EveRequest;

public abstract class EveCentralRequest<T extends EveCentralResponse> extends EveRequest<T> {

    public EveCentralRequest(Class<T> responseClass, String page) {
        super(responseClass, page);
    }
}
