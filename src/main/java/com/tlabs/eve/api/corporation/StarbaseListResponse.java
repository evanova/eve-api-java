package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public final class StarbaseListResponse extends EveAPIResponse {

    private static final long serialVersionUID = -6881766910572039754L;

    private List<Starbase> starbases;

    public StarbaseListResponse() {
        super();
        starbases = new ArrayList<>();
    }

    public void addStarbase(Starbase starbase) {
        starbases.add(starbase);
    }

    public List<Starbase> getStarbases() {
        return this.starbases;
    }
}
