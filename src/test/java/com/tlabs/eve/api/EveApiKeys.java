package com.tlabs.eve.api;

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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

public final class EveApiKeys {
	
	
	public static final class Key {
		public final String keyId;
		public final String keyValue;
		
		public final String id;//complementary id 
		
		private static Key create(String[] split, boolean assertId) {
			Validate.notNull(split, "split");
			Validate.isTrue(split.length > 1, "split length=" + split.length);
			if (split.length == 2) {
				return new Key(split[0], split[1], null, false);
			}
			else {
				return new Key(split[0], split[1], split[2], assertId);
			}
		}
		
		private Key(String keyId, String keyValue, String id, boolean assertId) {
			Validate.isTrue(StringUtils.isNotBlank(keyId), "keyId");
			Validate.isTrue(StringUtils.isNotBlank(keyValue), "keyValue");
			if (assertId) {
				Validate.isTrue(StringUtils.isNotBlank(id), "id");
			}
			this.keyId = keyId;
			this.keyValue = keyValue;
			this.id = id;
		}
	}
	
	public static final Key[] AccountV2;
	public static final Key[] CorporationV2;	
	public static final Key[] CharacterV2;
	static {
		InputStream in = EveApiKeys.class.getResourceAsStream("/apikeys.properties");
		if (null == in) {
			throw new RuntimeException("Cannot find 'apikeys.properties'");
		}
		
		final Map<String, List<Key>> keys = new HashMap<String, List<Key>>();
		try {
			final BufferedReader r = new BufferedReader(new InputStreamReader(in));	
			String l = null;
			while ((l = r.readLine()) != null) {
				l = l.trim();
				if (l.length() == 0) {
					continue;
				}
				if (l.startsWith("#")) {
					continue;
				}
				String[] split = StringUtils.split(l, "=");
				if ((null == split) || (split.length != 2)) {
					continue;
				}
				String property = split[0];
				String value = split[1];
				if (StringUtils.isBlank(property) || StringUtils.isBlank(value)) {
					continue;
				}
				
				String[] splitValue = StringUtils.split(value, ":");
				if ((null == splitValue) || split.length < 2) {
					continue;
				}
				final Key k = Key.create(splitValue, false);
				List<Key> current = keys.get(property);
				if (null == current) {
					current = new LinkedList<Key>();
					keys.put(property, current);
				}
				current.add(k);
			}		
			r.close();
		}
		catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException("Cannot parse 'apikeys.properties'");
		}
		finally {
			IOUtils.closeQuietly(in);
		}
		
		AccountV2 = keys.get("v2.account.full").toArray(new Key[0]);		
		CorporationV2 = keys.get("v2.corporation.full").toArray(new Key[0]);		
		CharacterV2 = keys.get("v2.character.full").toArray(new Key[0]);				
		
	}
	private EveApiKeys() {
		
	}

}
