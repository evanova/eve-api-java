package com.tlabs.eve.api;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class EveContact implements Serializable {

    private static final long serialVersionUID = 2098653879117954540L;

    public static final class Group implements Serializable {

        private static final long serialVersionUID = -2407846777057225386L;
        
        private String groupName;

        private final List<EveContact> contacts = new LinkedList<EveContact>();
                
        public List<EveContact> getContacts() {
            return contacts;
        }

        public void addContact(final EveContact contact) {
            this.contacts.add(contact);
        }
       
        public String getName() {
            return groupName;
        }

        public void setName(String groupName) {
            this.groupName = groupName;
        }

    }

    private long contactID;
    private String contactName;

    private boolean inWatchlist = false;
    private int standing;

    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public boolean getInWatchlist() {
        return inWatchlist;
    }

    public void setInWatchlist(boolean inWatchlist) {
        this.inWatchlist = inWatchlist;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

}
