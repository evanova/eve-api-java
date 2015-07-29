package com.tlabs.eve.api.mail;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tlabs.eve.parser.DateDeserializer;

import java.util.LinkedList;
import java.util.List;

public class KillMail {

    private long killID;

    @JsonDeserialize(using = DateDeserializer.class)
    private long killTime;

    private long solarSystemID;

    private String solarSystemName;//not in JSON

    private long moonID;

    private KillMailVictim victim;

    private List<KillMailAttacker> attackers = new LinkedList<>();

    private List<KillMailItem> items = new LinkedList<>();

    public final boolean getFinalBlow(final long attackerId) {
        for (KillMailAttacker a : this.attackers) {
            if (a.isFinalBlow() && (a.getCharacterID() == attackerId)) {
                return true;
            }
        }
        return false;
    }

    public long getKillID() {
        return killID;
    }

    public void setKillID(long killID) {
        this.killID = killID;
    }

    public long getKillTime() {
        return killTime;
    }

    public void setKillTime(long killTime) {
        this.killTime = killTime;
    }

    public long getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(long solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public long getMoonID() {
        return moonID;
    }

    public void setMoonID(long moonID) {
        this.moonID = moonID;
    }

    public KillMailVictim getVictim() {
        return victim;
    }

    public void setVictim(KillMailVictim victim) {
        this.victim = victim;
    }

    public List<KillMailAttacker> getAttackers() {
        return attackers;
    }

    public void setAttackers(List<KillMailAttacker> attackers) {
        this.attackers = attackers;
    }

    public List<KillMailItem> getItems() {
        return items;
    }

    public void setItems(List<KillMailItem> items) {
        this.items = items;
    }
}
