package com.tlabs.eve.api.util;


import com.tlabs.eve.api.ItemAttribute;

import java.util.HashMap;
import java.util.Map;

public final class ItemAttributeFormatter {

    private interface AttributeFormat {
        String format(final ItemAttribute attr);
    }

    private static final class UnitFormat implements AttributeFormat {

        private final String unit;

        public UnitFormat(final String unit) {
            this.unit = unit;
        }

        @Override
        public String format(ItemAttribute attr) {
            return attr.getValue() + " " + unit;
        }
    }

    private static final AttributeFormat defaultFormat = new AttributeFormat() {
        @Override
        public String format(ItemAttribute attr) {
            return Float.toString(attr.getValue());
        }
    };

    private static final AttributeFormat integerFormat = new AttributeFormat() {
        @Override
        public String format(ItemAttribute attr) {
            return Integer.toString(Math.round(attr.getValue()));
        }
    };

    private static final AttributeFormat rangeFormat = new AttributeFormat() {
        @Override
        public String format(ItemAttribute attr) {
            return Integer.toString((int) (attr.getValue() / 1000f)) + "Km";
        }
    };

    private static final AttributeFormat secondFormat = new AttributeFormat() {
        @Override
        public String format(ItemAttribute attr) {
            return Integer.toString((int) (attr.getValue() / 1000f)) + "s";
        }
    };

    private static final AttributeFormat resistanceFormat = new AttributeFormat() {
        @Override
        public String format(ItemAttribute attr) {
            return Integer.toString((int) (100f - attr.getValue() * 100f)) + "%";
        }
    };

    private static final Map<Integer, AttributeFormat> attributesFormat;

    static {
        attributesFormat = new HashMap<>();
        attributesFormat.put(ItemAttribute.FIT_HIGH_SLOTS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_MEDIUM_SLOTS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_LOW_SLOTS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_RIGS_SLOTS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_SUBSYSTEM_SLOTS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_UPGRADES, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_LAUNCHERS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_TURRETS, integerFormat);
        attributesFormat.put(ItemAttribute.FIT_DRONES, integerFormat);

        attributesFormat.put(ItemAttribute.MASS, new UnitFormat("Kg"));
        attributesFormat.put(ItemAttribute.VOLUME, new UnitFormat("m3"));

        attributesFormat.put(ItemAttribute.STRUCTURE_HP, new UnitFormat("HP"));
        attributesFormat.put(ItemAttribute.DRONE_CAPACITY, new UnitFormat("m3"));
        attributesFormat.put(ItemAttribute.DRONE_BANDWIDTH, new UnitFormat("Mbit/sec"));

        attributesFormat.put(ItemAttribute.STRUCTURE_INERTIA_MOD, new UnitFormat("x"));
        attributesFormat.put(ItemAttribute.STRUCTURE_EM, resistanceFormat);
        attributesFormat.put(ItemAttribute.STRUCTURE_EXP, resistanceFormat);
        attributesFormat.put(ItemAttribute.STRUCTURE_KINETIC, resistanceFormat);
        attributesFormat.put(ItemAttribute.STRUCTURE_THERMAL, resistanceFormat);

        attributesFormat.put(ItemAttribute.ARMOR_HP, new UnitFormat("HP"));
        attributesFormat.put(ItemAttribute.ARMOR_EM_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.ARMOR_EXP_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.ARMOR_KINETIC_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.ARMOR_THERMAL_RES, resistanceFormat);

        attributesFormat.put(ItemAttribute.SHIELD_HP, new UnitFormat("HP"));
        attributesFormat.put(ItemAttribute.SHIELD_RECHARGE, secondFormat);
        attributesFormat.put(ItemAttribute.SHIELD_EM_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.SHIELD_EXP_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.SHIELD_KINETIC_RES, resistanceFormat);
        attributesFormat.put(ItemAttribute.SHIELD_THERMAL_RES, resistanceFormat);

        attributesFormat.put(ItemAttribute.CAPACITOR_CAPACITY, new UnitFormat("Gj"));
        attributesFormat.put(ItemAttribute.CAPACITOR_RECHARGE, secondFormat);

        attributesFormat.put(ItemAttribute.TARGETING_RANGE, rangeFormat);
        attributesFormat.put(ItemAttribute.TARGETING_TARGETS, new UnitFormat("x"));
        attributesFormat.put(ItemAttribute.GRAVIMETRIC_STRENGTH, new UnitFormat("points"));
        attributesFormat.put(ItemAttribute.SCAN_RESOLUTION, new UnitFormat("mm"));
        attributesFormat.put(ItemAttribute.SIGNATURE_RADIUS, new UnitFormat("m"));

        attributesFormat.put(ItemAttribute.VELOCITY_MAX, new UnitFormat("m/s"));
        attributesFormat.put(ItemAttribute.VELOCITY_WARP, new UnitFormat("AU/s"));
    }

    private ItemAttributeFormatter() {
    }

    public static String format(final ItemAttribute attribute) {
        final AttributeFormat format = attributesFormat.get(attribute.getID());
        return (null == format) ? defaultFormat.format(attribute) : format.format(attribute);
    }

}
