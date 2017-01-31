package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESIMail;
import org.devfleet.esi.model.CharacterscharacterIdmailRecipients;
import org.devfleet.esi.model.CharacterscharacterIdmailRecipients1;
import org.devfleet.esi.model.GetCharactersCharacterIdKillmailsRecent200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdMail200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdMailLabelsOkLabels;
import org.devfleet.esi.model.GetCharactersCharacterIdMailMailIdOk;
import org.devfleet.esi.model.GetCharactersCharacterIdMailMailIdOkRecipients;
import org.devfleet.esi.model.GetKillmailsKillmailIdKillmailHashOk;
import org.devfleet.esi.model.PostCharactersCharacterIdMailMail;
import org.devfleet.esi.model.PutCharactersCharacterIdMailMailIdContents;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

final class MailTransformer {

    private MailTransformer() {}

    public static ESIMail transform(GetCharactersCharacterIdMailMailIdOk object, final Long mailId) {
        ESIMail mail = new ESIMail();
        mail.setId(mailId);
        mail.setFrom(object.getFrom().longValue());
        mail.setRead(object.getRead());
        mail.setSubject(object.getSubject());
        mail.setTimestamp(object.getTimestamp().getMillis());

        for (GetCharactersCharacterIdMailMailIdOkRecipients r: object.getRecipients()) {
            mail.addRecipient(r.getRecipientId().longValue(), r.getRecipientType().toString());
        }
        return mail;
    }

    public static ESIMail transform(GetCharactersCharacterIdMail200Ok object) {
        ESIMail mail = new ESIMail();
        mail.setFrom(object.getFrom().longValue());
        mail.setId(object.getMailId());
        mail.setRead(object.getIsRead());
        mail.setSubject(object.getSubject());
        mail.setTimestamp(object.getTimestamp().getMillis());

        for (CharacterscharacterIdmailRecipients r: object.getRecipients()) {
            mail.addRecipient(r.getRecipientId().longValue(), r.getRecipientType().toString());
        }
        return mail;
    }

    public static PostCharactersCharacterIdMailMail transform(final ESIMail mail) {
        PostCharactersCharacterIdMailMail object = new PostCharactersCharacterIdMailMail();
        object.setSubject(mail.getSubject());
        object.setApprovedCost(mail.getCost());
        object.setBody(mail.getBody());

        List<CharacterscharacterIdmailRecipients1> recipients = new ArrayList<>();
        for (ESIMail.Recipient r: mail.getRecipients()) {
            final CharacterscharacterIdmailRecipients1 r1 = new CharacterscharacterIdmailRecipients1();
            r1.setRecipientId(r.getId().intValue());
            r1.setRecipientType(recipientType(r.getType()));
            recipients.add(r1);
        }
        object.setRecipients(recipients);
        return object;
    }

    public static PutCharactersCharacterIdMailMailIdContents transform2(final ESIMail mail) {
        PutCharactersCharacterIdMailMailIdContents contents = new PutCharactersCharacterIdMailMailIdContents();
        contents.setLabels(new ArrayList<>(mail.getLabels().keySet()));
        contents.setRead(mail.getRead());
        return contents;
    }

    public static ESIKillMail transform(GetKillmailsKillmailIdKillmailHashOk object) {
        ESIKillMail km = new ESIKillMail();
        km.setId(object.getKillmailId().longValue());//TODO
        return km;
    }

    public static ESIKillMail transform(GetCharactersCharacterIdKillmailsRecent200Ok object) {
        ESIKillMail km = new ESIKillMail();
        km.setHash(object.getKillmailHash());
        km.setId(object.getKillmailId().longValue());
        return km;
    }

    public static ESIMailbox transform(GetCharactersCharacterIdMailLabelsOkLabels object) {
        final ESIMailbox m = new ESIMailbox();
        m.setLabelId(object.getLabelId().longValue());
        //m.setColor(object.getColor().val);
        m.setLabel(object.getName());
        m.setUnread(object.getUnreadCount());
        return m;
    }

    private static CharacterscharacterIdmailRecipients1.RecipientTypeEnum recipientType(final String type) {
        for (CharacterscharacterIdmailRecipients1.RecipientTypeEnum e: EnumSet.allOf(CharacterscharacterIdmailRecipients1.RecipientTypeEnum.class)) {
            if (e.name().equalsIgnoreCase(type)) {
                return e;
            }
        }
        return null;
    }
}
