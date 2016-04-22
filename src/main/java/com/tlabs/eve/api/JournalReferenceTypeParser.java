package com.tlabs.eve.api;



import com.tlabs.eve.parser.BaseRule;

import org.apache.commons.digester3.Digester;
import org.xml.sax.Attributes;

public class JournalReferenceTypeParser extends EveAPIParser<JournalReferenceTypeResponse> {

    private static final class AddRefRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            JournalReferenceTypeResponse r = getDigester().peek();
            r.addReference(Long.parseLong(attributes.getValue("refTypeID")), attributes.getValue("refTypeName"));
        }
    }

    public JournalReferenceTypeParser() {
        super(JournalReferenceTypeResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset/row", new AddRefRule());
    }
}
