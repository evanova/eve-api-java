package com.tlabs.eve.esi;

import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import com.tlabs.eve.esi.model.ESICalendar;
import com.tlabs.eve.esi.model.ESICharacter;
import com.tlabs.eve.esi.model.ESICharacterStatus;
import com.tlabs.eve.esi.model.ESIFitting;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMail;
import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIShip;

import java.util.List;

/** Facade toward all ESI APIs.*/
public interface ESIService {

    ESIServerStatus getServerStatus();

    List<ESIName> getNames(final List<Long> ids);

    ESICharacterStatus getCharacterStatus();

    ESICharacter getCharacter();

    ESILocation getCharacterLocation();

    ESIShip getCharacterShip();

    ESICalendar getCalendar(final Long afterEventID);

    boolean postCalendarEvent(Long eventID, ESICalendar.Event.Response response);

    boolean deleteMail(final Long mailID);

    List<ESIMail> getMails(final Long afterMailID, final String... labels);

    List<ESIMailbox> getMailboxes();

    ESIMail getMailContent(final Long mailID);

    Integer postMail(final ESIMail mail);

    boolean updateMail(final ESIMail mail);

    boolean createMailbox(final ESIMailbox mailbox);

    List<ESIKillMail> getKillMails(Integer maxCount, Long maxKillID, boolean withContent);

    ESIKillMail getKillMail(final ESIKillMail killMail);

    List<ESIFitting> getFittings();

    Long postFitting(final ESIFitting fitting);

    boolean deleteFitting(final Long fittingID);
}
