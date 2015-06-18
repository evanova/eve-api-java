package com.tlabs.eve.api.mail;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ContactNotification extends NotificationMessage implements Serializable {

    public ContactNotification() {
        super();
        setTypeID(89);
    }

    public void setMessageData(final String data) {
        super.setBody(data);
    }
}
