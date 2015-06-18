package com.tlabs.eve.api;

import java.io.Serializable;

public class ContractBid implements Serializable {

    private static final long serialVersionUID = -5988962546869289837L;

    private long bidID;
    private long contractID;
    private long bidderID;
    private String bidderName;//not in xml

    private long bidDate;
    private long amount;

    public long getBidID() {
        return bidID;
    }

    public void setBidID(long bidID) {
        this.bidID = bidID;
    }

    public long getContractID() {
        return contractID;
    }

    public void setContractID(long contractID) {
        this.contractID = contractID;
    }

    public long getBidderID() {
        return bidderID;
    }

    public void setBidderID(long bidderID) {
        this.bidderID = bidderID;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public long getBidDate() {
        return bidDate;
    }

    public void setBidDate(long bidDate) {
        this.bidDate = bidDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
