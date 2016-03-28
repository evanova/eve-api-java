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
        t.setCachedUntil(now + 15l * 60l * 1000l);
    }

    @Override
    protected void init(Digester digester) {
        digester.addRule("rss/channel/title", new SetElementPropertyRule("title"));
        digester.addObjectCreate("rss/channel/item", EveRSSEntry.class);
        digester.addRule("rss/channel/item", new SetNextRule("addEntry"));

        digester.addRule("rss/channel/item/guid", new SetElementPropertyRule("id"));
        digester.addRule("rss/channel/item/title", new SetElementPropertyRule());
        digester.addRule("rss/channel/item/link", new SetElementPropertyRule());
        digester.addRule("rss/channel/item/author", new SetElementPropertyRule());
        digester.addRule("rss/channel/item/a10:updated", new SetElementPropertyRule("dateUpdated"));
        digester.addRule("rss/channel/item/description", new SetElementPropertyRule("htmlContent"));
    }

}
