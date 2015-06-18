package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.AccountBalance;
import com.tlabs.eve.api.AccountBalanceResponse;
import com.tlabs.eve.api.WalletJournalResponse;
import com.tlabs.eve.api.WalletTransactionsResponse;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public final class CorporationWalletTest extends CorporationApiTest {

    @Test(timeout = 10000)
    public void testCorporationBalance() throws Exception {
        AccountBalanceResponse r = apiCall(new CorporationAccountBalanceRequest(corporationKey.id));

        List<AccountBalance> account = r.getAccountBalance();
        Assert.assertTrue("Account size=0", account.size() > 0);
    }

    @Test(timeout = 10000)
    public void testFullCorporationWallet() throws Exception {
        WalletJournalResponse journal = apiCall(new CorporationWalletJournalRequest(corporationKey.id, 1000));

        WalletTransactionsResponse transactions = apiCall(new CorporationWalletTransactionsRequest(corporationKey.id, 1000));
    }

}
