package com.tlabs.eve.api.character;



import com.tlabs.eve.api.mail.MailBodiesRequest;
import com.tlabs.eve.api.mail.MailMessage;
import com.tlabs.eve.api.mail.MailMessagesRequest;
import com.tlabs.eve.api.mail.MailingList;
import com.tlabs.eve.api.mail.MailingListsRequest;
import com.tlabs.eve.api.mail.NotificationMessage;
import com.tlabs.eve.api.mail.NotificationTextRequest;
import com.tlabs.eve.api.mail.NotificationsRequest;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

public final class CharacterMailTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testMailNotifications() throws Exception {
        List<NotificationMessage> messages = apiCall(new NotificationsRequest(characterKey.id)).getMessages();
        if (messages.isEmpty()) {
            return;
        }

        final long[] ids = new long[messages.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = messages.get(i).getNotificationID();
        }
        final List<NotificationMessage> bodies = apiCall(new NotificationTextRequest(characterKey.id, ids)).getMessages();
        Assert.assertEquals("Bodies size is different from notification list size.", messages.size(), bodies.size());
    }

    @Test(timeout = 10000)
    public void testMailingLists() throws Exception {
        List<MailingList> r = apiCall(new MailingListsRequest(characterKey.id)).getMailingLists();
    }

    @Test(timeout = 10000)
    public void testMailMessages() throws Exception {
        final List<MailMessage> messages = apiCall(new MailMessagesRequest(characterKey.id)).getMessages();
        if (messages.isEmpty()) {
            return;
        }

        final long[] ids = new long[messages.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = messages.get(i).getMessageID();
        }
        final List<MailMessage> bodies = apiCall(new MailBodiesRequest(characterKey.id, ids)).getMessages();
        Assert.assertEquals("Bodies size is different from mail list size.", messages.size(), bodies.size());
    }
}
