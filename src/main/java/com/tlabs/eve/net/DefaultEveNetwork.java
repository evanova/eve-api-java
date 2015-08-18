package com.tlabs.eve.net;

import com.tlabs.eve.EveRequest;
import com.tlabs.eve.ccp.EveRSSRequest;
import com.tlabs.eve.ccp.ImageRequest;
import com.tlabs.eve.central.EveCentralRequest;
import com.tlabs.eve.crest.CRESTRequest;
import com.tlabs.eve.zkb.ZKillRequest;

public class DefaultEveNetwork extends AbstractEveNetwork {

    @Override
    public String getUri(EveRequest<?> request) {
        if (request instanceof ImageRequest) {
            return "https://imageserver.eveonline.com";
        }
        if (request instanceof EveRSSRequest) {
            return "http://newsfeed.eveonline.com";
        }
        if (request instanceof EveCentralRequest) {
            return "http://api.eve-central.com";
        }
        if (request instanceof CRESTRequest) {
            return "https://public-crest.eveonline.com";
        }
        if (request instanceof ZKillRequest) {
            return "https://zkillboard.com";
        }
        return "https://api.eveonline.com";
    }

}
