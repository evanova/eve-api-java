package com.tlabs.eve.ccp;



import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;

public class EveRSSEntry implements Serializable {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private static final long serialVersionUID = -8047807156394679404L;

    private String id;
    private String title;
    private String author;
    private String link;

    private long dateUpdated;
    private long datePublished;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            this.dateUpdated = format.parse(dateUpdated).getTime();
        }
        catch (ParseException e) {
            this.dateUpdated = System.currentTimeMillis();
        }
    }

    public long getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(long datePublished) {
        this.datePublished = datePublished;
    }

    public void setDatePublished(String datePublished) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            this.datePublished = format.parse(datePublished).getTime();
        }
        catch (ParseException e) {
            this.datePublished = System.currentTimeMillis();
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
