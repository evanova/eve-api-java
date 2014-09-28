package com.tlabs.eve.crest;

import com.tlabs.eve.EveResponse;

import org.codehaus.jackson.annotate.JsonProperty;

public class CRESTResponse extends EveResponse {

    private static final long serialVersionUID = 193723495526215920L;

    @Override
    @JsonProperty("message")
    public void setErrorMessage(String errorString) {
        super.setErrorMessage(errorString);
    }

}
