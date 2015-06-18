package com.tlabs.eve.ccp;



import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;

import java.io.IOException;
import java.io.InputStream;

public final class CCP {

    private CCP() {
    }

    public static <T extends EveResponse> T parse(EveRequest<T> request, InputStream in) throws IOException {
        final EveParser<T> p = CCPHelper.getParser(request);
        return p.parse(in);
    }
}
