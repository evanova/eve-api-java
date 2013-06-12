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

public final class EveCentralAPI {

	private EveCentralAPI() {
	}

	public static <T extends EveCentralResponse> T parse(final EveCentralRequest<T> request, Reader r) throws IOException {
		EveCentralParser<T> p = EveCentralAPIHelper.getParser(request);	
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(new BufferedReader(r), out);
		out.close();
		return p.parse(out.toByteArray());
	}

	public static <T extends EveCentralResponse> T parse(EveCentralRequest<T> request, byte[] data) throws IOException {
		final EveCentralParser<T> p = EveCentralAPIHelper.getParser(request);
		return p.parse(data);
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
