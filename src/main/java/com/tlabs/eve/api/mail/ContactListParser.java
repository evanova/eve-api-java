package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPIParser;
import com.tlabs.eve.api.mail.Contact.Group;
import com.tlabs.eve.parser.BaseRule;
import com.tlabs.eve.parser.SetAttributePropertyRule;


import org.apache.commons.digester3.Digester;
import org.xml.sax.Attributes;

public class ContactListParser extends EveAPIParser<ContactListResponse> {
    private static final class AddContactRule extends SetAttributePropertyRule {

        @Override
        public void doBegin(String name, Attributes attributes) {
            if (getDigester().peek() instanceof Group) {
                getDigester().push(new Contact());
                super.doBegin(name, attributes);
            }
        }

        @Override
        public void doEnd(String name) {
            if (getDigester().peek() instanceof Contact) {
                final Contact contact = getDigester().pop();
                final Group group = getDigester().peek();
                group.addContact(contact);
            }
        }

    }

    private final class AddGroupRule extends BaseRule {


        @Override
        public void doBegin(String name, Attributes attributes) {
            final String groupName = attributes.getValue("name");

            if (filterContactListName.equals(groupName)) {
                final Group group = new Group();
                group.setName(groupName);
                getDigester().push(group);
            }
        }

        @Override
        public void doEnd(String name) {
            if (getDigester().peek() instanceof Group) {
                final Group group = getDigester().pop();
                final ContactListResponse r = getDigester().peek();
                r.addGroup(group);
            }
        }
    }

    private final String filterContactListName;

    protected ContactListParser(final String filterContactListName) {
        super(ContactListResponse.class);
        this.filterContactListName = filterContactListName;
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addRule("eveapi/result/rowset", new AddGroupRule());
        digester.addRule("eveapi/result/rowset/row", new AddContactRule());
    }
}
