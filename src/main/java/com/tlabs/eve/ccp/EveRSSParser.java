package com.tlabs.eve.ccp;



import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;

public final class EveRSSParser extends AbstractXMLParser<EveRSSResponse> {

    public EveRSSParser() {
        super(EveRSSResponse.class);
    }

    @Override
    protected void doAfterParse(EveRSSResponse t) {
        final long now = System.currentTimeMillis();
        t.setCachedUntil(now + 24l * 3600l * 1000l);
    }

    @Override
    protected void init(Digester digester) {
        digester.addRule("feed/title", new SetElementPropertyRule());
        digester.addRule("feed/link", new SetAttributePropertyRule("href", "link"));
        digester.addRule("feed/updated", new SetElementPropertyRule("dateUpdated"));
        digester.addObjectCreate("feed/entry", EveRSSEntry.class);
        digester.addRule("feed/entry", new SetNextRule("addEntry"));

        digester.addRule("feed/entry/id", new SetElementPropertyRule());
        digester.addRule("feed/entry/title", new SetElementPropertyRule());
        digester.addRule("feed/entry/published", new SetElementPropertyRule("datePublished"));
        digester.addRule("feed/entry/updated", new SetElementPropertyRule("dateUpdated"));
        digester.addRule("feed/entry/author/name", new SetElementPropertyRule("author"));
        digester.addRule("feed/entry/link", new SetAttributePropertyRule("href", "link"));
        //in a CDATA block
        digester.addRule("feed/entry/content", new SetElementPropertyRule("htmlContent"));
    }

}
