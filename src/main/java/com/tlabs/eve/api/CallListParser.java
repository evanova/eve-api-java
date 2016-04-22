package com.tlabs.eve.api;



import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import org.apache.commons.digester3.Digester;
import org.xml.sax.Attributes;

/**@since Eve API V3 (30 Aug 2011*/
public class CallListParser extends EveAPIParser<CallListResponse> {

    private static class GroupOrEntryRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            String rowsetName = attributes.getValue("name");
            if ("callGroups".equalsIgnoreCase(rowsetName)) {
                CallGroup g = new CallGroup();
                getDigester().push(g);
            }
            else if ("calls".equalsIgnoreCase(rowsetName)) {
                CallEntry e = new CallEntry();
                getDigester().push(e);
            }
        }

        @Override
        public void doEnd(String name) {
            Object o = getDigester().pop();
            CallListResponse r = getDigester().peek();
            if (o instanceof CallGroup) {
                r.addGroup((CallGroup) o);
            }
            else
                if (o instanceof CallEntry) {
                    r.addEntry((CallEntry) o);
                }
        }
    }

    public CallListParser() {
        super(CallListResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset", new GroupOrEntryRule());
        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
    }
}
