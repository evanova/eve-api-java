package com.tlabs.eve.ccp;



import com.tlabs.eve.EveResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public final class EveRSSResponse extends EveResponse {

    private List<EveRSSEntry> rssEntries = new ArrayList<>();
    private String title;
    private String link;

    private long dateUpdated;

    public EveRSSResponse() {
        super();
    }

    public final List<EveRSSEntry> getEntries() {
        return this.rssEntries;
    }

    public final void addEntry(final EveRSSEntry entry) {
        //limit it
        if (this.rssEntries.size() < 50) {
            this.rssEntries.add(entry);
        }
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            this.dateUpdated = format.parse(dateUpdated).getTime();
        }
        catch (ParseException e) {
            this.dateUpdated = System.currentTimeMillis();
        }
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
