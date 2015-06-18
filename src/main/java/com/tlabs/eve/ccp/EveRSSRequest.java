package com.tlabs.eve.ccp;



import com.tlabs.eve.EveRequest;

import java.util.Locale;

public class EveRSSRequest extends EveRequest<EveRSSResponse> {
    protected EveRSSRequest(final String page, final Locale locale) {
        super(EveRSSResponse.class, "/" + locale.getLanguage() + "-" + locale.getCountry() + page);
    }

    protected EveRSSRequest(final String page) {
        super(EveRSSResponse.class, "/en-US" + page);
    }
}
