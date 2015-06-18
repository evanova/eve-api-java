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
    public static final int FIT_SUBSYSTEM_SLOTS = 3772;
    public static final int FIT_RIGS_SLOTS = 1137;

    public static final int FIT_LAUNCHERS = 101;
    public static final int FIT_TURRETS = 102;
    public static final int FIT_DRONES = 106;
    public static final int FIT_UPGRADES = 1154;//rigs/hardware hardpoints

    //Character related
    public static final int BONUS_CHARISMA = 175;
    public static final int BONUS_INTELLIGENCE = 176;
    public static final int BONUS_MEMORY = 177;
    public static final int BONUS_PERCEPTION = 178;
    public static final int BONUS_WILLPOWER = 179;

    /*10-05 17:02:16.848    1034-1034/com.tlabs.android.evanova W/Evanova.Fragment﹕ Unknown Attribute ID: 974
10-05 17:02:16.848    1034-1034/com.tlabs.android.evanova W/Evanova.Fragment﹕ Unknown Attribute ID: 975
10-05 17:02:16.848    1034-1034/com.tlabs.android.evanova W/Evanova.Fragment﹕ Unknown Attribute ID: 977
10-05 17:02:16.848    1034-1034/com.tlabs.android.evanova W/Evanova.Fragment﹕ Unknown Attribute ID: 976
10-05 17:02:16.848    1034-1034/com.tlabs.android.evanova W/Evanova.Fragment﹕ Unknown Attribute ID: 1281*/
    /*    attributeID attributeName          description                                                                           iconID defaultValue published displayName                 unitID stackable highIsGood categoryID 
        ----------- ---------------------- ------------------------------------------------------------------------------------- ------ ------------ --------- --------------------------- ------ --------- ---------- ---------- 
                 12 lowSlots               The number of low power slots on the ship.                                               295          0.0 true      Low Slots                      122 true      true                1
                 13 medSlots               tbd                                                                                      294          0.0 true      Med Slots                      122 true      true                1
                 14 hiSlots                tbd                                                                                      293          0.0 true      High Slots                     122 true      true                1
                 //47 slots                  The number of slots this module requires.  Only used for launchers, bays and turrets.   NULL          1.0 false     NULL                          NULL true      true                9
                101 launcherSlotsLeft      The number of remaining unused launcher slots.                                           168          0.0 true      Launcher hardpoints            141 true      true                1
                102 turretSlotsLeft        Remaining number of unused turret slots on the ship.                                     387          0.0 true      Turret hardpoints              141 true      true                1
                106 droneBaySlotsLeft      The remaining amount of unused drone bay slots on the ship.                              138          0.0 true      Dronebay hardpoints           NULL true      true               10
                //623 cloakingSlotsLeftSuper hot-fix for not allowing warpable cloaking modules on anything but covert-ops frigs        0          0.0 false     NULL                          NULL true      true                9
                //980 hasCloneJumpSlots      The number of clone jump slots that the ship offers.                                       0          0.0 false     NULL                          NULL true      true                9
               1137 rigSlots               The number of rig slots on the ship.                                                    3266          0.0 true      Rig Slots                      122 true      true                1
               1154 upgradeSlotsLeft       How many upgrades can by fitted to this ship.                                           3266          0.0 true      Upgrade Hardpoints             141 true      true                7     
        */

    private int attributeID;
    private float attributeValue;
    private int categoryID;

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
}