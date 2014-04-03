package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2014 Traquenard Labs
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


import java.io.Serializable;

//This is not part of the API but part of the data dump.
public final class ItemAttribute implements Serializable {
    
    private static final long serialVersionUID = 1486870784673678791L;
    
    public static final int MASS = 4;
    public static final int VOLUME = 161;
    
    public static final int STRUCTURE_HP = 9;
    public static final int STRUCTURE_DRONE_CAPACITY = 283;
    public static final int STRUCTURE_DRONE_BANDWIDTH = 1271;
    
    public static final int STRUCTURE_INERTIA_MOD = 70;
    public static final int STRUCTURE_EM_RES = 113;
    public static final int STRUCTURE_EXP_RES = 111;
    public static final int STRUCTURE_KINETIC_RES = 109;
    public static final int STRUCTURE_THERMAL_RES = 110;
    
    public static final int ARMOR_HP = 265;
    public static final int ARMOR_EM_RES = 267;
    public static final int ARMOR_EXP_RES = 268;
    public static final int ARMOR_KINETIC_RES = 269;
    public static final int ARMOR_THERMAL_RES = 270;
    
    public static final int SHIELD_HP = 263;
    public static final int SHIELD_RECHARGE = 479;
    public static final int SHIELD_EM_RES = 271;
    public static final int SHIELD_EXP_RES = 272;
    public static final int SHIELD_KINETIC_RES = 273;
    public static final int SHIELD_THERMAL_RES = 274;
    
    public static final int CAPACITOR_CAPACITY = 482;
    public static final int CAPACITOR_RECHARGE = 55;
    public static final int CAPACITOR_NEED = 6;
    
    public static final int CPU_NEED = 50;
    public static final int CPU_CAPACITY = 48;
    
    public static final int POWER_NEED = 30;
    public static final int POWER_CAPACITY = 11;
    
    public static final int TARGETING_RANGE = 76;
    public static final int TARGETING_TARGETS = 192;
    public static final int GRAVIMETRIC_STRENGTH = 211;
    public static final int SCAN_RESOLUTION = 564;
    public static final int SIGNATURE_RADIUS = 552;
    public static final int VELOCITY_MAX = 37;
    public static final int VELOCITY_WARP = 1281;
    
    public static final int PRIMARY_PILOT_ATTRIBUTE = 180;
    public static final int SECONDARY_PILOT_ATTRIBUTE = 181;
    
    public static final int PRIMARY_SKILL = 182;
    public static final int SECONDARY_SKILL = 183;
    
    public static final int TECH_LEVEL = 422;
    public static final int META_LEVEL = 633;
    
    public static final int SHIP_RESTRICTION = 1380;
    
    public static final int FIT_LOW_SLOTS = 12;
    public static final int FIT_MEDIUM_SLOTS = 13;
    public static final int FIT_HIGH_SLOTS = 14;
    public static final int FIT_RIGS_SLOTS = 1137;
    
    public static final int FIT_LAUNCHERS = 101;
    public static final int FIT_TURRETS = 102;
    public static final int FIT_DRONES = 106;
    public static final int FIT_UPGRADES = 1154;//rigs/hardware hardpoints
    
    
    
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