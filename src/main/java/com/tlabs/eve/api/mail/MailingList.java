package com.tlabs.eve.api.mail;



import java.io.Serializable;

public class MailingList implements Serializable {

    private static final long serialVersionUID = -2421066227774550183L;

    private long listID = -1;
    private String displayName = "";

    public final long getListID() {
        return listID;
    }

    public final void setListID(long listID) {
        this.listID = listID;
    }

    public final String getDisplayName() {
        return displayName;
    }

    public final void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
