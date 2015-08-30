package com.tlabs.eve.fitting;

import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

final class ShipFittingParser extends AbstractXMLParser<ShipFittingResponse> {

    public ShipFittingParser() {
        super(ShipFittingResponse.class);
    }

    private static final class ModuleRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            final Fitting fit = (Fitting)getDigester().peek();
            fit.addModule(attributes.getValue("type"));
        }        
    }
    @Override
    protected void init(Digester digester) {
        digester.addObjectCreate("fittings/fitting", Fitting.class);
        digester.addRule("fittings/fitting", new SetAttributePropertyRule("name", "name"));
        digester.addRule("fittings/fitting", new SetNextRule("addShipFitting"));
        
        digester.addRule("fittings/fitting/description", new SetAttributePropertyRule("value", "description"));
        digester.addRule("fittings/fitting/shipType", new SetAttributePropertyRule("value", "typeName"));
        
        digester.addRule("fittings/fitting/hardware", new ModuleRule());
    }

}
