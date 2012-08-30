package com.tlabs.eve.api.account;

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

import java.util.List;

import org.junit.Test;

import com.tlabs.eve.api.AccessInfoRequest;
import com.tlabs.eve.api.AccessInfoResponse;
import com.tlabs.eve.api.AccountStatusRequest;
import com.tlabs.eve.api.AccountStatusResponse;
import com.tlabs.eve.api.EveApiKeys;
import com.tlabs.eve.api.EveApiTest;
import com.tlabs.eve.api.character.EveCharacter;

public class AccountAccessTest extends EveApiTest {

	@Test(timeout = 10000, expected = IllegalArgumentException.class)
	public void invalidAccountAccessInfo() {
		AccessInfoRequest r = new AccessInfoRequest(EveApiKeys.AccountV2[0].keyId,	"123145");
		AccessInfoResponse q = apiCall(r);
	}

	@Test(timeout = 10000, expected = IllegalArgumentException.class)
	public void invalidCorporationAccessInfo() {
		AccessInfoRequest r = new AccessInfoRequest(EveApiKeys.CorporationV2[0].keyId, "123145");
		AccessInfoResponse q = apiCall(r);
	}

	@Test(timeout = 10000)
	public void validAccountAccessInfo() {
		AccessInfoRequest r = new AccessInfoRequest(EveApiKeys.AccountV2[0].keyId,	EveApiKeys.AccountV2[0].keyValue);
		AccessInfoResponse q = apiCall(r);

		int size = q.getCharacters().size();
		assertTrue("Character count = " + size, size > 0);
		print(q.getCharacters());
	}

	@Test(timeout = 10000)
	public void validCharacterAccessInfo() {
		AccessInfoRequest r = new AccessInfoRequest(
				EveApiKeys.CharacterV2[0].keyId, EveApiKeys.CharacterV2[0].keyValue);

		AccessInfoResponse q = apiCall(r);
		int size = q.getCharacters().size();
		assertTrue("Character count = " + size, size > 0);
		print(q.getCharacters());
	}

	@Test(timeout = 10000)
	public void validCorporationAccessInfo() {
		AccessInfoRequest r = new AccessInfoRequest(
				EveApiKeys.CorporationV2[0].keyId,
				EveApiKeys.CorporationV2[0].keyValue);

		AccessInfoResponse q = apiCall(r);

		int size = q.getCharacters().size();
		assertTrue("Corporation count = " + size, size > 0);
		print(q.getCharacters());
	}
	

	@Test(timeout=10000) 
	public void validAccountRequestV2() {
		AccountStatusRequest r = 
			new AccountStatusRequest(
				EveApiKeys.AccountV2[0].keyId, 
				EveApiKeys.AccountV2[0].keyValue,
				false);
		AccountStatusResponse q = apiCall(r);	
	}
	
	
	@Test(timeout=10000) 
	public void validCharacterRequestV2() {
		AccountStatusRequest r = 
			new AccountStatusRequest(
				EveApiKeys.CharacterV2[0].keyId, 
				EveApiKeys.CharacterV2[0].keyValue,
				false);
		AccountStatusResponse q = apiCall(r);	
	}
	
	/*@Test(timeout=10000) 
	public void validCorporationRequestV2() {
		AccountStatusRequest r = 
			new AccountStatusRequest(
				EveApiKeys.CorporationV2.keyId, 
				EveApiKeys.CorporationV2.keyValue,
				false);
		AccountStatusResponse q = testEveAPI(Api.APIV2, r);	
	}*/
	
	private static final void print(final List<EveCharacter> eves) {
		System.out.println("\nCharacters:");
		for (EveCharacter c : eves) {
			System.out.println(c.getCharacterName() + " - "	+ c.getCorporationName());
		}
	}
}
