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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

import com.tlabs.eve.EveResponse;

public abstract class AbstractYAMLParser<T extends EveResponse> extends AbstractEveParser<T> {
	
	protected static final Log LOG = LogFactory.getLog("EveYAML");
	
	public AbstractYAMLParser(final Class<T> responseClass) {
		super(responseClass);		
	}
	
	protected final T doParse(final InputStream in, final T t) throws IOException {
	    final Yaml yaml = new Yaml();
	    return parse(yaml.load(in), t);
	}

	protected abstract T parse(final Object yaml, final T t) throws IOException;
}
