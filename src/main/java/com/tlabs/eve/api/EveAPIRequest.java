package com.tlabs.eve.api;



import com.tlabs.eve.EveRequest;

public abstract class EveAPIRequest<T extends EveAPIResponse> extends EveRequest<T> {

    /**Since Key API V2.*/
    public interface Authenticated {
        String getKeyID();

        String getKey();
    }

    /** Tag interface*/
    public interface Public {
    }

    private final int mask;

    protected EveAPIRequest(Class<T> responseClass, String page, int mask) {
        super(responseClass, page);
        this.mask = mask;
    }

    public final int getMask() {
        return mask;
    }

}
