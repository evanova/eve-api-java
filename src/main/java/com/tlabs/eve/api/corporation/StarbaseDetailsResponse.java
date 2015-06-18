package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

public final class StarbaseDetailsResponse extends EveAPIResponse {

    private static final long serialVersionUID = 1457176289681565044L;

    private Starbase starbase;

    public StarbaseDetailsResponse() {
        super();
    }

    public void setStarbase(Starbase starbase) {
        this.starbase = starbase;
    }

    public Starbase getStarbase() {
        return starbase;
    }

}
