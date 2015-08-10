package com.tlabs.eve.api.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChatChannel {

    private static final String STATUS_ALLOWED = "allowed";
    private static final String STATUS_MUTED = "muted";
    private static final String STATUS_OPERATOR= "operator";
    private static final String STATUS_BLOCKED = "blocked";
    @Getter
    @Setter
    public static class Accessor {
        private String status;

        private long accessorID;
        private String accessorName;
    }

    private long channelID;
    private long ownerID;
    private String ownerName;
    private String displayName;

    private String comparisonKey;
    private boolean hasPassword;
    private String motd;
    /*<rowset name="channels" key="channelID" columns="ownerID,ownerName,displayName,comparisonKey,hasPassword,motd">*/
}
