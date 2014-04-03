package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Contact implements Serializable {

    private static final long serialVersionUID = 2098653879117954540L;

    public static final class Group implements Serializable {

        private static final long serialVersionUID = -2407846777057225386L;
        
        private String groupName;

        private final List<Contact> contacts = new LinkedList<Contact>();
                
        public List<Contact> getContacts() {
            return contacts;
        }

        public void addContact(final Contact contact) {
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
