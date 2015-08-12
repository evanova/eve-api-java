package com.tlabs.eve.api;

import java.io.Serializable;

public class Bookmark implements Serializable {

    public static class Folder implements Serializable {

        private static final long serialVersionUID = 655441595710123406L;

        private long folderID;
        private long creatorID;
        private String folderName;

        public long getFolderID() {
            return folderID;
        }

        public void setFolderID(long folderID) {
            this.folderID = folderID;
        }

        public long getCreatorID() {
            return creatorID;
        }

        public void setCreatorID(long creatorID) {
            this.creatorID = creatorID;
        }

        public String getFolderName() {
            return folderName;
        }

        public void setFolderName(String folderName) {
            this.folderName = folderName;
        }
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

    public long getBookmarkID() {
        return bookmarkID;
    }

    public void setBookmarkID(long bookmarkID) {
        this.bookmarkID = bookmarkID;
    }

    public long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(long creatorID) {
        this.creatorID = creatorID;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
