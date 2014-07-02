package com.tlabs.eve.central;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MarketStatsTest extends EveCentralTest {

    @Test(timeout = 10000)
    public void getTwoMarketStatsTest() {
        //http://api.eve-central.com/api/marketstat?typeid=34&typeid=35&regionlimit=10000002
        final EveCentralStatsRequest q = new EveCentralStatsRequest(new long[] { 34, 35 }, 10000002);
        final EveCentralStatsResponse r = apiCall(q);
        assertNotNull(r);
        assertEquals("Market Prices size mismatch", 2, r.getMarketPrices().size());

    }
}
