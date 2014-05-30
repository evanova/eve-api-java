package com.tlabs.eve.crest;

public class MarketHistoryRequest extends CRESTRequest<MarketHistoryResponse> {
    
    public MarketHistoryRequest(final long regionID, final long typeID) {
    	///market/<region_id>/types/<type_id>/history/
        super(
        		MarketHistoryResponse.class, 
        		"/market/" + regionID + "/types/" + typeID + "/history/");        
    }    
}
