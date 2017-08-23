package com.tlabs.eve.ccp;



import com.tlabs.eve.EveRequest;

public class EveRSSRequest extends EveRequest<EveRSSResponse> {
    //see https://community.eveonline.com/news/rss-feeds/
    //NEWS https://newsfeed.eveonline.com/en-US/44/articles/page/1/20
    //DEV BLOG https://newsfeed.eveonline.com/en-US/2/articles/page/1/20
    //PATCH https://newsfeed.eveonline.com/en-US/15/articles/page/1/5

    public static final EveRSSRequest DEV = new EveRSSRequest("/en-US/2/articles/page/1/20");
    public static final EveRSSRequest NEWS = new EveRSSRequest("/en-US/44/articles/page/1/20");
    public static final EveRSSRequest PATCH = new EveRSSRequest("/en-US/15/articles/page/1/5");

    public EveRSSRequest(final String page) {
        super(EveRSSResponse.class, page);
    }

}
