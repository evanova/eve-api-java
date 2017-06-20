package com.tlabs.eve.esi.model;

public class ESIAsset {

    public enum LocationFlag {
        AUTOFIT("AutoFit"),
        CARGO("Cargo"),
        CORPSEBAY("CorpseBay"),
        DRONEBAY("DroneBay"),
        FLEETHANGAR("FleetHangar"),
        DELIVERIES("Deliveries"),
        HIDDENMODIFIERS("HiddenModifiers"),
        HANGAR("Hangar"),
        HANGARALL("HangarAll"),
        LOSLOT0("LoSlot0"),
        LOSLOT1("LoSlot1"),
        LOSLOT2("LoSlot2"),
        LOSLOT3("LoSlot3"),
        LOSLOT4("LoSlot4"),
        LOSLOT5("LoSlot5"),
        LOSLOT6("LoSlot6"),
        LOSLOT7("LoSlot7"),
        MEDSLOT0("MedSlot0"),
        MEDSLOT1("MedSlot1"),
        MEDSLOT2("MedSlot2"),
        MEDSLOT3("MedSlot3"),
        MEDSLOT4("MedSlot4"),
        MEDSLOT5("MedSlot5"),
        MEDSLOT6("MedSlot6"),
        MEDSLOT7("MedSlot7"),
        HISLOT0("HiSlot0"),
        HISLOT1("HiSlot1"),
        HISLOT2("HiSlot2"),
        HISLOT3("HiSlot3"),
        HISLOT4("HiSlot4"),
        HISLOT5("HiSlot5"),
        HISLOT6("HiSlot6"),
        HISLOT7("HiSlot7"),
        ASSETSAFETY("AssetSafety"),
        LOCKED("Locked"),
        UNLOCKED("Unlocked"),
        IMPLANT("Implant"),
        QUAFEBAY("QuafeBay"),
        RIGSLOT0("RigSlot0"),
        RIGSLOT1("RigSlot1"),
        RIGSLOT2("RigSlot2"),
        RIGSLOT3("RigSlot3"),
        RIGSLOT4("RigSlot4"),
        RIGSLOT5("RigSlot5"),
        RIGSLOT6("RigSlot6"),
        RIGSLOT7("RigSlot7"),
        SHIPHANGAR("ShipHangar"),
        SPECIALIZEDFUELBAY("SpecializedFuelBay"),
        SPECIALIZEDOREHOLD("SpecializedOreHold"),
        SPECIALIZEDGASHOLD("SpecializedGasHold"),
        SPECIALIZEDMINERALHOLD("SpecializedMineralHold"),
        SPECIALIZEDSALVAGEHOLD("SpecializedSalvageHold"),
        SPECIALIZEDSHIPHOLD("SpecializedShipHold"),
        SPECIALIZEDSMALLSHIPHOLD("SpecializedSmallShipHold"),
        SPECIALIZEDMEDIUMSHIPHOLD("SpecializedMediumShipHold"),
        SPECIALIZEDLARGESHIPHOLD("SpecializedLargeShipHold"),
        SPECIALIZEDINDUSTRIALSHIPHOLD("SpecializedIndustrialShipHold"),
        SPECIALIZEDAMMOHOLD("SpecializedAmmoHold"),
        SPECIALIZEDCOMMANDCENTERHOLD("SpecializedCommandCenterHold"),
        SPECIALIZEDPLANETARYCOMMODITIESHOLD("SpecializedPlanetaryCommoditiesHold"),
        SPECIALIZEDMATERIALBAY("SpecializedMaterialBay"),
        SUBSYSTEMSLOT0("SubSystemSlot0"),
        SUBSYSTEMSLOT1("SubSystemSlot1"),
        SUBSYSTEMSLOT2("SubSystemSlot2"),
        SUBSYSTEMSLOT3("SubSystemSlot3"),
        SUBSYSTEMSLOT4("SubSystemSlot4"),
        SUBSYSTEMSLOT5("SubSystemSlot5"),
        SUBSYSTEMSLOT6("SubSystemSlot6"),
        SUBSYSTEMSLOT7("SubSystemSlot7"),
        FIGHTERBAY("FighterBay"),
        FIGHTERTUBE0("FighterTube0"),
        FIGHTERTUBE1("FighterTube1"),
        FIGHTERTUBE2("FighterTube2"),
        FIGHTERTUBE3("FighterTube3"),
        FIGHTERTUBE4("FighterTube4"),
        MODULE("Module"),
        WARDROBE("Wardrobe");

        private String value;

        LocationFlag(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public enum LocationType {
        STATION("station"),
        SOLAR_SYSTEM("solar_system"),
        OTHER("other");

        private String value;

        LocationType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private boolean singleton = false;
    private Long itemId;

    private LocationFlag locationFlag = null;
    private Long locationId = null;


    private LocationType locationType = null;

    private Integer quantity = null;
    private Integer typeId = null;

    public boolean getSingleton() {
        return singleton;
    }

    public ESIAsset setSingleton(boolean singleton) {
        this.singleton = singleton;
        return this;
    }

    public Long getItemId() {
        return itemId;
    }

    public ESIAsset setItemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }

    public LocationFlag getLocationFlag() {
        return locationFlag;
    }

    public ESIAsset setLocationFlag(LocationFlag locationFlag) {
        this.locationFlag = locationFlag;
        return this;
    }

    public Long getLocationId() {
        return locationId;
    }

    public ESIAsset setLocationId(Long locationId) {
        this.locationId = locationId;
        return this;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public ESIAsset setLocationType(LocationType locationType) {
        this.locationType = locationType;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ESIAsset setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public ESIAsset setTypeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }
}
