package com.tlabs.eve.crest;

public class AllianceRequest extends CRESTRequest<AllianceResponse> {
    
    public AllianceRequest() {
        super(AllianceResponse.class, "/alliances/");        
    }
    
    public AllianceRequest(String allianceID) {
        this();
        putParam("id", allianceID);
    }

}
