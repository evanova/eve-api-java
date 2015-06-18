package com.tlabs.eve.api;



import java.util.LinkedList;
import java.util.List;

public class AccountBalanceResponse extends EveAPIResponse {

    private static final long serialVersionUID = 2278419737696580565L;

    private List<AccountBalance> accountBalance;

    public AccountBalanceResponse() {
        accountBalance = new LinkedList<>();
    }

    public List<AccountBalance> getAccountBalance() {
        return accountBalance;
    }

    public void addAccountBalance(AccountBalance accountBalance) {
        this.accountBalance.add(accountBalance);
    }

}
