package com.tlabs.eve.crest;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class Alliance extends Object implements Serializable {

    private static final long serialVersionUID = -6233408378427718859L;

    @JsonProperty("shortName")
    private String shortName;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("id")
    private long id;
}
