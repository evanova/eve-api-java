package com.tlabs.eve.ccp;



import com.tlabs.eve.EveRequest;

public class EveRSSRequest extends EveRequest<EveRSSResponse> {
    //view-source:https://forums.eveonline.com/default.aspx?g=rsstopic
    //https://forums.eveonline.com/default.aspx?g=rsstopic&pg=Topics&f=247

    public static final EveRSSRequest DEV = new EveRSSRequest("&pg=Topics&f=247");
    public static final EveRSSRequest FORUM = new EveRSSRequest("");

    @Deprecated
    public EveRSSRequest() {
        this("&pg=Topics&f=247");
    }

    public EveRSSRequest(final String page) {
        super(EveRSSResponse.class, "/default.aspx?g=rsstopic" + page);
    }

}
