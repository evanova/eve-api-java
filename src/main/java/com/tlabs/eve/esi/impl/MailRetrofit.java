package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIMailbox;
import com.tlabs.eve.esi.model.ESIKillMail;
import com.tlabs.eve.esi.model.ESIMail;
import org.apache.commons.lang3.ArrayUtils;

import org.devfleet.esi.api.KillmailsApi;
import org.devfleet.esi.api.MailApi;
import org.devfleet.esi.model.GetCharactersCharacterIdKillmailsRecent200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdMail200Ok;
import org.devfleet.esi.model.GetCharactersCharacterIdMailLabelsOk;
import org.devfleet.esi.model.GetCharactersCharacterIdMailLabelsOkLabels;
import org.devfleet.esi.model.GetCharactersCharacterIdMailMailIdOk;
import org.devfleet.esi.model.GetKillmailsKillmailIdKillmailHashOk;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class MailRetrofit {

    private final MailApi mailApi;
    private final KillmailsApi killMailApi;
    private final String datasource;

    public MailRetrofit(final Retrofit rf, final String datasource) {

        this.mailApi = rf.create(MailApi.class);
        this.killMailApi = rf.create(KillmailsApi.class);
        this.datasource = datasource;
    }

    public boolean deleteMail(Long charID, Long mailID) throws IOException {
        return this.mailApi
            .deleteCharactersCharacterIdMailMailId(
                charID.intValue(),
                mailID.intValue(),
                this.datasource,
                null, null, null)
            .execute()
            .isSuccessful();
    }

    public List<ESIMail> getMails(Long charID, Long afterMailID, String... labels) throws IOException {
        org.devfleet.esi.client.CollectionFormats.CSVParams params = null;
        if (ArrayUtils.isNotEmpty(labels)) {
            params = new org.devfleet.esi.client.CollectionFormats.CSVParams();
            params.setParams(Arrays.asList(labels));
        }

        final Response<List<GetCharactersCharacterIdMail200Ok>> r =
                this.mailApi.getCharactersCharacterIdMail(
                        charID.intValue(),
                        this.datasource,
                        params,
                        (null == afterMailID) ? null : afterMailID.intValue(),
                        null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIMail> mails = new ArrayList<>();
        for (GetCharactersCharacterIdMail200Ok object: r.body()) {
            mails.add(MailTransformer.transform(object));
        }
        return mails;
    }

    public List<ESIMailbox> getMailboxes(Long charID) throws IOException {
        final Response<GetCharactersCharacterIdMailLabelsOk> r =
                mailApi.getCharactersCharacterIdMailLabels(
                        charID.intValue(),
                        this.datasource,
                        null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIMailbox> mailboxes = new ArrayList<>();
        /*for (GetCharactersCharacterIdMailLists200OkObject object:
                this.mailApi
                .getCharactersCharacterIdMailLists(charID.intValue(), this.datasource)
                .execute()
                .body()) {
            mailboxes.add(ESITransformer.transform(object));*/
            for (GetCharactersCharacterIdMailLabelsOkLabels object: r.body().getLabels()) {
            mailboxes.add(MailTransformer.transform(object));
        }
        return mailboxes;
    }

    public ESIMail getMailContent(Long charID, Long mailID) throws IOException {
        final Response<GetCharactersCharacterIdMailMailIdOk> r =
                mailApi.getCharactersCharacterIdMailMailId(
                        charID.intValue(),
                        mailID.intValue(),
                        this.datasource,
                        null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return MailTransformer.transform(r.body(), mailID);
    }

    public Integer postMail(Long charID, ESIMail mail) throws IOException {
        final Response<Integer> r =
                mailApi.postCharactersCharacterIdMail(
                        charID.intValue(),
                        MailTransformer.transform(mail),
                        this.datasource,
                        null, null, null)
                        .execute();
        if (!r.isSuccessful()) {
            return null;
        }
        return r.body();
    }

    public boolean updateMail(Long charID, ESIMail mail) throws IOException {
        return mailApi.putCharactersCharacterIdMailMailId(
                charID.intValue(),
                MailTransformer.transform2(mail),
                mail.getId().intValue(),
                this.datasource,
                null, null, null)
                .execute()
                .isSuccessful();
    }

    public boolean createMailbox(Long charID, ESIMailbox mailbox) throws IOException {
        //TODO
        return false;
    }

    public boolean updateMailbox(Long charID, ESIMailbox mailbox) throws IOException {
        //TODO
        return false;
    }

    public List<ESIKillMail> getKillMails(Long charID, Integer maxCount, Long maxKillID, boolean withContent) throws IOException {
        final Response<List<GetCharactersCharacterIdKillmailsRecent200Ok>> r =
                killMailApi
                    .getCharactersCharacterIdKillmailsRecent(
                            charID.intValue(),
                            this.datasource,
                            maxCount,
                            maxKillID.intValue(),
                            null, null, null)
                    .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        final List<ESIKillMail> kills = new ArrayList<>();
        for (GetCharactersCharacterIdKillmailsRecent200Ok m: r.body()) {
            ESIKillMail km = MailTransformer.transform(m);
            if (withContent) {
                km = getKillMail(km);
            }
            kills.add(km);
        }
        return kills;
    }

    public ESIKillMail getKillMail(ESIKillMail killMail) throws IOException {
        final Response<GetKillmailsKillmailIdKillmailHashOk> r =
                killMailApi
                .getKillmailsKillmailIdKillmailHash(
                        killMail.getHash(),
                        killMail.getId().intValue(),
                        this.datasource,
                        null, null)
                .execute();
        if (!r.isSuccessful()) {
            return null;
        }

        //TODO - fill mail
        return MailTransformer.transform(r.body());
    }
}
