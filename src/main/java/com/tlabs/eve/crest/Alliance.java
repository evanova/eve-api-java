package com.tlabs.eve.crest;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Alliance implements Serializable {

    private static final long serialVersionUID = -6233408378427718859L;

    @JsonProperty("shortName")
    private String shortName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private long id;
}
