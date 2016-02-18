package com.tlabs.eve.api.mail;



public class MailMessage extends Message {

    private static final long serialVersionUID = 3521271683902916731L;

    private long toListID = -1;
    private long toCorpOrAllianceID = -1;
    private String toCharsID = "";

    public final String getToCharacterIDs() {
        return toCharsID;
    }

    public final void setToCharacterIDs(String recipientsCSV) {
        this.toCharsID = recipientsCSV;
    }

    public final long getToListID() {
        return toListID;
    }

    public final void setToListID(long toListID) {
        this.toListID = toListID;
    }

    public final long getToCorpOrAllianceID() {
        return toCorpOrAllianceID;
    }

    public final void setToCorpOrAllianceID(long toCorpOrAllianceID) {
        this.toCorpOrAllianceID = toCorpOrAllianceID;
    }
}
