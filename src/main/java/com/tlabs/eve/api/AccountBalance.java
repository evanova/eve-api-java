package com.tlabs.eve.api;



import java.io.Serializable;

public class AccountBalance implements Serializable {

    private static final long serialVersionUID = -5420167201513912042L;

    private long accountID;
    private long accountKey;

    private double balance;

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public long getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(long accountKey) {
        this.accountKey = accountKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalance(String balance) {
        this.balance = Double.parseDouble(balance);
    }
}
