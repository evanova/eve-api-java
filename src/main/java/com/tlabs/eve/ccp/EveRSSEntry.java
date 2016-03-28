package com.tlabs.eve.ccp;


import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EveRSSEntry implements Serializable {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";
    private static final long serialVersionUID = -8047807156394679404L;

    private String id;
    private String title;
    private String author;
    private String link;

    private long updated;

    private String htmlContent;

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
        return updated;
    }

    public void setDateUpdated(long dateUpdated) {
        this.updated = dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        try {
            final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            this.updated = format.parse(dateUpdated).getTime();
        }
        catch (ParseException e) {
            this.updated = System.currentTimeMillis();
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

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = StringUtils.removeEnd(StringUtils.removeStart(htmlContent.trim(), "<![CDATA[").trim(), "]]>").trim();
    }

}
