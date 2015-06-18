package com.tlabs.eve.api;



public class AccountStatusResponse extends EveAPIResponse {

    private static final long serialVersionUID = -5174573369896642855L;

    private AccountStatus accountStatus;

    public AccountStatusResponse() {
        this.accountStatus = new AccountStatus();
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

}
