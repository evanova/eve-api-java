package com.tlabs.eve.evecentral;

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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public final class EveCentralAPI {

	private static HashMap<String, SoftReference<EveCentralParser<? extends EveCentralResponse>>> parsers = new HashMap<String, SoftReference<EveCentralParser<?>>>();

	private EveCentralAPI() {
	}

	public static <T extends EveCentralResponse> T parse(
			EveCentralRequest<T> request, Reader r) throws IOException {
		EveCentralParser<T> p = getParserImpl(request);
		if (null == p) {
			throw new IOException("No parser found for request "
					+ request.getClass().getName());
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(new BufferedReader(r), out);
		out.close();
		return p.parse(out.toByteArray());
	}

	public static <T extends EveCentralResponse> T parse(
			EveCentralRequest<T> request, byte[] data) throws IOException {
		EveCentralParser<T> p = getParserImpl(request);
		if (null == p) {
			throw new IOException("No parser found for request "
					+ request.getClass().getName());
		}
		return p.parse(data);
	}

	private static <T extends EveCentralResponse> EveCentralParser<T> getParserImpl(
			EveCentralRequest<T> request) throws IOException {
		SoftReference<EveCentralParser<? extends EveCentralResponse>> ref = parsers
				.get(request.getClass().getName());

		EveCentralParser<?> parser = null;
		if (null != ref) {
			parser = ref.get();
		}
		if (null == parser) {
			parser = createParser(request);
			ref = new SoftReference<EveCentralParser<?>>(parser);
			parsers.put(request.getClass().getName(), ref);
		}
		return (EveCentralParser<T>) parser;
	}

	private static EveCentralParser<?> createParser(
			EveCentralRequest<? extends EveCentralResponse> request)
			throws IOException {
		if (null == request) {
			throw new IOException("Null EveCentralRequest parameter.");
		}
		if (request instanceof MarketStatsRequest) {
			return new MarketStatsParser();
		}
		throw new IOException("No parser found for EveAPIRequest "
				+ request.getClass().getSimpleName());
	}

	private static void copy(Reader input, OutputStream output)	throws IOException {
		OutputStreamWriter out = new OutputStreamWriter(output);
		char[] buffer = new char[1024];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			out.write(buffer, 0, n);
		}	
		out.flush();
	}

}
