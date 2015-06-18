package com.tlabs.eve.api.corporation;



import java.io.Serializable;

public class CorporationTitle implements Serializable {

    private static final long serialVersionUID = 7938073517252806699L;

    private long titleID;
    private String title;

    public long getTitleID() {
        return titleID;
    }

    public void setTitleID(long titleID) {
        this.titleID = titleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
