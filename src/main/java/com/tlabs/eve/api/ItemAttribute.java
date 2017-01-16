package com.tlabs.eve.api;



import java.io.Serializable;

//This is not part of the API but part of the data dump.
public final class ItemAttribute implements Serializable {

    private static final long serialVersionUID = 1486870784673678791L;

    public static final int MASS = 4;
    public static final int VOLUME = 161;

    public static final int STRUCTURE_HP = 9;
    public static final int STRUCTURE_HP_BONUS = 150;
    public static final int DRONE_CAPACITY = 283;
    public static final int DRONE_BANDWIDTH = 1271;

    public static final int STRUCTURE_INERTIA_MOD = 70;
    public static final int STRUCTURE_EM = 113;
    public static final int STRUCTURE_EXP = 111;
    public static final int STRUCTURE_KINETIC = 109;
    public static final int STRUCTURE_THERMAL = 110;
    public static final int STRUCTURE_EM_RES = 974;
    public static final int STRUCTURE_EXP_RES = 975;
    public static final int STRUCTURE_KINETIC_RES = 976;
    public static final int STRUCTURE_THERMAL_RES = 977;

    public static final int ARMOR_HP = 265;
    public static final int ARMOR_EM_RES = 267;
    public static final int ARMOR_EXP_RES = 268;
    public static final int ARMOR_KINETIC_RES = 269;
    public static final int ARMOR_THERMAL_RES = 270;

    public static final int SHIELD_HP = 263;
    public static final int SHIELD_HITPOINT_BONUS = 72;
    public static final int SHIELD_CAPACITY_BONUS = 337;
    public static final int SHIELD_RECHARGE = 479;
    public static final int SHIELD_EM_RES = 271;
    public static final int SHIELD_EXP_RES = 272;
    public static final int SHIELD_KINETIC_RES = 273;
    public static final int SHIELD_THERMAL_RES = 274;

    public static final int CAPACITOR_CAPACITY = 482;
    public static final int CAPACITOR_CAPACITY_BONUS = 147;
    public static final int CAPACITOR_RECHARGE = 55;
    public static final int CAPACITOR_NEED = 6;
    public static final int CAPACITOR_NEED_BONUS = 317;
    public static final int CAPACITOR_NEED_MULTIPLIER = 216;

    public static final int CPU_NEED = 50;
    public static final int CPU_LOAD = 49;
    public static final int CPU_CAPACITY = 48;
    public static final int CPU_NEED_MULTIPLIER = 202;//Factor to adjust module cpu need by.
    public static final int CPU_NEED_BONUS = 310;
    public static final int CPU_OUTPUT_BONUS = 424;

    public static final int POWER_NEED = 30;
    public static final int POWER_LOAD = 15;//Current load of power core
    public static final int POWER_CAPACITY = 11;
    public static final int POWER_OUTPUT_BONUS = 121;
    public static final int POWER_OUTPUT_MULTIPLIER = 145;//Multiplier to power core output.
    public static final int POWER_OUTPUT_ADD = 1378;

    public static final int TARGETING_RANGE = 76;
    public static final int TARGETING_TARGETS = 192;
    public static final int GRAVIMETRIC_STRENGTH = 211;
    public static final int SCAN_RESOLUTION = 564;
    public static final int SIGNATURE_RADIUS = 552;

    //There is 2 actually; one with Camel Case name, one without - both %
    public static final int SIGNATURE_RADIUS_BONUS = 554;
    public static final int SIGNATURE_RADIUS_BONUS2 = 983;

    public static final int VELOCITY_MAX = 37;
    public static final int VELOCITY_MODIFIER = 1076;
    public static final int VELOCITY_WARP = 1281;

    public static final int PRIMARY_PILOT_ATTRIBUTE = 180;
    public static final int SECONDARY_PILOT_ATTRIBUTE = 181;

    public static final int PRIMARY_SKILL = 182;
    public static final int PRIMARY_SKILL_LEVEL = 277;
    public static final int SECONDARY_SKILL = 183;

    public static final int TECH_LEVEL = 422;
    public static final int META_LEVEL = 633;

    public static final int SHIP_RESTRICTION = 1380;

    public static final int FIT_LOW_SLOTS = 12;
    public static final int FIT_MEDIUM_SLOTS = 13;
    public static final int FIT_HIGH_SLOTS = 14;
    //public static final int FIT_SUBSYSTEM_SLOTS = 3772;
    public static final int FIT_SUBSYSTEM_SLOTS = 1367;
    //public static final int FIT_RIGS_SLOTS = 1137;
    public static final int FIT_RIGS_SLOTS = 1154;

    public static final int FIT_LAUNCHERS = 101;
    public static final int FIT_TURRETS = 102;
    public static final int FIT_DRONES = 106;
   // public static final int FIT_UPGRADES = 1154;//rigs/hardware hardpoints

    //Character related
    public static final int BONUS_CHARISMA = 175;
    public static final int BONUS_INTELLIGENCE = 176;
    public static final int BONUS_MEMORY = 177;
    public static final int BONUS_PERCEPTION = 178;
    public static final int BONUS_WILLPOWER = 179;

    private int attributeID;
    private float attributeValue;
    private float initialValue;

    private int categoryID;
    private String categoryName;//not in XML

    private String attributeName;

    public int getID() {
        return attributeID;
    }

    public void setID(int attributeID) {
        this.attributeID = attributeID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return attributeName;
    }

    public void setName(String attributeName) {
        this.attributeName = attributeName;
    }

    public float getValue() {
        return attributeValue;
    }

    public void setValue(float attributeValue) {
        this.attributeValue = attributeValue;
    }


	public float getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(float initialValue) {
		this.initialValue = initialValue;
    }
}