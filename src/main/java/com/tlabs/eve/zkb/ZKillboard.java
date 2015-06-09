package com.tlabs.eve.zkb;

import java.io.IOException;
import java.io.InputStream;

//https://github.com/zKillboard/zKillboard/blob/master/api.wiki
public class ZKillboard {

    public static <T extends ZKillResponse> T parse(final ZKillRequest<T> request, InputStream in) throws IOException {
       return ZKillHelper.getParser(request).parse(in);
    }


}
