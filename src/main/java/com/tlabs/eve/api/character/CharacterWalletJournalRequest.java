package com.tlabs.eve.api.character;



import com.tlabs.eve.api.WalletJournalResponse;

public final class CharacterWalletJournalRequest extends CharacterRequest<WalletJournalResponse> {
    public static final long MASK = 2097152;

    public CharacterWalletJournalRequest(long characterID) {
        this(characterID, 50, -1);
    }

    public CharacterWalletJournalRequest(long characterID, int rowCount, long fromID) {
        super(WalletJournalResponse.class, "/char/WalletJournal.xml.aspx", MASK, characterID);

        putParam("accountKey", Integer.toString(1000));
        putParam("rowCount", Integer.toString(rowCount));
        if (-1 != fromID) {
            putParam("fromID", Long.toString(fromID));
        }
    }

    public Long getFromID() {
        return getLong("fromID");
    }
}
