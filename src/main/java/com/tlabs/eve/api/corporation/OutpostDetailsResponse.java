package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

public final class OutpostDetailsResponse extends EveAPIResponse {

    private static final long serialVersionUID = 2781095409544154160L;

    private final Outpost outpost;

    public OutpostDetailsResponse() {
        super();
        outpost = new Outpost();
    }

    public Outpost getOutpost() {
        return outpost;
    }

}
