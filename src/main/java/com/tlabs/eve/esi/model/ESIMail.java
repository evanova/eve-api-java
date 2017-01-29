package com.tlabs.eve.esi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ESIMail {

    public static class Recipient {

        private Long id;
        private String type;

        public Long getId() {
            return id;
        }

        public Recipient setId(Long id) {
            this.id = id;
            return this;
        }

        public String getType() {
            return type;
        }

        public Recipient setType(String type) {
            this.type = type;
            return this;
        }
    }

    private Long id;
    private Long from;
    private Long cost;

    private String body;
    private String subject;
    private long timestamp;

    private boolean read;

    private final Map<Long, String> labels = new HashMap<>();
    private final List<Recipient> recipients = new ArrayList<>();

    public Map<Long, String> getLabels() {
        return labels;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public ESIMail addLabel(final Long id, String label) {
        this.labels.put(id, label);
        return this;
    }

    public ESIMail addRecipient(final Long id, final String type) {
        this.recipients.add(new Recipient().setId(id).setType(type));
        return this;
    }

    public ESIMail addRecipient(final ESIMail.Recipient recipient) {
        this.recipients.add(recipient);
        return this;
    }

    public Long getId() {
        return id;
    }

    public ESIMail setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getFrom() {
        return from;
    }

    public ESIMail setFrom(Long from) {
        this.from = from;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ESIMail setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ESIMail setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public boolean getRead() {
        return read;
    }

    public ESIMail setRead(boolean read) {
        this.read = read;
        return this;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isRead() {
        return read;
    }
}
