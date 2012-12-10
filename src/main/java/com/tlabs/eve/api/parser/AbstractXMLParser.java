package com.tlabs.eve.api.parser;

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


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.digester.Digester;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.tlabs.eve.api.EveParser;
import com.tlabs.eve.api.EveResponse;

public abstract class AbstractXMLParser<T extends EveResponse> extends Object implements EveParser<T> {
	
	protected static final Log LOG = LogFactory.getLog("EveAPI");
	
	private final Digester digester;
	private final Class<T> responseClass;
	
	public AbstractXMLParser(final Class<T> responseClass) {
		super();
		Validate.notNull(responseClass);
		
		this.responseClass = responseClass;
		this.digester = new Digester();
		//this.digester.setRules(new ExtendedBaseRules());
		this.digester.setNamespaceAware(false);
		this.digester.setValidating(false);
		
		//BUG Fixes an Android 1.5 (and apparently in 2.1-update1 too) SAX parser bug: cannot have both at the same time,
		//but the Android impl checks those feature against each other incorrectly.
		//This is probably causing or related to the bug described in CharacterSheetParser
		try {
			//this.digester.setFeature("http://xml.org/sax/features/namespaces", false);
			this.digester.setFeature("http://xml.org/sax/features/namespace-prefixes", true);	    
		}
		catch (SAXNotSupportedException e) {
			throw new IllegalStateException(e.getLocalizedMessage());
		}
		catch (SAXNotRecognizedException e) {
			throw new IllegalStateException(e.getLocalizedMessage());
		}
		catch (ParserConfigurationException e) {
			throw new IllegalStateException(e.getLocalizedMessage());
		}
		init(this.digester);			
	}
	
	public final T parse(String s) throws IOException {
		return parse(s.getBytes());
	}
	
    public final T parse(InputStream in) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            IOUtils.copy(in, out);
            return parse(out.toByteArray());
        }
        finally {
            IOUtils.closeQuietly(out);
        }        
	}
    
	@SuppressWarnings("unchecked")
	public synchronized final T parse(byte[] data) throws IOException {
		this.digester.clear();		
		try {			
			T t = responseClass.newInstance();
			doBeforeParse(t);
			this.digester.push(t);
			t = (T)this.digester.parse(new ByteArrayInputStream(data));
			t.setContent(data);
			doAfterParse(t);
			return t;
		}
		catch (IllegalAccessException e) {
			throw new IOException(e.getLocalizedMessage());
		}
		catch (InstantiationException e) {
			throw new IOException(e.getLocalizedMessage());
		}	
		catch (SAXException e) {
			e.printStackTrace(System.err);
			throw new IOException(e.getLocalizedMessage());
		}
		
	}
	protected void doBeforeParse(T t) {
		
	}
	protected void doAfterParse(T t) {
		
	}

	protected void init(Digester digester) {}
	
}
