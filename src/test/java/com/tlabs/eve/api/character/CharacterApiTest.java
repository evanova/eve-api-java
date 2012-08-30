package com.tlabs.eve.api.character;

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


import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.AssetListResponse;
import com.tlabs.eve.api.ContractListResponse;
import com.tlabs.eve.api.EveApiKeys;
import com.tlabs.eve.api.EveApiTest;
import com.tlabs.eve.api.EveAsset;
import com.tlabs.eve.api.EveItem;
import com.tlabs.eve.api.IndustryJobsResponse;
import com.tlabs.eve.api.ItemLocationResponse;
import com.tlabs.eve.api.MarketOrderResponse;

public final class CharacterApiTest extends EveApiTest {

	@Before
	public void onCharacterSetup() {
		setKeyID(EveApiKeys.CharacterV2[0].keyId);
		setKeyValue(EveApiKeys.CharacterV2[0].keyValue);
	}

	@Test(timeout=10000)
	public void testCharacterSheets() {
		CharacterSheetResponse s1 =  
			apiCall(new CharacterSheetRequest(EveApiKeys.CharacterV2[0].id));		
		Assert.assertNotNull("Null character", s1.getCharacter());
		Assert.assertEquals("Wrong character name " + EveApiKeys.CharacterV2[0].id, "Evanova Android", s1.getCharacter().getCharacterName());
		
		setKeyID(EveApiKeys.CharacterV2[1].keyId);
		setKeyValue(EveApiKeys.CharacterV2[1].keyValue);
		CharacterSheetResponse s2 =  
				apiCall(new CharacterSheetRequest(EveApiKeys.CharacterV2[1].id));
		Assert.assertNotNull("Null character", s2.getCharacter());
		Assert.assertEquals("Wrong character name " + EveApiKeys.CharacterV2[1].id, "Tarten Infacen", s2.getCharacter().getCharacterName());
	}	

	@Test(timeout=10000)
	public void testCharacterAssets() {
		AssetListResponse assets = 
			apiCall(new CharacterAssetsRequest(EveApiKeys.CharacterV2[0].id));		
		Assert.assertNotNull("AssetListResponse returned null Assets", assets.getAssets());
		Assert.assertTrue("AssetListResponse returned no Assets", assets.getAssets().size() > 0);
	}	
	
	@Test(timeout=10000)
	public void testCharacterItemLocations() {
		AssetListResponse r = 
			apiCall(new CharacterAssetsRequest(EveApiKeys.CharacterV2[0].id));
		
		final List<EveAsset> assets = r.getAssets();
		Assert.assertNotNull("AssetListResponse returned null Assets", assets);
		Assert.assertTrue("AssetListResponse returned no Assets", assets.size() > 0);
		
		long[] ids = new long[/*assets.size()*/1];
		for (int i = 0; i < ids.length; i++) {
			ids[i] = assets.get(i).getItemID();
		}
		
		final ItemLocationResponse r2 = apiCall(new CharacterItemLocationRequest(EveApiKeys.CharacterV2[0].id, ids));		
		final List<EveItem.Location> locations = r2.getLocations();
		Assert.assertNotNull("EveItemLocationResponse returned null Locations", locations);
		Assert.assertTrue("AssetListResponse returned no Assets", locations.size() > 0);
	}
	
	
	@Test(timeout=10000)
	public void testValidContract() {
		ContractListResponse contracts = 
			apiCall(new CharacterContractsRequest(EveApiKeys.CharacterV2[0].id));
	}
	
	
	@Test(timeout=10000)
	public void testAllCharacterContracts() {
		AccessInfoRequest r = new AccessInfoRequest(
				EveApiKeys.AccountV2[0].keyId, 
				EveApiKeys.AccountV2[0].keyValue);
		
		AccessInfoResponse q = apiCall(r);
		for (EveCharacter c: q.getCharacters()) {
			ContractListResponse contracts = 
				apiCall(new CharacterContractsRequest(String.valueOf(c.getCharacterID()))); 
		}				
	}
	

	@Test(timeout=10000)
	public void testFullMarketOrders() {
		MarketOrderResponse orders = 
			apiCall(new CharacterMarketOrderRequest(EveApiKeys.CharacterV2[0].id));
		
	}	
	
	@Test(timeout=10000)
	public void testIndustryJobs() {		
		IndustryJobsResponse r = apiCall(new CharacterIndustryJobsRequest(EveApiKeys.CharacterV2[0].id));
			
	}
}
