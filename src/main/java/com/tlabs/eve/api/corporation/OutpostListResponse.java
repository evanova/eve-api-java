package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public final class OutpostListResponse extends EveAPIResponse {

    private static final long serialVersionUID = -2522278909885809287L;

    private List<Outpost> outposts;

    public OutpostListResponse() {
        super();
        outposts = new ArrayList<>();
    }

    public void addOutpost(Outpost outpost) {
        outposts.add(outpost);
    }

    public List<Outpost> getOutposts() {
        return this.outposts;
    }
}
