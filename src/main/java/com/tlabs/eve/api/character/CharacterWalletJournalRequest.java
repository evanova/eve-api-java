package com.tlabs.eve.api.character;



import com.tlabs.eve.api.WalletJournalResponse;

public final class CharacterWalletJournalRequest extends CharacterRequest<WalletJournalResponse> {
    public static final long MASK = 2097152;

    private final Long fromID;

    public CharacterWalletJournalRequest(long characterID) {
        this(characterID, 50, -1);
    }
    public CharacterWalletJournalRequest(long characterID, int rowCount) {
        this(characterID, rowCount, -1);
    }

    public CharacterWalletJournalRequest(long characterID, int rowCount, long fromID) {
        super(WalletJournalResponse.class, "/char/WalletJournal.xml.aspx", MASK, characterID);

        putParam("accountKey", 1000);
        putParam("rowCount", rowCount);

        this.fromID = (-1L == fromID) ? null : fromID;
        putParam("fromID", this.fromID);
    }


    public Long getFromID() {
        return this.fromID;
    }
}
