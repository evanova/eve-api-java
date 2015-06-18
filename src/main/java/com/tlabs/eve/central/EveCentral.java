package com.tlabs.eve.central;



import java.io.IOException;
import java.io.InputStream;

public final class EveCentral {

    private EveCentral() {
    }

    public static <T extends EveCentralResponse> T parse(EveCentralRequest<T> request, InputStream in) throws IOException {
        final EveCentralParser<T> p = EveCentralAPIHelper.getParser(request);
        return p.parse(in);
    }

}
