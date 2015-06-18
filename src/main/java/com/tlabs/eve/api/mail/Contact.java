package com.tlabs.eve.api.mail;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact implements Serializable {

    public static final int CORPORATION = 2;//contactTypeID
    public static final int ALLIANCE = 16159;//contactTypeID

    private static final long serialVersionUID = 2098653879117954540L;

    public static final class Group implements Serializable {

        private static final long serialVersionUID = -2407846777057225386L;

        @Getter
        @Setter
        private String name;

        private final List<Contact> contacts = new LinkedList<>();

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

}
