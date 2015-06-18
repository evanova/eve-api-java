package com.tlabs.eve.ccp;



import java.util.Locale;

public final class EveNewsRequest extends EveRSSRequest {
    //http://newsfeed.eveonline.com/en-US/44/articles/page/1/20/
    public EveNewsRequest(final Locale locale) {
        super("/44/articles/page/1/20/", locale);
    }

    public EveNewsRequest() {
        super("/44/articles/page/1/20/");
    }
}
