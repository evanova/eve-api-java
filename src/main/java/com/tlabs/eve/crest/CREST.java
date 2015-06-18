package com.tlabs.eve.crest;



import java.io.IOException;
import java.io.InputStream;

//Facade toward the ...ahem.. Eve API...
public final class CREST {

    private CREST() {
    }

    public static <T extends CRESTResponse> T parse(CRESTRequest<T> request, InputStream in) throws IOException {
        final CRESTParser<T> p = CRESTHelper.getParser(request);
        return p.parse(in);
    }

}
