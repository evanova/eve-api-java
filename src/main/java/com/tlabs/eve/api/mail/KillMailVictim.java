package com.tlabs.eve.api.mail;

public class KillMailVictim extends KillMailCharacter {

    private long damageTaken;

    public long getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(long damageTaken) {
        this.damageTaken = damageTaken;
    }
}
