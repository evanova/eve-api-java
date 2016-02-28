package com.tlabs.eve.api.mail;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {

    public static final int CORPORATION = 2;//contactTypeID
    public static final int ALLIANCE = 16159;//contactTypeID

    private static final long serialVersionUID = 2098653879117954540L;

    public static final class Group implements Serializable {

        private static final long serialVersionUID = -2407846777057225386L;

        private String name;

        private final List<Contact> contacts = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Contact> getContacts() {
            return contacts;
        }

        public void addContact(final Contact contact) {
            this.contacts.add(contact);
        }
    }

    private long contactTypeID;
    private long contactID;
    private String contactName;

    private boolean inWatchlist = false;
    private float standing;

    public boolean getInWatchlist() {
        return inWatchlist;
    }

    public void setInWatchlist(boolean inWatchlist) {
        this.inWatchlist = inWatchlist;
    }

    public long getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(long contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

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

    public float getStanding() {
        return standing;
    }

    public void setStanding(float standing) {
        this.standing = standing;
    }
}
