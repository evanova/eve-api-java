package com.tlabs.eve.api.mail;


import java.util.ArrayList;
import java.util.List;

/**@since Eve API V3*/
public class ContactNotificationsResponse extends NotificationsResponse {

    private static final long serialVersionUID = -487904977987920997L;

    private List<ContactNotification> notifications = new ArrayList<>();

    public List<ContactNotification> getNotifications() {
        return notifications;
    }

    public void addNotification(final ContactNotification notification) {
        this.notifications.add(notification);
    }
}
