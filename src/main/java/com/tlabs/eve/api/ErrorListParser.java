package com.tlabs.eve.api;

import com.tlabs.eve.parser.BaseRule;
import org.apache.commons.digester3.Digester;
import org.xml.sax.Attributes;

public class ErrorListParser extends EveAPIParser<ErrorListResponse> {
    private static final class AddErrorRule extends BaseRule {
        @Override
        public void doBegin(String name, Attributes attributes) {
            ErrorListResponse r = getDigester().peek();
            r.addError(Integer.parseInt(attributes.getValue("errorCode")), attributes.getValue("errorText"));
        }
    }

    public ErrorListParser() {
        super(ErrorListResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset/row", new AddErrorRule());
    }
}
