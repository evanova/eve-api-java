package com.tlabs.eve.dotlan.model;

public class DotlanJumpOptions extends DotlanOptions {

    private int jumpDriveCalibration = 5;
    private int jumpFuelConservation = 5;
    private int jumpFreighter = 5;

    private boolean preferSolarSystems = false;
    private boolean avoidIncursions = false;

    private String jumpShip;

    public String getJumpShip() {
        return jumpShip;
    }

    public DotlanJumpOptions setJumpShip(String jumpShip) {
        this.jumpShip = jumpShip;
        return this;
    }

    public int getJumpDriveCalibrationSkill() {
        return jumpDriveCalibration;
    }

    public DotlanJumpOptions setJumpDriveCalibrationSkill(int jumpDriveCalibration) {
        this.jumpDriveCalibration = jumpDriveCalibration;
        return this;
    }

    public int getJumpFuelConservationSkill() {
        return jumpFuelConservation;
    }

    public DotlanJumpOptions setJumpFuelConservationSkill(int jumpFuelConservation) {
        this.jumpFuelConservation = jumpFuelConservation;
        return this;
    }

    public int getJumpFreighterSkill() {
        return jumpFreighter;
    }

    public DotlanJumpOptions setJumpFreighterSkill(int jumpFreighter) {
        this.jumpFreighter = jumpFreighter;
        return this;
    }

    public boolean getPreferSolarSystems() {
        return preferSolarSystems;
    }

    public DotlanJumpOptions setPreferSolarSystems(boolean preferSolarSystems) {
        this.preferSolarSystems = preferSolarSystems;
        return this;
    }

    public boolean getAvoidIncursions() {
        return avoidIncursions;
    }

    public DotlanJumpOptions setAvoidIncursions(boolean avoidIncursions) {
        this.avoidIncursions = avoidIncursions;
        return this;
    }
}
