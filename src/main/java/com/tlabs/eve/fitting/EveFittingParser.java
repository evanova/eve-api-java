package com.tlabs.eve.fitting;

import org.apache.commons.digester.Digester;
import org.apache.commons.lang.StringUtils;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.AbstractXMLParser;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetElementPropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public class EveFittingParser extends AbstractXMLParser<EveFittingResponse> {

    public EveFittingParser() {
        super(EveFittingResponse.class);        
    }

    private static final class SlotRule extends BaseRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            final String slotName = attributes.getValue("slot");
            if (StringUtils.isBlank(slotName)) {
                return;
            }
            
            ShipFitting.Slot slot = null;
            
            if (slotName.startsWith("rig")) {
                slot = new ShipFitting.Slot(ShipFitting.Slot.Type.RIG);
            }
            else if (slotName.startsWith("med slot")) {
                slot = new ShipFitting.Slot(ShipFitting.Slot.Type.MEDIUM);
            }
            else if (slotName.startsWith("hi slot")) {
                slot = new ShipFitting.Slot(ShipFitting.Slot.Type.HIGH);
            }
            else if (slotName.startsWith("low slot")) {
                slot = new ShipFitting.Slot(ShipFitting.Slot.Type.LOW);
            }
            
            if (null == slot) {
                return;
            }
            
            slot.setItemTypeName(attributes.getValue("type"));
            final ShipFitting fit = (ShipFitting)getDigester().peek();
            fit.addSlot(slot);            
        }        
    }
    @Override
    protected void init(Digester digester) {
        digester.addObjectCreate("fittings/fitting", ShipFitting.class);
        digester.addRule("fittings/fitting", new SetAttributePropertyRule("name", "name"));
        digester.addRule("fittings/fitting", new SetNextRule("addShipFitting"));
        
        digester.addRule("fittings/fitting/description", new SetAttributePropertyRule("value", "description"));
        digester.addRule("fittings/fitting/shipType", new SetAttributePropertyRule("value", "shipTypeName"));
        
        digester.addRule("fittings/fitting/hardware", new SlotRule());
    }

}
