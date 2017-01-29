package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.WalletJournalResponse;

public final class CorporationWalletJournalRequest extends CorporationRequest<WalletJournalResponse> {

    public static final long MASK = 1048576;

    private final Long fromID;

    public CorporationWalletJournalRequest(long corporationID, int walletID) {
        this(corporationID, walletID, 50, -1);
    }

    public CorporationWalletJournalRequest(long corporationID, int walletID, int rowCount) {
        this(corporationID, walletID, rowCount, -1);
    }

    public CorporationWalletJournalRequest(long corporationID, int walletID, int rowCount, long fromID) {
        super(WalletJournalResponse.class, "/corp/WalletJournal.xml.aspx", MASK, corporationID);
        putParam("accountKey", walletID);
        putParam("rowCount", rowCount);

        this.fromID = (-1L == fromID) ? null : fromID;
        putParam("fromID", this.fromID);
    }

    public Long getFromID() {
        return this.fromID;
    }
}
