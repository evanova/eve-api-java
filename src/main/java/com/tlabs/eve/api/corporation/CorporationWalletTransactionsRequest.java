package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.WalletTransactionsResponse;

public final class CorporationWalletTransactionsRequest extends CorporationRequest<WalletTransactionsResponse> {
    public static final long MASK = 2097152;

    private final Long fromID;

    public CorporationWalletTransactionsRequest(long corporationID, int walletID) {
        this(corporationID, walletID, 50, -1);
    }

    public CorporationWalletTransactionsRequest(long corporationID, int walletID, int rowCount) {
        this(corporationID, walletID, rowCount, -1);
    }

    public CorporationWalletTransactionsRequest(long corporationID, int walletID, int rowCount, long fromID) {
        super(WalletTransactionsResponse.class, "/corp/WalletTransactions.xml.aspx", MASK, corporationID);
        putParam("accountKey", walletID);
        putParam("rowCount", rowCount);

        this.fromID = (-1L == fromID) ? null : fromID;
        putParam("fromID", this.fromID);
    }

    public Long getFromID() {
        return this.fromID;
    }
}
