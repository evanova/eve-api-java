package com.tlabs.eve.api.character;

import java.util.LinkedList;
import java.util.List;

public class ChatChannel {

    public static final String STATUS_ALLOWED = "allowed";
    public static final String STATUS_MUTED = "muted";
    public static final String STATUS_OPERATOR= "operator";
    public static final String STATUS_BLOCKED = "blocked";

    public static class Accessor {
        private String status;

        private long accessorID;
        private String accessorName;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public long getAccessorID() {
            return accessorID;
        }

        public void setAccessorID(long accessorID) {
            this.accessorID = accessorID;
        }

        public String getAccessorName() {
            return accessorName;
        }

        public void setAccessorName(String accessorName) {
            this.accessorName = accessorName;
        }
    }

    private long channelID;
    private long ownerID;
    private String ownerName;
    private String displayName;

    private String comparisonKey;
    private boolean hasPassword;
    private String motd;

    private List<Accessor> accessors = new LinkedList<>();

    public long getChannelID() {
        return channelID;
    }

    public void setChannelID(long channelID) {
        this.channelID = channelID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getComparisonKey() {
        return comparisonKey;
    }

    public void setComparisonKey(String comparisonKey) {
        this.comparisonKey = comparisonKey;
    }

    public boolean isHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public List<Accessor> getAccessors() {
        return accessors;
    }

    public void setAccessors(List<Accessor> accessors) {
        this.accessors = accessors;
    }

    void addAccessor(final Accessor a) {
        this.accessors.add(a);
    }
}
