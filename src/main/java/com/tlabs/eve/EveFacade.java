package com.tlabs.eve;

import java.io.IOException;
import java.io.InputStream;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.ccp.CCP;
import com.tlabs.eve.central.EveCentral;
import com.tlabs.eve.central.EveCentralRequest;

public final class EveFacade {

    private EveFacade(){}
    

    public static <T extends EveResponse> T parse(EveRequest<T> request, byte[]  data) throws IOException {
        if (request instanceof EveAPIRequest) {
            return (T)EveAPI.parse((EveAPIRequest)request, data);
        }
        if (request instanceof EveCentralRequest) {
            return (T)EveCentral.parse((EveCentralRequest)request, data);
        }
        
        return (T)CCP.parse(request, data);
    }

    public static <T extends EveResponse> T parse(EveRequest<T> request, InputStream in) throws IOException {
        if (request instanceof EveAPIRequest) {
            return (T)EveAPI.parse((EveAPIRequest)request, in);
        }
        if (request instanceof EveCentralRequest) {
            return (T)EveCentral.parse((EveCentralRequest)request, in);
        }
        
        return (T)CCP.parse(request, in);
    }
}
