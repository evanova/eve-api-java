package com.tlabs.eve.crest;

public class IncursionRequest extends CRESTRequest<IncursionResponse> {

    public IncursionRequest() {
        super(IncursionResponse.class, "/incursions/");
    }
}
