package com.tlabs.eve.api.character;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2012 Traquenard Labs
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
        if (messages.size() == 0) {
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
        if (messages.size() == 0) {
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
