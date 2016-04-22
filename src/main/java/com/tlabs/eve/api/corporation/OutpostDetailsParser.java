package com.tlabs.eve.api.corporation;



import org.apache.commons.digester3.Digester;
import com.tlabs.eve.api.EveAPIParser;

public final class OutpostDetailsParser extends EveAPIParser<OutpostDetailsResponse> {

    public OutpostDetailsParser() {
        super(OutpostDetailsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {

    }
}
