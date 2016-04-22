package com.tlabs.eve.api.mail;



import com.tlabs.eve.api.EveAPI;



import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public class Message implements Serializable {

    private static final long serialVersionUID = 4815557437352503649L;

    private long messageID;

    private long senderID = -1;
    private String senderName = "";

    private long sentDate = 0;
    private boolean read;

    private String body = null;//supposedly a CDATA block 
    private String title = "";

    protected Message() {

    }

    public final long getMessageID() {
        return messageID;
    }

    public final void setMessageID(long messageID) {
        this.messageID = messageID;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public final long getSenderID() {
        return senderID;
    }

    public final String getSenderName() {
        return senderName;
    }

    public final void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public final void setSenderID(long senderID) {
        this.senderID = senderID;
    }

    public final String getBody() {
        return body;
    }

    public void setBody(String body) {
        if (StringUtils.isBlank(body)) {
            this.body = "";
        }
        else {
            String b = StringUtils.removeEnd(StringUtils.removeStart(body.trim(), "<![CDATA[").trim(), "]]>").trim();
            b = StringUtils.remove(b, "{}");
            this.body = b;
        }

    }

    public final void setSentDate(long sentDate) {
        this.sentDate = sentDate;
    }

    public final long getSentDate() {
        return sentDate;
    }

    public final void setSentDate(String d) {
        sentDate = EveAPI.parseDateTime(d);
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
