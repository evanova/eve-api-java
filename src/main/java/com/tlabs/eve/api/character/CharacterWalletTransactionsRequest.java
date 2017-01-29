package com.tlabs.eve.api.character;



import com.tlabs.eve.api.WalletTransactionsResponse;

public final class CharacterWalletTransactionsRequest extends CharacterRequest<WalletTransactionsResponse> {
    public static final long MASK = 4194304;

    private final Long fromID;

    public CharacterWalletTransactionsRequest(long characterID) {
        this(characterID, 50, -1);
    }

    public CharacterWalletTransactionsRequest(long characterID, int rowCount) {
        this(characterID, rowCount, -1);
    }

    public CharacterWalletTransactionsRequest(long characterID, int rowCount, long fromID) {
        super(WalletTransactionsResponse.class, "/char/WalletTransactions.xml.aspx", MASK, characterID);
        putParam("accountKey", 1000);
        putParam("rowCount", rowCount);

        this.fromID = (-1L == fromID) ? null : fromID;
        putParam("fromID", this.fromID);
    }

    public Long getFromID() {
        return this.fromID;
    }
}
