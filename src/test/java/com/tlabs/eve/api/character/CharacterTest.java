package com.tlabs.eve.api.character;

import com.tlabs.eve.EveResponse;
import com.tlabs.eve.EveTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class CharacterTest extends EveTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> parameters() {
        final List<Class<? extends CharacterRequest>> parameters = new ArrayList<>();
        /*parameters.add(CharacterAccountBalanceRequest.class);
        parameters.add(CharacterAssetsRequest.class);
        parameters.add(CharacterBookmarksRequest.class);
        parameters.add(CharacterContactListRequest.class);
        parameters.add(CharacterContactNotificationsRequest.class);
        parameters.add(CharacterContractBidsRequest.class);
        parameters.add(CharacterContractsRequest.class);
        parameters.add(CharacterIndustryJobsRequest.class);
        parameters.add(CharacterInfoRequest.class);
        parameters.add(CharacterWalletJournalRequest.class);*/
        parameters.add(CharacterWalletTransactionsRequest.class);
        final List<Object[]> returned = new ArrayList<>(parameters.size());
        for (Object p: parameters) {
            returned.add(new Object[]{p.getClass().getSimpleName(), p});
        }
        return returned;
    }

    private final Class<? extends CharacterRequest> tClass;

    public CharacterTest(final String name, final Class<? extends CharacterRequest> tClass) {
        this.tClass = tClass;
    }

    @Test
    public void testCharacterRequest() throws Exception {
        final long characterID = getCharacter().getCharacters().get(0).getCharacterID();
        final CharacterRequest request = tClass.getDeclaredConstructor(String.class).newInstance(Long.toString(characterID));
        EveResponse response = execute(request);
        System.out.println(response.getDateTime());
    }
}
