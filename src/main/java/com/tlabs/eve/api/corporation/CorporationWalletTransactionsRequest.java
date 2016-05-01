package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.WalletTransactionsResponse;

public final class CorporationWalletTransactionsRequest extends CorporationRequest<WalletTransactionsResponse> {
    public static final long MASK = 2097152;

    public CorporationWalletTransactionsRequest(String corporationID, int walletID) {
        this(corporationID, walletID, 50, -1);
    }

    public CorporationWalletTransactionsRequest(String corporationID, int walletID, int rowCount, long fromID) {
        super(WalletTransactionsResponse.class, "/corp/WalletTransactions.xml.aspx", MASK, corporationID);
        //, accountIndex, 100, -1);
        putParam("accountKey", Integer.toString(walletID));
        putParam("rowCount", Integer.toString(rowCount));
        if (-1 != fromID) {
            putParam("fromID", Long.toString(fromID));
        }
    }

}
