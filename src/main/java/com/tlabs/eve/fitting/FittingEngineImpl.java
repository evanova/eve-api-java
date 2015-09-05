package com.tlabs.eve.fitting;

import com.tlabs.eve.api.ItemAttribute;

import java.util.HashMap;
import java.util.Map;

public class FittingEngineImpl implements FittingEngine {

    private static final class FittedShip extends Ship {
        private final Map<Integer, ItemAttribute> originalAttributes;
        private final Map<Integer, ItemAttribute> fittedAttributes;

        public FittedShip(final Ship ship) {
            super(ship);

            this.originalAttributes = ship.getAttributes();
            this.fittedAttributes = new HashMap<>();
            this.fittedAttributes.putAll(this.originalAttributes);
        }

        @Override
        public boolean addModule(Module module) {
            if (super.addModule(module)) {
                this.fittedAttributes.clear();
                this.fittedAttributes.putAll(build(this.originalAttributes));
                return true;
            }
            return false;
        }

        @Override
        public boolean removeModule(long slotId, int position) {
            if (super.removeModule(slotId, position)) {
                this.fittedAttributes.clear();
                this.fittedAttributes.putAll(build(this.originalAttributes));
                return true;
            }
            return false;
        }

        @Override
        public Map<Integer, ItemAttribute> getAttributes() {
            return this.fittedAttributes;
        }

        @Override
        public ItemAttribute getAttribute(int attributeId) {
            final ItemAttribute attribute = super.getAttribute(attributeId);
         /*   if (null == attribute) {
                Log.e(LOG, "attributeId[" + attributeId + "] = null");
            }
            else {
                Log.e(LOG, "attributeId[" + attributeId + "] = " + ToStringBuilder.reflectionToString(attribute));
            }*/
            return attribute;
        }
    }

    @Override
    public Ship fit(Ship ship) {
        //return new FittedShip(ship);
        return ship;
    }


    //This is where all the calculation happens! Go ahead and implement this if you dare.
    private static Map<Integer, ItemAttribute> build(final Map<Integer, ItemAttribute> originalAttributes) {
        return originalAttributes;
    }

}
