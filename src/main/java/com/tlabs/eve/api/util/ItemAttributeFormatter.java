package com.tlabs.eve.api.util;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.HashMap;
import java.util.Map;

import com.tlabs.eve.api.ItemAttribute;

public final class ItemAttributeFormatter {

    private interface AttributeFormat {
        public String format(final ItemAttribute attr);
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
        attributesFormat = new HashMap<Integer, AttributeFormat>();
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
