package com.tlabs.eve.ccp;



import com.tlabs.eve.EveRequest;

public class EveRSSRequest extends EveRequest<EveRSSResponse> {
    //https://forums.eveonline.com/default.aspx?g=rsstopic&pg=Topics&f=247
    public EveRSSRequest() {
        super(EveRSSResponse.class, "/default.aspx?g=rsstopic&pg=Topics&f=247");
    }

}
