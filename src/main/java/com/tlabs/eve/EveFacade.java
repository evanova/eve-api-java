package com.tlabs.eve;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.ccp.CCP;

import com.tlabs.eve.zkb.ZKillboard;
import com.tlabs.eve.zkb.ZKillRequest;

import java.io.IOException;
import java.io.InputStream;

public final class EveFacade {

    private EveFacade() {
    }

    public static <T extends EveResponse> T parse(final EveRequest<T> request, InputStream in) throws IOException {
        if (request instanceof EveAPIRequest) {
            return (T) EveAPI.parse((EveAPIRequest) request, in);
        }
        if (request instanceof ZKillRequest) {
            return (T) ZKillboard.parse((ZKillRequest)request, in);
        }
        return CCP.parse(request, in);
    }

}
