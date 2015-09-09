package com.tlabs.eve.fitting;

import com.tlabs.eve.api.ItemAttribute;
import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

public final class ShipFittingParser extends AbstractXMLParser<ShipFittingResponse> {

    public ShipFittingParser() {
        super(ShipFittingResponse.class);
    }

    private static final class ModuleRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            final Fitting fit = (Fitting)getDigester().peek();
            final String slot = attributes.getValue("slot");
            if (StringUtils.isBlank(slot)) {
                return;
            }
            int slotId = -1;
            if (slot.startsWith("hi slot")) {
                slotId = ItemAttribute.FIT_HIGH_SLOTS;
            }
            else if (slot.startsWith("med slot")) {
                slotId = ItemAttribute.FIT_MEDIUM_SLOTS;
            }
            else if (slot.startsWith("low slot")) {
                slotId = ItemAttribute.FIT_LOW_SLOTS;
            }
            else if (slot.startsWith("rig slot")) {
                slotId = ItemAttribute.FIT_RIGS_SLOTS;
            }
            else if (slot.startsWith("subsystem slot")) {
                slotId = ItemAttribute.FIT_SUBSYSTEM_SLOTS;
            }
            if (slotId != -1) {
                fit.addModule(slotId, attributes.getValue("type"));
            }
            else if (slot.startsWith("drone")) {
                fit.addDrone(attributes.getValue("type"));
            }
            else if (slot.startsWith("cargo")) {
                fit.addDrone(attributes.getValue("type"));
            }
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
