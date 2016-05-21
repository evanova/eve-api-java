package com.tlabs.eve.api;


import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public class WalletJournalEntry implements Serializable {

    private static final long serialVersionUID = 106263246493601523L;

    private long when;
    private long id;

    private long refTypeID;
    private String refTypeName;//not in XML

    private String ownerName1;
    private long ownerID1;

    private String ownerName2;
    private long ownerID2;

    private String reason = "";

    private double amount;
    private double balance;

    //argName1,argID1, taxReceiverID, taxAmount"
    private long argID;
    private String argName;

    private long taxReceiverID;
    private double taxAmount;

    public final long getWhen() {
        return when;
    }

    public final void setWhen(long when) {
        this.when = when;
    }

    public final long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public final long getRefTypeID() {
        return refTypeID;
    }

    public final void setRefTypeID(long refTypeID) {
        this.refTypeID = refTypeID;
    }

    public final String getOwnerName1() {
        return ownerName1;
    }

    public final void setOwnerName1(String ownerName1) {
        this.ownerName1 = ownerName1;
    }

    public final long getOwnerID1() {
        return ownerID1;
    }

    public final void setOwnerID1(long ownerID1) {
        this.ownerID1 = ownerID1;
    }

    public final String getOwnerName2() {
        return ownerName2;
    }

    public final void setOwnerName2(String ownerName2) {
        this.ownerName2 = ownerName2;
    }

    public final long getOwnerID2() {
        return ownerID2;
    }

    public final void setOwnerID2(long ownerID2) {
        this.ownerID2 = ownerID2;
    }

    public final String getReason() {
        return reason;
    }

    public final void setReason(String reason) {
        if (StringUtils.isBlank(reason)) {
            this.reason = "";
        }
        else {
            //Not sure why this is there, but it is.
            this.reason = StringUtils.removeStart(reason, "DESC:").trim();
        }
    }

    public final double getAmount() {
        return amount;
    }

    public final void setAmount(double amount) {
        this.amount = amount;
    }

    public final double getBalance() {
        return balance;
    }

    public final void setBalance(double balance) {
        this.balance = balance;
    }

    public final long getArgID() {
        return argID;
    }

    public final void setArgID(long argID) {
        this.argID = argID;
    }

    public final String getArgName() {
        return argName;
    }

    public final void setArgName(String argName) {
        this.argName = argName;
    }

    public final long getTaxReceiverID() {
        return taxReceiverID;
    }

    public final void setTaxReceiverID(long taxReceiverID) {
        this.taxReceiverID = taxReceiverID;
    }

    public final double getTaxAmount() {
        return taxAmount;
    }

    public final void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public final String getRefTypeName() {
        return refTypeName;
    }

    public final void setRefTypeName(String refTypeName) {
        this.refTypeName = refTypeName;
    }
}
