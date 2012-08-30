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



public class SetElementPropertyRule extends BaseRule {
	
	private String propertyName = null;	
	
	public SetElementPropertyRule() {
		super();
		this.propertyName = null;
	}
	
	public SetElementPropertyRule(String propertyName) {
		super();
		this.propertyName = propertyName;		
	}
	
	@Override
	public void doBody(String name, String text) {
		Object bean = getDigester().peek();
		if (null == this.propertyName) {
			setProperty(bean, name, text);
			return;
		}
		setProperty(bean, propertyName, text);
	}				
}
