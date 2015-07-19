package com.tlabs.eve.api;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bookmark implements Serializable {

    @Getter
    @Setter
    public static class Folder implements Serializable {

        private static final long serialVersionUID = 655441595710123406L;

        private long folderID;
        private long creatorID;
        private String folderName;

    }

    private static final long serialVersionUID = -7356530791925732642L;

    /*<row bookmarkID="12" creatorID="90000001" created="2015-07-08 21:34:14" itemID="60014689" typeID="57" locationID="30004971" x="0" y="0" z="0"
     memo="Home Station" note="Our base of residence" />*/

    private long bookmarkID;
    private long creatorID;
    private long created;
    private long itemID;
    private long typeID;
    private long locationID;

    private double x;
    private double y;
    private double z;

    private String memo;
    private String note;


    public void setCreated(final String created) {
        this.created = EveAPI.parseDateTime(created);
    }
}
