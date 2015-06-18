package com.tlabs.eve.ccp;



import java.util.Locale;

public final class PressNewsRequest extends EveRSSRequest {
    //http://newsfeed.eveonline.com/en-US/43/articles/page/1/20/
    public PressNewsRequest(final Locale locale) {
        super("/43/articles/page/1/20/", locale);
    }

    public PressNewsRequest() {
        super("/43/articles/page/1/20/");
    }
}
