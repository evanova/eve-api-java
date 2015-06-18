package com.tlabs.eve.api;



import java.util.LinkedList;
import java.util.List;

public final class WalletTransactionsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -2618013377703372798L;

    private List<WalletTransaction> transactions = new LinkedList<>();

    public final void addTransaction(WalletTransaction t) {
        this.transactions.add(t);
    }

    public final List<WalletTransaction> getTransactions() {
        return transactions;
    }
}
