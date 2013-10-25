package com.tlabs.eve.parser;

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


import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tlabs.eve.EveParser;
import com.tlabs.eve.EveResponse;

public abstract class AbstractEveParser<T extends EveResponse> extends Object implements EveParser<T> {
	
	protected static final Log LOG = LogFactory.getLog("EveAPI");
	private final Class<T> responseClass;
	
	public AbstractEveParser(final Class<T> responseClass) {
		super();
		Validate.notNull(responseClass);		
		this.responseClass = responseClass;			
	}
	
	protected abstract T doParse(final InputStream in, final T response) throws IOException;
	
	public synchronized final T parse(InputStream in) throws IOException {
		try {			
			T t = responseClass.newInstance();
			doBeforeParse(t);
			t = doParse(in, t);
			t.setParsed(true);
			doAfterParse(t);
			return t;
		}
		catch (IllegalAccessException e) {
			throw new IOException(e.getLocalizedMessage());
		}
		catch (InstantiationException e) {
			throw new IOException(e.getLocalizedMessage());
		}			
	}
	
	protected void doBeforeParse(T t) {
		
	}
	protected void doAfterParse(T t) {
		
	}
}
