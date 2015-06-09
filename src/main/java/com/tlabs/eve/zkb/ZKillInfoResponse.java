package com.tlabs.eve.zkb;

public final class ZKillInfoResponse extends ZKillResponse {
    public ZKillInfoResponse() {
        super();
        //Kill mails don't change
        setCachedUntil(System.currentTimeMillis() + 365l * 24l * 3600l * 60l * 1000l);
    }
}
