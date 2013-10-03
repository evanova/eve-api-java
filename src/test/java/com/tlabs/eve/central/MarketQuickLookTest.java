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


import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class MarketQuickLookTest extends EveCentralTest {

	@Test(timeout=25000) 
	public void buyOrdersTest() {
		final EveCentralQuickLookRequest q = new EveCentralQuickLookRequest(34l);
		final EveCentralQuickLookResponse r = apiCall(q);		
		assertTrue(r.getTypeID() > 0);		
		assertTrue(StringUtils.isNotBlank(r.getTypeName()));
		assertTrue(r.getBuyOrders().size() > 0);
		
		marketOrderTest(r.getBuyOrders().get(0));		
	}

    @Test(timeout=25000) 
    public void sellOrdersTest() {
        final EveCentralQuickLookRequest q = new EveCentralQuickLookRequest(34l);
        final EveCentralQuickLookResponse r = apiCall(q);
        assertTrue(r.getTypeID() > 0);
        assertTrue(StringUtils.isNotBlank(r.getTypeName()));
        assertTrue(r.getSellOrders().size() > 0);
        marketOrderTest(r.getSellOrders().get(0));        
    }
    
    private void marketOrderTest(final EveCentralOrder order) {        
        //System.err.println(ToStringBuilder.reflectionToString(order, ToStringStyle.MULTI_LINE_STYLE));
        assertTrue(order.getOrderID() > 0);
        assertTrue(order.getPrice() > 0);
    }
    
}
