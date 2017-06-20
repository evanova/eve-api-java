package com.tlabs.eve.esi;

public final class ESIAccess {

    public static final String[] CHARACTER_SCOPES = {
            "esi-assets.read_assets.v1",
            "esi-bookmarks.read_character_bookmarks.v1",
            "esi-calendar.read_calendar_events.v1",
            "esi-calendar.respond_calendar_events.v1",
            "esi-characters.read_contacts.v1",
            "esi-characters.write_contacts.v1",
            "esi-clones.read_clones.v1",
            "esi-corporations.read_corporation_membership.v1",
            "esi-fleets.read_fleet.v1",
            "esi-fleets.write_fleet.v1",
            "esi-killmails.read_killmails.v1",
            "esi-location.read_location.v1",
            "esi-location.read_ship_type.v1",
            "esi-mail.organize_mail.v1",
            "esi-mail.read_mail.v1",
            "esi-mail.send_mail.v1",
            "esi-planets.manage_planets.v1",
            "esi-search.search_structures.v1",
            "esi-skills.read_skillqueue.v1",
            "esi-skills.read_skills.v1",
            "esi-ui.open_window.v1",
            "esi-ui.write_waypoint.v1",
            "esi-universe.read_structures.v1",
            "esi-wallet.read_character_wallet.v1"
    };

    private ESIAccess() {}

}
