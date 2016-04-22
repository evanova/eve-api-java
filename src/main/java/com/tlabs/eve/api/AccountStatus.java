package com.tlabs.eve.api;

import java.io.Serializable;

public class AccountStatus implements Serializable {

    private static final long serialVersionUID = -1731735135378886230L;

    private long userID;
    private long creationDate;
    private long paidUntil;

    private int logonCount;
    private long logonMinutes;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getPaidUntil() {
        return paidUntil;
    }

    public void setPaidUntil(long paidUntil) {
        this.paidUntil = paidUntil;
    }

    public int getLogonCount() {
        return logonCount;
    }

    public void setLogonCount(int logonCount) {
        this.logonCount = logonCount;
    }

    public long getLogonMinutes() {
        return logonMinutes;
    }

    public void setLogonMinutes(long logonMinutes) {
        this.logonMinutes = logonMinutes;
    }
}
