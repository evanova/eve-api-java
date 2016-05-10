package com.tlabs.eve.api;



import com.tlabs.eve.EveRequest;

public abstract class EveAPIRequest<T extends EveAPIResponse> extends EveRequest<T> {

    /**Since Key API V2.*/
    public interface Authenticated {

    }

    /** Tag interface*/
    public interface Public {
    }

    private final long mask;

    protected EveAPIRequest(Class<T> responseClass, String page, long mask) {
        super(responseClass, page);
        this.mask = mask;
    }

    public final long getMask() {
        return mask;
    }

}
