package com.tlabs.eve.crest;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class MarketTransaction extends Object implements Serializable {

	private static final long serialVersionUID = 5163488029895665697L;

	@JsonProperty("volume")
    private long volume;
    
    @JsonProperty("orderCount")
    private long orderCount;
    
    @JsonProperty("lowPrice")
    private float lowPrice;
    
    @JsonProperty("highPrice")
    private float highPrice;
    
    @JsonProperty("avgPrice")
    private float averagePrice;
    
    @JsonProperty("date")
    private Date date;
    
}
