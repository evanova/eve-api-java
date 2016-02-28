package com.tlabs.eve.api;



import com.tlabs.eve.parser.SetElementPropertyRule;

import org.apache.commons.digester.Digester;

public final class ServerStatusParser extends EveAPIParser<ServerStatusResponse> {

    public ServerStatusParser() {
        super(ServerStatusResponse.class);
    }

    @Override
    protected void doAfterParse(ServerStatusResponse t) {
        long now = System.currentTimeMillis();
        t.setCachedUntil(now + 5l * 60l * 1000l);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/serverOpen", new SetElementPropertyRule());
        digester.addRule("eveapi/result/onlinePlayers", new SetElementPropertyRule());
    }
}
