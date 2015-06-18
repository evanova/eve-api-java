package com.tlabs.eve.central;



import com.tlabs.eve.parser.AbstractXMLParser;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.Rule;
import org.xml.sax.Attributes;

public abstract class EveCentralParser<T extends EveCentralResponse> extends AbstractXMLParser<T> {

    private class InitRule extends Rule {
        @Override
        public void begin(String namespace, String name, Attributes attributes) throws Exception {
            long now = System.currentTimeMillis();
            T t = (T) getDigester().peek();
            t.setDateTime(now);
            t.setCachedUntil(now + 60l * 60l * 1000l);
        }
    }

    public EveCentralParser(Class<T> responseClass) {
        super(responseClass);
    }

    protected void onInit(Digester digester) {
    }

    @Override
    protected final void init(Digester digester) {
        digester.addRule("evec_api", new InitRule());
        onInit(digester);
    }
}
