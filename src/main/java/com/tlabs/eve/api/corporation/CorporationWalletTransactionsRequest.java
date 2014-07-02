package com.tlabs.eve.api.corporation;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
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

import com.tlabs.eve.api.WalletTransactionsResponse;

public final class CorporationWalletTransactionsRequest extends CorporationRequest<WalletTransactionsResponse> {
    public static final int MASK = 2097152;

    public CorporationWalletTransactionsRequest(String corporationID, int walletID) {
        this(corporationID, walletID, 50, -1);
    }

    public CorporationWalletTransactionsRequest(String corporationID, int walletID, int rowCount, long fromID) {
        super(WalletTransactionsResponse.class, "/corp/WalletTransactions.xml.aspx", MASK, corporationID);
        //, accountIndex, 100, -1);
        putParam("accountKey", Integer.toString(walletID));
        putParam("rowCount", Integer.toString(rowCount));
        if (-1 != fromID) {
            putParam("fromID", Long.toString(fromID));
        }
    }

}
