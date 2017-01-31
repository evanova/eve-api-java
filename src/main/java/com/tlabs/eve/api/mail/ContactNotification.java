package com.tlabs.eve.api.mail;


import java.io.Serializable;

public class ContactNotification extends NotificationMessage implements Serializable {

    private static final long serialVersionUID = -4902729964314275154L;

    public ContactNotification() {
        super();
        setTypeID(89);
    }

    public void setMessageData(final String data) {
        super.setBody(data);
    }
}
