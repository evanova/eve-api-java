package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import com.tlabs.eve.api.character.CharacterAccountBalanceRequest;
import com.tlabs.eve.api.character.CharacterAssetsRequest;
import com.tlabs.eve.api.character.CharacterContractBidsRequest;
import com.tlabs.eve.api.character.CharacterContractItemsRequest;
import com.tlabs.eve.api.character.CharacterContractsRequest;
import com.tlabs.eve.api.character.CharacterIndustryJobsRequest;
import com.tlabs.eve.api.character.CharacterInfoParser;
import com.tlabs.eve.api.character.CharacterInfoRequest;
import com.tlabs.eve.api.character.CharacterItemLocationRequest;
import com.tlabs.eve.api.character.CharacterMarketOrderRequest;
import com.tlabs.eve.api.character.CharacterResearchParser;
import com.tlabs.eve.api.character.CharacterResearchRequest;
import com.tlabs.eve.api.character.CharacterSheetParser;
import com.tlabs.eve.api.character.CharacterSheetRequest;
import com.tlabs.eve.api.character.CharacterTrainingParser;
import com.tlabs.eve.api.character.CharacterTrainingQueueParser;
import com.tlabs.eve.api.character.CharacterTrainingQueueRequest;
import com.tlabs.eve.api.character.CharacterTrainingRequest;
import com.tlabs.eve.api.character.CharacterWalletJournalRequest;
import com.tlabs.eve.api.character.CharacterWalletTransactionsRequest;
import com.tlabs.eve.api.character.PortraitRequest;
import com.tlabs.eve.api.character.PortraitResponse;
import com.tlabs.eve.api.corporation.CorporationAccountBalanceRequest;
import com.tlabs.eve.api.corporation.CorporationAssetsRequest;
import com.tlabs.eve.api.corporation.CorporationContractBidsRequest;
import com.tlabs.eve.api.corporation.CorporationContractItemsRequest;
import com.tlabs.eve.api.corporation.CorporationContractsRequest;
import com.tlabs.eve.api.corporation.CorporationIndustryJobsRequest;
import com.tlabs.eve.api.corporation.CorporationItemLocationRequest;
import com.tlabs.eve.api.corporation.CorporationLogoRequest;
import com.tlabs.eve.api.corporation.CorporationLogoResponse;
import com.tlabs.eve.api.corporation.CorporationMarketOrderRequest;
import com.tlabs.eve.api.corporation.CorporationSheetParser;
import com.tlabs.eve.api.corporation.CorporationSheetRequest;
import com.tlabs.eve.api.corporation.CorporationWalletJournalRequest;
import com.tlabs.eve.api.corporation.CorporationWalletTransactionsRequest;
import com.tlabs.eve.api.corporation.MemberTrackingParser;
import com.tlabs.eve.api.corporation.MemberTrackingRequest;
import com.tlabs.eve.api.mail.KillLogParser;
import com.tlabs.eve.api.mail.KillLogRequest;
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
import com.tlabs.eve.api.server.MessageOfTheDayParser;
import com.tlabs.eve.api.server.MessageOfTheDayRequest;
import com.tlabs.eve.api.server.ServerStatusParser;
import com.tlabs.eve.api.server.ServerStatusRequest;

final class EveAPIHelper {
    
    private static final Map<Class<? extends EveRequest<?>>, Class<? extends EveParser<?>>> parserMap;    
    private static final HashMap<String, SoftReference<EveParser<? extends EveResponse>>> parsers;
    
    public static final class LogoParser extends ImageParser<CorporationLogoResponse> {
        @Override
        protected CorporationLogoResponse createResponse() {
            return new CorporationLogoResponse();
        }           
    };
    
    public static final class PortraitParser extends ImageParser<PortraitResponse> {   
        @Override
        protected PortraitResponse createResponse() {
            return new PortraitResponse();
        }           
    };
    
    static {
        parsers = new HashMap<String, SoftReference<EveParser<?>>>();
        
        parserMap = new HashMap<Class<? extends EveRequest<?>>, Class<? extends EveParser<?>>>();
        parserMap.put(AccessInfoRequest.class, AccessInfoParser.class);
        
        parserMap.put(AccessInfoRequest.class, AccessInfoParser.class);
        parserMap.put(CallListRequest.class, CallListParser.class);
        parserMap.put(NamesRequest.class, NamesParser.class);
        parserMap.put(ErrorListRequest.class, ErrorListParser.class);
        
        parserMap.put(SkillTreeRequest.class, SkillTreeParser.class);
        parserMap.put(CertificateTreeRequest.class, CertificateTreeParser.class);
        parserMap.put(JournalReferenceTypeRequest.class, JournalReferenceTypeParser.class);
        parserMap.put(AccountStatusRequest.class, AccountStatusParser.class);
        parserMap.put(MessageOfTheDayRequest.class, MessageOfTheDayParser.class);
        parserMap.put(ServerStatusRequest.class, ServerStatusParser.class);
        parserMap.put(ServerStationsRequest.class, ServerStationsParser.class);
        parserMap.put(KillLogRequest.class, KillLogParser.class);
        parserMap.put(MailBodiesRequest.class, MailBodiesParser.class);
        parserMap.put(MailingListsRequest.class, MailingListsParser.class);
        parserMap.put(MailMessagesRequest.class, MailMessagesParser.class);
        parserMap.put(NotificationsRequest.class, NotificationsParser.class);        
        parserMap.put(NotificationTextRequest.class, NotificationTextParser.class);
        
        parserMap.put(MemberTrackingRequest.class, MemberTrackingParser.class);
                
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
        
        
        parserMap.put(CharacterItemLocationRequest.class, ItemLocationParser.class);
        parserMap.put(CorporationItemLocationRequest.class, ItemLocationParser.class);
        
        parserMap.put(CorporationLogoRequest.class, LogoParser.class);
        parserMap.put(PortraitRequest.class, PortraitParser.class);
    }
        
    
    private EveAPIHelper() {}
    

    @SuppressWarnings("unchecked")
    public static <T extends EveResponse> EveParser<T> getParser(EveRequest<T> request) {
        if (null == request) {
            throw new IllegalArgumentException("Null EveRequest parameter.");
        }
        
        SoftReference<EveParser<? extends EveResponse>> ref = parsers.get(request.getClass().getName());
        
        EveParser<?> parser = null;
        if (null != ref) {
            parser = ref.get();
        }
        if (null == parser) {
            parser = createParser(request);
            ref = new SoftReference<EveParser<?>>(parser);
            parsers.put(request.getClass().getName(), ref);
        }        
        return (EveParser<T>)parser;
    }
    

    private static EveParser<?> createParser(EveRequest<? extends EveResponse> request) {
        final Class<? extends EveParser<?>> parserClass = parserMap.get(request.getClass());
        if (null == parserClass) {
            throw new IllegalArgumentException("No parser found for EveAPIRequest " + request.getClass().getSimpleName());
        }
        try {
            return parserClass.newInstance();
        }
        catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
        catch (InstantiationException e) {
            throw new IllegalArgumentException(e.getLocalizedMessage(), e);
        }
    }
}
