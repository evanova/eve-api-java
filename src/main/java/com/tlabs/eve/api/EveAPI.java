package com.tlabs.eve.api;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public final class EveAPI {

    public static final int CHAR_FULL = /*65461771*/266854027;
    public static final int CHAR_MIN = /*65461771*/25165832;

    public static final int CORP_FULL = /*65461775*/29356539;
    public static final int CORP_MIN = /*65461775*/8;

    public static final AccessGroup[] characterGroups = new AccessGroup[] {
            AccessGroup.Group1,
            AccessGroup.Group7,
            AccessGroup.Group3,
            AccessGroup.Group4,
            AccessGroup.Group2 };

    public static final AccessGroup[] corporationGroups = new AccessGroup[] {
            AccessGroup.Group1,
            AccessGroup.Group7,
            AccessGroup.Group5,
            AccessGroup.Group6,
            AccessGroup.Group3,
            AccessGroup.Group4,
            AccessGroup.Group2 };

    public static enum AccessGroup {
        Group1(1, "Account and Market", "Market Orders, account balance and journal history."),
        Group7(7, "Communications", "Private communications such as contact lists, Eve Mail and Notifications."),
        Group5(5, "Corporation Members", "Member information for Corporations."),
        Group6(6, "Outposts and Starbases", "Outpost and Starbase information for Corporations"),
        Group3(3, "Private Information", "Personal information about the owner. Asset lists, skill training for characters, Private Calendar and more."),
        Group4(4, "Public Information", "Achievements such as Medals, Kill Mails, Fational Warfare Statistics and NPC Standings."),
        Group2(2, "Science and Industry", "Datacore production and job listing.");

        private String description;
        private String name;
        private int groupId;

        private AccessGroup(int id, String name, String description) {
            this.groupId = id;
            this.name = name;
            this.description = description;
        }

        public final int getID() {
            return this.groupId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    public static enum CharacterAccess {
        Contracts(67108864, 3, "Contracts", "List of all Contracts the character is involved in."),
        AccountStatus(33554432, 3, "AccountStatus", "EVE player account status."),
        CharacterInfoMore(16777216, 4, "CharacterInfo", "Sensitive Character Information, exposes account balance and last known location on top of the other Character Information call."),
        CharacterInfo(8388608, 3, "CharacterInfo", "Character information, exposes skill points and current ship information on top of'Show Info'information."),
        Location(134217728, 3, "ItemLocation", "Character location"),
        WalletTransactions(4194304, 1, "WalletTransactions", "Market transaction journal of character."),
        WalletJournal(2097152, 1, "WalletJournal", "Wallet journal of character."),
        UpcomingCalendarEvents(1048576, 3, "UpcomingCalendarEvents", "Upcoming events on characters calendar."),
        Standings(524288, 4, "Standings", "NPC Standings towards the character."),
        SkillQueue(262144, 3, "SkillQueue", "Entire skill queue of character."),
        SkillInTraining(131072, 3, "SkillInTraining", "Skill currently in training on the character. Subset of entire Skill Queue."),
        Research(65536, 2, "Research", "List of all Research agents working for the character and the progress of the research."),
        NotificationTexts(32768, 7, "NotificationTexts", "Actual body of notifications sent to the character. Requires Notification access to function."),
        Notifications(16384, 7, "Notifications", "List of recent notifications sent to the character."),
        Medals(8192, 4, "Medals", "Medals awarded to the character."),
        MarketOrders(4096, 1, "MarketOrders", "List of all Market Orders the character has made."),
        MailMessages(2048, 7, "MailMessages", "List of all messages in the characters EVE Mail Inbox."),
        MailingLists(1024, 7, "MailingLists", "List of all Mailing Lists the character subscribes to."),
        MailBodies(512, 7, "MailBodies", "EVE Mail bodies. Requires MailMessages as well to function."),
        KillLog(256, 4, "KillLog", "Characters kill log."),
        IndustryJobs(128, 2, "IndustryJobs", "Character jobs, completed and active."),
        FacWarStats(64, 4, "FacWarStats", "Characters Factional Warfare Statistics."),
        ContactNotifications(32, 7, "ContactNotifications", "Most recent contact notifications for the character."),
        ContactList(16, 7, "ContactList", "List of character contacts and relationship levels."),
        CharacterSheet(8, 3, "CharacterSheet", "Character Sheet information. Contains basic'Show Info'information along with clones, account balance, implants, attributes, skills, certificates and corporation roles."),
        CalendarEventAttendees(4, 3, "CalendarEventAttendees", "Event attendee responses. Requires UpcomingCalendarEvents to function."),
        AssetList(2, 3, "AssetList", "Entire asset list of character."),
        AccountBalance(1, 1, "AccountBalance", "Current balance of characters wallet."),
        Bookmarks(268435456, 3, "Bookmarks", "Character Bookmarks.");

        private String description;
        private String name;
        private int groupId;
        private int accessMask;

        private CharacterAccess(int accessMask, int id, String name, String description) {
            this.accessMask = accessMask;
            this.groupId = id;
            this.name = name;
            this.description = description;
        }

        public final int getGroupID() {
            return this.groupId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getAccessMask() {
            return this.accessMask;
        }

        public final boolean hasAccess(int other) {
            return (other & this.accessMask) == this.accessMask;
        }
    }

    public static enum Wallet {
        MASTER(1000l), SECOND(1001l), THIRD(1002l), FOURTH(1003l), FIFTH(1004l), SIXTH(1005l), SEVENTH(1006l), DUST(10001l);

        private final long walletID;

        private Wallet(final long walletID) {
            this.walletID = walletID;
        }

        public final long getID() {
            return this.walletID;
        }
    }

    public static enum CorporationAccess {

        Contracts(8388608, 3, "Contracts", "List of recent Contracts the corporation is involved in."),
        Titles(4194304, 5, "Titles", "Titles of corporation and the roles they grant."),
        WalletTransactions(2097152, 1, "WalletTransactions", "Market transactions of all corporate accounts."),
        WalletJournal(1048576, 1, "WalletJournal", "Wallet journal for all corporate accounts."),
        StarbaseList(524288, 6, "StarbaseList", "List of all corporate starbases."),
        Standings(262144, 4, "Standings", "NPC Standings towards corporation."),
        StarbaseDetail(131072, 6, "StarbaseDetail", "List of all settings of corporate starbases."),
        Shareholders(65536, 1, "Shareholders", "Shareholders of the corporation."),
        OutpostServiceDetail(32768, 6, "OutpostServiceDetail", "List of all service settings of corporate outposts."),
        OutpostList(16384, 6, "OutpostList", "List of all outposts controlled by the corporation."),
        Medals(8192, 4, "Medals", "List of all medals created by the corporation."),
        MarketOrders(4096, 1, "MarketOrders", "List of all corporate market orders."),
        MemberTrackingLimited(2048, 5, "MemberTrackingLimited", "Lmited Member information."),
        MemberTrackingExtended(33554432, 5, "MemberTrackingExtended", "Extensive Member information."),
        MemberSecurityLog(1024, 5, "MemberSecurityLog", "Member role and title change log."),
        MemberSecurity(512, 5, "MemberSecurity", "Member roles and titles."),
        KillLog(256, 4, "KillLog", "Corporation kill log."),
        IndustryJobs(128, 2, "IndustryJobs", "Corporation jobs, completed and active."),
        FacWarStats(64, 4, "FacWarStats", "Corporations Factional Warfare Statistics."),
        ContainerLog(32, 3, "ContainerLog", "Corporate secure container acess log."),
        ContactList(16, 7, "ContactList", "Corporate contact list and relationships."),
        CorporationSheet(8, 3, "CorporationSheet", "Exposes basic'Show Info'information as well as Member Limit and basic division and wallet info."),
        MemberMedals(4, 5, "MemberMedals", "List of medals awarded to corporation members."),
        AssetList(2, 3, "AssetList", "List of all corporation assets."),
        AccountBalance(1, 1, "AccountBalance", "Current balance of all corporation accounts."),
        Bookmarks(67108864, 3, "Bookmarks", "Corporation Bookmarks.");

        private String description;
        private String name;
        private int groupId;
        private int accessMask;

        private CorporationAccess(int accessMask, int id, String name, String description) {
            this.accessMask = accessMask;
            this.groupId = id;
            this.name = name;
            this.description = description;
        }

        public final int getGroupID() {
            return this.groupId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getAccessMask() {
            return this.accessMask;
        }

        public final boolean hasAccess(int other) {
            return (other & this.accessMask) == other;
        }
    }

    private static final int[] SKILL_LEVELS = new int[] { 0, 250, 1414, 8000, 45255, 256000 };

    public static final String ATTR_INTELLIGENCE = "intelligence";
    public static final String ATTR_CHARISMA = "charisma";
    public static final String ATTR_WILLPOWER = "willpower";
    public static final String ATTR_MEMORY = "memory";
    public static final String ATTR_PERCEPTION = "perception";

    private EveAPI() {
    }

    public static long parseDateTime(String dateTime) {
        if (StringUtils.isBlank(dateTime)) {
            return 0l;
        }
        try {
            final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2010-05-23 16:43:51			
            return dateFormat.parse(dateTime).getTime();
        }
        catch (ParseException e) {
            System.err.println("EveAPI.parseDateTime(" + dateTime + "): " + e.getLocalizedMessage());
            return 0l;
        }
    }

    public static Calendar getEveCalendar() {
        return GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
    }

    public static long getEveTime() {
        return getEveCalendar().getTimeInMillis();
    }

    public static <T extends EveAPIResponse> T parse(EveAPIRequest<T> request, InputStream in) throws IOException {
        EveAPIParser<T> p = EveAPIHelper.getParser(request);
        return p.parse(in);
    }

    public static long getRequiredSkillPoints(final int rank, final int level) {
        Validate.isTrue((level >= 0) && (level < SKILL_LEVELS.length), "invalid level '" + level + "'.");
        return rank * SKILL_LEVELS[level];
    }

    public static boolean checkAccess(boolean anyAccess, int keyMask, CharacterAccess... againstAccess) {
        return checkAccess(anyAccess, Collections.singletonList(keyMask), againstAccess);
    }

    public static boolean checkAccess(boolean anyAccess, int keyMask, CorporationAccess... againstAccess) {
        return checkAccess(anyAccess, Collections.singletonList(keyMask), againstAccess);
    }

    public static boolean checkAccess(boolean anyAccess, List<Integer> keyMasks, CharacterAccess... againstAccess) {

        if ((null == againstAccess) || (againstAccess.length == 0)) {
            return true;
        }
        if ((null == keyMasks) || (keyMasks.isEmpty())) {
            return false;
        }
        for (CharacterAccess a : againstAccess) {
            boolean hasAccess = false;

            for (int m : keyMasks) {
                if (a.hasAccess(m)) {
                    hasAccess = true;
                    break;
                }
            }
            if (hasAccess) {
                if (anyAccess) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static boolean checkAccess(boolean anyAccess, List<Integer> keyMasks, CorporationAccess... againstAccess) {

        if ((null == againstAccess) || (againstAccess.length == 0)) {
            return true;
        }
        if ((null == keyMasks) || (keyMasks.isEmpty())) {
            return false;
        }
        for (CorporationAccess a : againstAccess) {
            boolean hasAccess = false;

            for (int m : keyMasks) {
                if (a.hasAccess(m)) {
                    hasAccess = true;
                    break;
                }
            }
            if (hasAccess) {
                if (anyAccess) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

}
