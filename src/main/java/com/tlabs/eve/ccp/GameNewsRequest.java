package com.tlabs.eve.ccp;



import java.util.Locale;

public final class GameNewsRequest extends EveRSSRequest {
    //http://newsfeed.eveonline.com/en-US/42/articles/page/1/20/
    public GameNewsRequest(final Locale locale) {
        super("/42/articles/page/1/20/", locale);
    }

    public GameNewsRequest() {
        super("/42/articles/page/1/20/");
    }
}
