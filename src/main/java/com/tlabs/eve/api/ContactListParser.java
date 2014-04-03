package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2010 - 2012 Traquenard Labs
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


import org.apache.commons.digester.Digester;
import org.apache.commons.lang.Validate;
import org.xml.sax.Attributes;

import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;

public class ContactListParser extends EveAPIParser<ContactListResponse> {
    private static final class AddContactRule extends SetAttributePropertyRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            if (getDigester().peek() instanceof Contact.Group) {
                getDigester().push(new Contact());
                super.doBegin(name, attributes);
            }            
        }

        @Override
        public void doEnd(String name) {
            if (getDigester().peek() instanceof Contact) {
                final Contact contact = (Contact)getDigester().pop();
                final Contact.Group group = (Contact.Group)getDigester().peek();
                group.addContact(contact);
            }
        }
        
    }
    
    private static final class AddGroupRule extends BaseRule {
        private final String filterContactList;
        
        public AddGroupRule(final String filterContactListName) {
            super();
            this.filterContactList = filterContactListName;
            Validate.notNull(this.filterContactList);        
        }

        @Override
        public void doBegin(String name, Attributes attributes) {
            final String groupName = attributes.getValue("name");
            
            if (this.filterContactList.equals(groupName)) {
                final Contact.Group group = new Contact.Group();
                group.setName(groupName);
                getDigester().push(group);
            }
        }

        @Override
        public void doEnd(String name) {
            if (getDigester().peek() instanceof Contact.Group) {                
                final Contact.Group group = (Contact.Group)getDigester().pop();
                final ContactListResponse r = (ContactListResponse)getDigester().peek();
                r.addGroup(group);
            }
        }        
    }
    
    private final String filterContactListName;
    
	protected ContactListParser(final String filterContactListName) {
		super(ContactListResponse.class);
		Validate.notNull(filterContactListName);        
		this.filterContactListName = filterContactListName;
		Validate.notNull(this.filterContactListName);        
	}

	@Override
	protected void onInit(Digester digester) {
		digester.addRule("eveapi/result/rowset", new AddGroupRule(this.filterContactListName));		
		digester.addRule("eveapi/result/rowset/row", new AddContactRule());     
	}	
}
