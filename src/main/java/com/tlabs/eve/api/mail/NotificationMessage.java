package com.tlabs.eve.api.mail;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class NotificationMessage extends Message {

    public static final Map<Integer, String> DESCRIPTIONS;

    static {
        DESCRIPTIONS = new HashMap<>();

        DESCRIPTIONS.put(1, "Legacy");
        DESCRIPTIONS.put(2, "Character deleted");
        DESCRIPTIONS.put(3, "Give medal to character");
        DESCRIPTIONS.put(4, "Alliance maintenance bill");
        DESCRIPTIONS.put(5, "Alliance war declared");
        DESCRIPTIONS.put(6, "Alliance war surrender");
        DESCRIPTIONS.put(7, "Alliance war retracted");
        DESCRIPTIONS.put(8, "Alliance war invalidated by Concord");
        DESCRIPTIONS.put(9, "Bill issued to a character");
        DESCRIPTIONS.put(10, "Bill issued to corporation or alliance");
        DESCRIPTIONS.put(11, "Bill not paid because there's not enough ISK available");
        DESCRIPTIONS.put(12, "Bill, issued by a character, paid");
        DESCRIPTIONS.put(13, "Bill, issued by a corporation or alliance, paid");
        DESCRIPTIONS.put(14, "Bounty claimed");
        DESCRIPTIONS.put(15, "Clone activated");
        DESCRIPTIONS.put(16, "New corp member application");
        DESCRIPTIONS.put(17, "Corp application rejected");
        DESCRIPTIONS.put(18, "Corp application accepted");
        DESCRIPTIONS.put(19, "Corp tax rate changed");
        DESCRIPTIONS.put(20, "Corp news report, typically for shareholders");
        DESCRIPTIONS.put(21, "Player leaves corp");
        DESCRIPTIONS.put(22, "Corp news, new CEO");
        DESCRIPTIONS.put(23, "Corp dividend/liquidation, sent to shareholders");
        DESCRIPTIONS.put(24, "Corp dividend payout, sent to shareholders");
        DESCRIPTIONS.put(25, "Corp vote created");
        DESCRIPTIONS.put(26, "Corp CEO votes revoked during voting");
        DESCRIPTIONS.put(27, "Corp declares war");
        DESCRIPTIONS.put(28, "Corp war has started");
        DESCRIPTIONS.put(29, "Corp surrenders war");
        DESCRIPTIONS.put(30, "Corp retracts war");
        DESCRIPTIONS.put(31, "Corp war invalidated by Concord");
        DESCRIPTIONS.put(32, "Container password retrieval");
        DESCRIPTIONS.put(33, "Contraband or low standings cause an attack or items being confiscated");
        DESCRIPTIONS.put(34, "First ship insurance");
        DESCRIPTIONS.put(35, "Ship destroyed, insurance payed");
        DESCRIPTIONS.put(36, "Insurance contract invalidated/runs out");
        DESCRIPTIONS.put(37, "Sovereignty claim fails (alliance)");
        DESCRIPTIONS.put(38, "Sovereignty claim fails (corporation)");
        DESCRIPTIONS.put(39, "Sovereignty bill late (alliance)");
        DESCRIPTIONS.put(40, "Sovereignty bill late (corporation)");
        DESCRIPTIONS.put(41, "Sovereignty claim lost (alliance)");
        DESCRIPTIONS.put(42, "Sovereignty claim lost (corporation)");
        DESCRIPTIONS.put(43, "Sovereignty claim acquired (alliance)");

        DESCRIPTIONS.put(45, "Alliance anchoring alert");
        DESCRIPTIONS.put(46, "Alliance structure turns vulnerable");
        DESCRIPTIONS.put(47, "Alliance structure turns invulnerable");
        DESCRIPTIONS.put(48, "Sovereignty disruptor anchored");
        DESCRIPTIONS.put(49, "Structure won/lost");
        DESCRIPTIONS.put(50, "Corp office lease expiration notice");
        DESCRIPTIONS.put(51, "Clone contract revoked by station manager");
        DESCRIPTIONS.put(52, "Corp member clones moved between stations");
        DESCRIPTIONS.put(53, "Clone contract revoked by station manager");
        DESCRIPTIONS.put(54, "Insurance contract expired");
        DESCRIPTIONS.put(55, "Insurance contract issued");
        DESCRIPTIONS.put(56, "Jump clone destroyed");
        DESCRIPTIONS.put(57, "Jump clone destroyed");
        DESCRIPTIONS.put(58, "Corporation joining factional warfare");
        DESCRIPTIONS.put(59, "Corporation leaving factional warfare");
        DESCRIPTIONS.put(60, "Corporation kicked from factional warfare on startup because of too low standing to the faction");
        DESCRIPTIONS.put(61, "Character kicked from factional warfare on startup because of too low standing to the faction");
        DESCRIPTIONS.put(62, "Corporation in factional warfare warned on startup because of too low standing to the faction");
        DESCRIPTIONS.put(63, "Character in factional warfare warned on startup because of too low standing to the faction");
        DESCRIPTIONS.put(64, "Character loses factional warfare rank");
        DESCRIPTIONS.put(65, "Character gains factional warfare rank");
        DESCRIPTIONS.put(66, "Agent has moved");
        DESCRIPTIONS.put(67, "Mass transaction reversal message");
        DESCRIPTIONS.put(68, "Reimbursement message");
        DESCRIPTIONS.put(69, "Agent locates a character");
        DESCRIPTIONS.put(70, "Research mission becomes available from an agent");
        DESCRIPTIONS.put(71, "Agent mission offer expires");
        DESCRIPTIONS.put(72, "Agent mission times out");
        DESCRIPTIONS.put(73, "Agent offers a storyline mission");
        DESCRIPTIONS.put(74, "Tutorial message sent on character creation");
        DESCRIPTIONS.put(75, "Tower alert");
        DESCRIPTIONS.put(76, "Tower resource alert");
        DESCRIPTIONS.put(77, "Station aggression message");
        DESCRIPTIONS.put(78, "Station state change message");
        DESCRIPTIONS.put(79, "Station conquered message");
        DESCRIPTIONS.put(80, "Station aggression message");
        DESCRIPTIONS.put(81, "Corporation requests joining factional warfare");
        DESCRIPTIONS.put(82, "Corporation requests leaving factional warfare");
        DESCRIPTIONS.put(83, "Corporation withdrawing a request to join factional warfare");
        DESCRIPTIONS.put(84, "Corporation withdrawing a request to leave factional warfare");
        DESCRIPTIONS.put(85, "Corporation liquidation");
        DESCRIPTIONS.put(86, "Territorial Claim Unit under attack");
        DESCRIPTIONS.put(87, "Sovereignty Blockade Unit under attack");
        DESCRIPTIONS.put(88, "Infrastructure Hub under attack");
        DESCRIPTIONS.put(89, "Contact add notification");
        DESCRIPTIONS.put(90, "Contact edit notification");
        DESCRIPTIONS.put(91, "Incursion Completed");
        DESCRIPTIONS.put(92, "Corp Kicked");
        DESCRIPTIONS.put(93, "Customs office has been attacked");
        DESCRIPTIONS.put(94, "Customs office has entered reinforced");
        DESCRIPTIONS.put(95, "Customs office has been transferred");
        DESCRIPTIONS.put(96, "FW Alliance Warning");
        DESCRIPTIONS.put(97, "FW Alliance Kick");
        DESCRIPTIONS.put(98, "AllWarCorpJoined Msg");
        DESCRIPTIONS.put(99, "Ally Joined Defender");
        DESCRIPTIONS.put(100, "Ally Has Joined a War Aggressor");
        DESCRIPTIONS.put(101, "Ally Joined War Ally");
        DESCRIPTIONS.put(102, "New war system: entity is offering assistance in a war.");
        DESCRIPTIONS.put(103, "War Surrender Offer");
        DESCRIPTIONS.put(104, "War Surrender Declined");
        DESCRIPTIONS.put(105, "FacWar LP Payout Kill");
        DESCRIPTIONS.put(106, "FacWar LP Payout Event");
        DESCRIPTIONS.put(107, "FacWar LP Disqualified Eventd");
        DESCRIPTIONS.put(108, "FacWar LP Disqualified Kill");
        DESCRIPTIONS.put(109, "Alliance Contract Cancelled");
        DESCRIPTIONS.put(110, "War Ally Declined Offer");
        DESCRIPTIONS.put(111, "Your Bounty Was Claimed");
        DESCRIPTIONS.put(112, "Bounty placed (Char)");
        DESCRIPTIONS.put(113, "Bounty Placed (Corp)");
        DESCRIPTIONS.put(114, "Bounty Placed (Alliance)");
        DESCRIPTIONS.put(115, "Kill Right Available");
        DESCRIPTIONS.put(116, "Kill right Available Open");
        DESCRIPTIONS.put(117, "Kill Right Earned");
        DESCRIPTIONS.put(118, "Kill right Used");
        DESCRIPTIONS.put(119, "Kill Right Unavailable");
        DESCRIPTIONS.put(120, "Kill Right Unavailable Open");
        DESCRIPTIONS.put(121, "Declare War");
        DESCRIPTIONS.put(122, "Offered Surrender");
        DESCRIPTIONS.put(123, "Accepted Surrender");
        DESCRIPTIONS.put(124, "Made War Mutual");
        DESCRIPTIONS.put(125, "Retracts War");
        DESCRIPTIONS.put(126, "Offered To Ally");
        DESCRIPTIONS.put(127, "Accepted Ally");
        DESCRIPTIONS.put(128, "Character Application Accept");
        DESCRIPTIONS.put(129, "Character Application Reject");
        DESCRIPTIONS.put(130, "Character Application Withdraw");
        DESCRIPTIONS.put(138, "Clone activated");
        DESCRIPTIONS.put(140, "Loss report available");
        DESCRIPTIONS.put(141, "Kill report available");
        DESCRIPTIONS.put(147, "Entosis Link started");
        DESCRIPTIONS.put(148, "Entosis Link enabled a module");
        DESCRIPTIONS.put(149, "Entosis Link disabled a module");
        DESCRIPTIONS.put(160, "Reinforced mode entered");
    }

    private static final long serialVersionUID = 2130540734211587597L;

    private int typeID = -1;

    private final Map<String, String> bodyAttributes = new HashMap<>();

    public final long getNotificationID() {
        return getMessageID();
    }

    public final void setNotificationID(long notificationID) {
        super.setMessageID(notificationID);
    }

    public final int getTypeID() {
        return typeID;
    }

    public final void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public final Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.bodyAttributes);
    }

    public final String getAttribute(final String attr) {
        return this.bodyAttributes.get(attr);
    }

    @Override
    public String getTitle() {
        final String s = DESCRIPTIONS.get(getTypeID());
        return (null == s) ? super.getTitle() : s;
    }

    public void setAttribute(final String attr, final String value) {
        this.bodyAttributes.put(attr, value);
    }

    public void setAttributes(final Map<String, String> attributes) {
        this.bodyAttributes.clear();
        this.bodyAttributes.putAll(attributes);
    }

    public void setAttributes(final String body) {
        this.bodyAttributes.clear();
        if (StringUtils.isBlank(body)) {
            return;
        }
        final String[] lines = StringUtils.split(body, "\n");
        for (int i = 0; i < lines.length; i++) {
            String[] line = StringUtils.split(lines[i].trim(), ":");
            if (line.length == 2) {
                this.bodyAttributes.put(line[0].trim(), line[1].trim());
            }
        }
    }
}
