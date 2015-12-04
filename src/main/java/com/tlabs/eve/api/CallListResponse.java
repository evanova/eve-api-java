package com.tlabs.eve.api;

import java.util.HashMap;
import java.util.Map;

/**@since Eve API V3 (30 Aug 2011*/
public class CallListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 6542500480340585087L;

    private Map<Integer, CallGroup> callGroups = new HashMap<>();

    public CallListResponse() {
        super();
    }

    public void addGroup(CallGroup g) {
        this.callGroups.put(g.getGroupID(), g);
    }

    public void addEntry(CallEntry e) {
        CallGroup g = this.callGroups.get(e.getGroupID());
        if (null != g) {
            g.addEntry(e);
        }
    }
}
