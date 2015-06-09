package com.tlabs.eve.api.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tlabs.eve.parser.BooleanDeserializer;

public final class KillMailAttacker extends KillMailCharacter {

    private float securityStatus;
    private long damageDone;

    @JsonDeserialize(using = BooleanDeserializer.class)
    private boolean finalBlow;

    private long weaponTypeID;
    private String weaponTypeName;//not in JSON

    public float getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(float securityStatus) {
        this.securityStatus = securityStatus;
    }

    public long getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(long damageDone) {
        this.damageDone = damageDone;
    }

    public boolean isFinalBlow() {
        return finalBlow;
    }

    public void setFinalBlow(boolean finalBlow) {
        this.finalBlow = finalBlow;
    }

    public long getWeaponTypeID() {
        return weaponTypeID;
    }

    public void setWeaponTypeID(long weaponTypeID) {
        this.weaponTypeID = weaponTypeID;
    }

    public String getWeaponTypeName() {
        return weaponTypeName;
    }

    public void setWeaponTypeName(String weaponTypeName) {
        this.weaponTypeName = weaponTypeName;
    }
}
