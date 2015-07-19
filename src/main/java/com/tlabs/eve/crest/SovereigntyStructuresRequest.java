package com.tlabs.eve.crest;

public class SovereigntyStructuresRequest extends CRESTRequest<SovereigntyStructuresResponse> {

    public SovereigntyStructuresRequest() {
        super(SovereigntyStructuresResponse.class, "/sovereignty/structures");
    }
}
