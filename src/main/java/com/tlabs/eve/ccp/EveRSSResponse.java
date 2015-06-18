package com.tlabs.eve.ccp;



import com.tlabs.eve.EveResponse;

import java.util.LinkedList;
import java.util.List;

public final class EveRSSResponse extends EveResponse {

    private List<EveRSSEntry> rssEntries = new LinkedList<>();
    private String title;
    private String link;

    private long dateUpdated;

    public EveRSSResponse() {
        super();
        //setCachedUntil(System.currentTimeMillis() + (3600l * 1000l));
    }

    public final List<EveRSSEntry> getEntries() {
        return this.rssEntries;
    }

    public final void addEntry(final EveRSSEntry entry) {
        this.rssEntries.add(entry);
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
