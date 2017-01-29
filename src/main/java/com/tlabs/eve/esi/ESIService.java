package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICorporation;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIMailbox;

import java.util.List;

/** Facade toward all ESI APIs.*/
public interface ESIService {

    ESICharacter getCharacter(final Long charID);

    ESILocation getCharacterLocation(final Long charID);

    ESICalendar getCalendar(final Long charID, final Long afterEventID);

    boolean postCalendarEvent(Long charID, Long eventID, ESICalendar.Event.Response response);

    ESICorporation getCorporation(final Long corpID);

    List<ESICorporation.Member> getMembers(final Long corpID);

    // Corporation getCorporation(final long corpID);

    //BookmarkFolder getBookmarks();

    boolean deleteMail(final Long charID, final Long mailID);

    List<ESIMail> getMails(final Long charID, final Long afterMailID, final String... labels);

    List<ESIMailbox> getMailboxes(final Long charID);

    ESIMail getMailContent(final Long charID, final Long mailID);

    Integer postMail(final Long charID, final ESIMail mail);

    boolean updateMail(final Long charID, final ESIMail mail);

    boolean createMailbox(final Long charID, final ESIMailbox mailbox);

    List<ESIKillMail> getKillMails(Long charID, Integer maxCount, Long maxKillID, boolean withContent);

    ESIKillMail getKillMail(final ESIKillMail killMail);
}
