package com.tlabs.eve.api;

import com.tlabs.eve.EveParser;
import com.tlabs.eve.api.character.CharacterAccountBalanceRequest;
import com.tlabs.eve.api.character.CharacterAssetsRequest;
import com.tlabs.eve.api.character.CharacterBookmarksRequest;
import com.tlabs.eve.api.character.CharacterCalendarAttendeesParser;
import com.tlabs.eve.api.character.CharacterCalendarAttendeesRequest;
import com.tlabs.eve.api.character.CharacterCalendarParser;
import com.tlabs.eve.api.character.CharacterCalendarRequest;
import com.tlabs.eve.api.character.CharacterContactListParser;
import com.tlabs.eve.api.character.CharacterContactListRequest;
import com.tlabs.eve.api.character.CharacterContactNotificationsRequest;
import com.tlabs.eve.api.character.CharacterContractBidsRequest;
import com.tlabs.eve.api.character.CharacterContractItemsRequest;
import com.tlabs.eve.api.character.CharacterContractsRequest;
import com.tlabs.eve.api.character.CharacterIndustryJobsRequest;
import com.tlabs.eve.api.character.CharacterInfoParser;
import com.tlabs.eve.api.character.CharacterInfoRequest;
import com.tlabs.eve.api.character.CharacterItemLocationRequest;
import com.tlabs.eve.api.character.CharacterKillLogRequest;
import com.tlabs.eve.api.character.CharacterMarketOrderRequest;
import com.tlabs.eve.api.character.CharacterResearchParser;
import com.tlabs.eve.api.character.CharacterResearchRequest;
import com.tlabs.eve.api.character.CharacterSheetParser;
import com.tlabs.eve.api.character.CharacterSheetRequest;
import com.tlabs.eve.api.character.CharacterStandingsRequest;
import com.tlabs.eve.api.character.CharacterTrainingParser;
import com.tlabs.eve.api.character.CharacterTrainingQueueParser;
import com.tlabs.eve.api.character.CharacterTrainingQueueRequest;
import com.tlabs.eve.api.character.CharacterTrainingRequest;
import com.tlabs.eve.api.character.CharacterWalletJournalRequest;
import com.tlabs.eve.api.character.CharacterWalletTransactionsRequest;
import com.tlabs.eve.api.character.ChatChannelParser;
import com.tlabs.eve.api.character.ChatChannelRequest;
import com.tlabs.eve.api.character.PlanetaryColoniesParser;
import com.tlabs.eve.api.character.PlanetaryColoniesRequest;
import com.tlabs.eve.api.character.PlanetaryLinksParser;
import com.tlabs.eve.api.character.PlanetaryLinksRequest;
import com.tlabs.eve.api.character.PlanetaryPinsParser;
import com.tlabs.eve.api.character.PlanetaryPinsRequest;
import com.tlabs.eve.api.character.PlanetaryRoutesParser;
import com.tlabs.eve.api.character.PlanetaryRoutesRequest;
import com.tlabs.eve.api.corporation.CorporationAccountBalanceRequest;
import com.tlabs.eve.api.corporation.CorporationAssetsRequest;
import com.tlabs.eve.api.corporation.CorporationBookmarksRequest;
import com.tlabs.eve.api.corporation.CorporationContactListParser;
import com.tlabs.eve.api.corporation.CorporationContactListRequest;
import com.tlabs.eve.api.corporation.CorporationContractBidsRequest;
import com.tlabs.eve.api.corporation.CorporationContractItemsRequest;
import com.tlabs.eve.api.corporation.CorporationContractsRequest;
import com.tlabs.eve.api.corporation.CorporationIndustryJobsRequest;
import com.tlabs.eve.api.corporation.CorporationItemLocationRequest;
import com.tlabs.eve.api.corporation.CorporationKillLogRequest;
import com.tlabs.eve.api.corporation.CorporationMarketOrderRequest;
import com.tlabs.eve.api.corporation.CorporationSheetParser;
import com.tlabs.eve.api.corporation.CorporationSheetRequest;
import com.tlabs.eve.api.corporation.CorporationStandingsRequest;
import com.tlabs.eve.api.corporation.CorporationWalletJournalRequest;
import com.tlabs.eve.api.corporation.CorporationWalletTransactionsRequest;
import com.tlabs.eve.api.corporation.MemberTrackingParser;
import com.tlabs.eve.api.corporation.MemberTrackingRequest;
import com.tlabs.eve.api.corporation.OutpostDetailsParser;
import com.tlabs.eve.api.corporation.OutpostDetailsRequest;
import com.tlabs.eve.api.corporation.OutpostListParser;
import com.tlabs.eve.api.corporation.OutpostListRequest;
import com.tlabs.eve.api.corporation.StarbaseDetailsParser;
import com.tlabs.eve.api.corporation.StarbaseDetailsRequest;
import com.tlabs.eve.api.corporation.StarbaseListParser;
import com.tlabs.eve.api.corporation.StarbaseListRequest;
import com.tlabs.eve.api.mail.ContactNotificationsParser;
import com.tlabs.eve.api.mail.MailBodiesParser;
import com.tlabs.eve.api.mail.MailBodiesRequest;
import com.tlabs.eve.api.mail.MailMessagesParser;
import com.tlabs.eve.api.mail.MailMessagesRequest;
import com.tlabs.eve.api.mail.MailingListsParser;
import com.tlabs.eve.api.mail.MailingListsRequest;
import com.tlabs.eve.api.mail.NotificationTextParser;
import com.tlabs.eve.api.mail.NotificationTextRequest;
import com.tlabs.eve.api.mail.NotificationsParser;
import com.tlabs.eve.api.mail.NotificationsRequest;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

final class EveAPIHelper {

    private static final Map<Class<? extends EveAPIRequest<?>>, Class<? extends EveAPIParser<?>>> parserMap;
    private static final HashMap<String, SoftReference<EveAPIParser<? extends EveAPIResponse>>> parsers;

    static {
        parsers = new HashMap<>();

        parserMap = new HashMap<>();
        parserMap.put(AccessInfoRequest.class, AccessInfoParser.class);

        parserMap.put(AccessInfoRequest.class, AccessInfoParser.class);
        parserMap.put(CallListRequest.class, CallListParser.class);
        parserMap.put(NamesRequest.class, NamesParser.class);
        parserMap.put(ErrorListRequest.class, ErrorListParser.class);

        parserMap.put(SkillTreeRequest.class, SkillTreeParser.class);
        parserMap.put(JournalReferenceTypeRequest.class, JournalReferenceTypeParser.class);
        parserMap.put(AccountStatusRequest.class, AccountStatusParser.class);

        parserMap.put(SovereigntyRequest.class, SovereigntyParser.class);
        parserMap.put(ServerStatusRequest.class, ServerStatusParser.class);
        parserMap.put(StationsRequest.class, StationsParser.class);

        parserMap.put(MailBodiesRequest.class, MailBodiesParser.class);
        parserMap.put(MailingListsRequest.class, MailingListsParser.class);
        parserMap.put(MailMessagesRequest.class, MailMessagesParser.class);
        parserMap.put(NotificationsRequest.class, NotificationsParser.class);
        parserMap.put(NotificationTextRequest.class, NotificationTextParser.class);
        parserMap.put(CharacterContactNotificationsRequest.class, ContactNotificationsParser.class);

        parserMap.put(MemberTrackingRequest.class, MemberTrackingParser.class);

        parserMap.put(OutpostListRequest.class, OutpostListParser.class);
        parserMap.put(OutpostDetailsRequest.class, OutpostDetailsParser.class);
        parserMap.put(StarbaseListRequest.class, StarbaseListParser.class);
        parserMap.put(StarbaseDetailsRequest.class, StarbaseDetailsParser.class);

        parserMap.put(CharacterMarketOrderRequest.class, MarketOrderParser.class);
        parserMap.put(CorporationMarketOrderRequest.class, MarketOrderParser.class);

        parserMap.put(CharacterAccountBalanceRequest.class, AccountBalanceParser.class);
        parserMap.put(CorporationAccountBalanceRequest.class, AccountBalanceParser.class);
        parserMap.put(CharacterAssetsRequest.class, AssetListParser.class);
        parserMap.put(CorporationAssetsRequest.class, AssetListParser.class);
        parserMap.put(CharacterIndustryJobsRequest.class, IndustryJobsParser.class);
        parserMap.put(CorporationIndustryJobsRequest.class, IndustryJobsParser.class);

        parserMap.put(CharacterResearchRequest.class, CharacterResearchParser.class);
        parserMap.put(CharacterSheetRequest.class, CharacterSheetParser.class);
        parserMap.put(CharacterInfoRequest.class, CharacterInfoParser.class);
        parserMap.put(CharacterTrainingQueueRequest.class, CharacterTrainingQueueParser.class);
        parserMap.put(CharacterTrainingRequest.class, CharacterTrainingParser.class);

        parserMap.put(CharacterWalletTransactionsRequest.class, WalletTransactionsParser.class);
        parserMap.put(CorporationWalletTransactionsRequest.class, WalletTransactionsParser.class);
        parserMap.put(CharacterWalletJournalRequest.class, WalletJournalParser.class);
        parserMap.put(CorporationWalletJournalRequest.class, WalletJournalParser.class);

        parserMap.put(CorporationSheetRequest.class, CorporationSheetParser.class);
        parserMap.put(CorporationContractsRequest.class, ContractListParser.class);
        parserMap.put(CharacterContractsRequest.class, ContractListParser.class);
        parserMap.put(CorporationContractItemsRequest.class, ContractItemsParser.class);
        parserMap.put(CharacterContractItemsRequest.class, ContractItemsParser.class);
        parserMap.put(CorporationContractBidsRequest.class, ContractBidsParser.class);
        parserMap.put(CharacterContractBidsRequest.class, ContractBidsParser.class);

        parserMap.put(CorporationContactListRequest.class, CorporationContactListParser.class);
        parserMap.put(CharacterContactListRequest.class, CharacterContactListParser.class);

        parserMap.put(CharacterKillLogRequest.class, com.tlabs.eve.api.mail.KillLogParser.class);
        parserMap.put(CorporationKillLogRequest.class, com.tlabs.eve.api.mail.KillLogParser.class);

        parserMap.put(CharacterItemLocationRequest.class, ItemLocationParser.class);
        parserMap.put(CorporationItemLocationRequest.class, ItemLocationParser.class);

        parserMap.put(CharacterStandingsRequest.class, StandingsParser.class);
        parserMap.put(CorporationStandingsRequest.class, StandingsParser.class);

        parserMap.put(CharacterBookmarksRequest.class, BookmarksParser.class);
        parserMap.put(CorporationBookmarksRequest.class, BookmarksParser.class);

        parserMap.put(CharacterCalendarRequest.class, CharacterCalendarParser.class);
        parserMap.put(CharacterCalendarAttendeesRequest.class, CharacterCalendarAttendeesParser.class);

        parserMap.put(ChatChannelRequest.class, ChatChannelParser.class);

        parserMap.put(PlanetaryColoniesRequest.class, PlanetaryColoniesParser.class);
        parserMap.put(PlanetaryLinksRequest.class, PlanetaryLinksParser.class);
        parserMap.put(PlanetaryPinsRequest.class, PlanetaryPinsParser.class);
        parserMap.put(PlanetaryRoutesRequest.class, PlanetaryRoutesParser.class);

    }

    private EveAPIHelper() {
    }

    @SuppressWarnings("unchecked")
    public static <T extends EveAPIResponse> EveAPIParser<T> getParser(EveAPIRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null EveAPIRequest parameter.");
        }

        SoftReference<EveAPIParser<?>> ref = parsers.get(request.getClass().getName());

        EveParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference(parser);
            parsers.put(request.getClass().getName(), ref);
        }
        return (EveAPIParser<T>) parser;
    }

    private static EveParser<?> createParser(EveAPIRequest<? extends EveAPIResponse> request) {
        final Class<? extends EveParser<?>> parserClass = parserMap.get(request.getClass());
        if (null == parserClass) {
            throw new IllegalArgumentException("No parser found for EveAPIRequest " + request.getClass().getSimpleName());
        }
        try {
            return parserClass.newInstance();
        }
        catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
