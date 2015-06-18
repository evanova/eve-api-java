package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIParser;

import org.apache.commons.digester.Digester;

public final class OutpostDetailsParser extends EveAPIParser<OutpostDetailsResponse> {

    public OutpostDetailsParser() {
        super(OutpostDetailsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {

    }
}
